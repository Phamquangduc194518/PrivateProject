package com.example.binance.vi.future;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.binance.vi.future.vithe.ViTheBlankFragment;

public class FutureViewPagerAdapter extends FragmentStatePagerAdapter {
    public FutureViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ViTheBlankFragment();
            case 1:
                return new TaiSanBlankFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Vị thế";
            case 1:
                return "Tài sản";
        }
        return null;
    }
}
