package com.example.fragmentation_rxjava_retrofit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager.FirstPagerFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager.OtherPagerFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager.SecondPagerFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager.ThirdPagerFragment;

/**
 * Created by wp on 18/6/5.
 */
public class PagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public PagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FirstPagerFragment.newInstance();
        } else if (position == 1){
            return SecondPagerFragment.newInstance(mTitles[position]);
        }else if (position == 2){
            return ThirdPagerFragment.newInstance(mTitles[position]);
        }
        else{
            return OtherPagerFragment.newInstance(mTitles[position]);
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
