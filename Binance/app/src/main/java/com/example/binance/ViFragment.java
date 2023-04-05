package com.example.binance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.binance.vi.ViViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class ViFragment extends Fragment {

    private TabLayout mtabLayout;
    private ViewPager viewPager;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_vi, container, false);

        mtabLayout= mView.findViewById(R.id.tabLayout);
        viewPager=mView.findViewById(R.id.vi_view_pager);
        ViViewPagerAdapter viviewPagerAdapter = new ViViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viviewPagerAdapter);
        mtabLayout.setupWithViewPager(viewPager);
        return mView;
    }
}