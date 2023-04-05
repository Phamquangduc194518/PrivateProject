package com.example.binance.vi.future;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.binance.R;
import com.google.android.material.tabs.TabLayout;


public class FutureFragment extends Fragment {
    private TabLayout mTab;
    private ViewPager viewPager;
    private View mView;
    private FutureViewPagerAdapter viewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_future, container, false);
        mTab= mView.findViewById(R.id.tl_future_vi);
        viewPager=mView.findViewById(R.id.view_Pager);
        viewPagerAdapter= new FutureViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        mTab.setupWithViewPager(viewPager);
        return mView;
    }
}