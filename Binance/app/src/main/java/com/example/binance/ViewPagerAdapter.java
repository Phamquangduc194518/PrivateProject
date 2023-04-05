package com.example.binance;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.binance.FuturesFragment;
import com.example.binance.GiaodichFragment;
import com.example.binance.ThitruongFragment;
import com.example.binance.TrangchuFragment;
import com.example.binance.ViFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TrangchuFragment();

            case 1:
                return new ThitruongFragment();

            case 2:
                return new GiaodichFragment();

            case 3:
                return new FuturesFragment();

            case 4:
                return new ViFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
