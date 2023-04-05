package com.example.binance.vi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.binance.vi.future.FutureFragment;

public class ViViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TongQuanFragment();

            case 1:
                return new GiaoNgayFragment();

            case 2:
                return new FundingFragment();

            case 3:
                return new MarginFragment();

            case 4:
                return new FutureFragment();

            case 5:
                return new EarnFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tổng quan về tài khoản";

            case 1:
                return "Giao Ngay";

            case 2:
                return "Funding";

            case 3:
                return "Margin";

            case 4:
                return "Futures";

            case 5:
                return "Earn";
        }
        return null;
    }
}

