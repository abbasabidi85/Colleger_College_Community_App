package com.abs.colleger.app.admin.lostfound;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class LostFoundViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> clubFragmentList = new ArrayList<>();
        private final List<String> clubFragmentTitleList = new ArrayList<>();

        public LostFoundViewPagerAdapter(@NonNull FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return clubFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return clubFragmentTitleList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return clubFragmentTitleList.get(position);
        }

        public void AddFragment(Fragment clubfragment, String clubtitle){
            clubFragmentList.add(clubfragment);
            clubFragmentTitleList.add(clubtitle);
        }
    }
