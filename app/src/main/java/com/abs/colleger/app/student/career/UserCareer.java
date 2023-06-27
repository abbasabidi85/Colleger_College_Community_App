package com.abs.colleger.app.student.career;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.abs.colleger.app.R;
import com.abs.colleger.app.student.timetable.UserFragmentFriday;
import com.abs.colleger.app.student.timetable.UserFragmentMonday;
import com.abs.colleger.app.student.timetable.UserFragmentThursday;
import com.abs.colleger.app.student.timetable.UserFragmentTuesday;
import com.abs.colleger.app.student.timetable.UserFragmentWednesday;
import com.abs.colleger.app.student.timetable.UserViewPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserCareer extends AppCompatActivity {

    private NestedScrollView userClubLayout;
    private RecyclerView clubs,societies;
    private LinearLayout clubsNoData, societiesNoData;
    private UserCareerViewPagerAdapter adapter;

    TabLayout tabLayout;
    ViewPager viewPager;

    MaterialToolbar toolbar;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_career);

        tabLayout=findViewById(R.id.user_careerTabLayout);
        viewPager=findViewById(R.id.user_careerVPager);

        adapter=new UserCareerViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new UserJobsFragment(),"Jobs");
        adapter.AddFragment(new UserSkillsFragment(),"Skills");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        toolbar=findViewById(R.id.userCareerToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}