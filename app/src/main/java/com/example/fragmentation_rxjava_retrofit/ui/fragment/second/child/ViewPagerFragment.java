package com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.adapter.PagerFragmentAdapter;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;

import butterknife.BindView;


/**
 * Created by wp on 18/6/5.
 */
public class ViewPagerFragment extends BaseMainFragment {
    @BindView(R.id.tab)
     TabLayout mTab;
    @BindView(R.id.viewPager)
     ViewPager mViewPager;

    public static ViewPagerFragment newInstance() {

        Bundle args = new Bundle();
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_second_pager;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initView();
    }

    private void initView() {

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mViewPager.setAdapter(new PagerFragmentAdapter(getChildFragmentManager(),
                getString(R.string.recommend), getString(R.string.hot), getString(R.string.favorite),
                getString(R.string.more)));
        mTab.setupWithViewPager(mViewPager);
    }
}
