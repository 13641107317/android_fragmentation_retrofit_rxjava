package com.example.fragmentation_rxjava_retrofit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager.FirstPagerFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager.OtherPagerFragment;

/**
 * Created by wp on 18/6/5.
 */
public class ZhihuPagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public ZhihuPagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FirstPagerFragment.newInstance();
        } else {
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
