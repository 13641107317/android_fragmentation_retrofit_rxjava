package com.example.fragmentation_rxjava_retrofit.ui.fragment.fourth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.fourth.child.AvatarFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.fourth.child.MeFragment;

import butterknife.BindView;

/**
 * Created by wp on 18/6/3.
 */
public class FourthFragment extends BaseMainFragment {
   @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static FourthFragment newInstance() {
        Bundle args = new Bundle();
        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_fourth;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mToolbar.setTitle(R.string.me);
        if (findChildFragment(AvatarFragment.class) == null) {
            loadFragment();
        }

    }

    private void loadFragment() {
        loadRootFragment(R.id.fl_fourth_container_upper, AvatarFragment.newInstance());
        loadRootFragment(R.id.fl_fourth_container_lower, MeFragment.newInstance());
    }

    public void onBackToFirstFragment() {
        _mBackToFirstListener.onBackToFirstFragment();
    }
}
