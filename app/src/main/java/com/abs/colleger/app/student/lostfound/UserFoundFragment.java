package com.abs.colleger.app.student.lostfound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abs.colleger.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserFoundFragment extends Fragment {
    LinearLayout userLostFoundLayout;
    private final static String TAG = "FoundFragment";
    View view;
    private RecyclerView getFoundRecycler;
    private ArrayList<UserLostFoundData> list;
    private UserLostFoundAdapter adapter;
    private DatabaseReference reference;

    public UserFoundFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_found_user,container, false);

        reference = FirebaseDatabase.getInstance().getReference().child("Lost & Found").child("Found");

        getFoundRecycler=view.findViewById(R.id.userFragmentFound);
        getLostRecycler();
        return view;
    }

    private void getLostRecycler() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    UserLostFoundData data = snapshot.getValue(UserLostFoundData.class);
                    list.add(0,data);
                }

                getFoundRecycler.setHasFixedSize(true);
                getFoundRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter=new UserLostFoundAdapter(getContext(), list);
                getFoundRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Snackbar.make(userLostFoundLayout, databaseError.getMessage(), Snackbar.LENGTH_SHORT).show();

            }
        });
    }
}
