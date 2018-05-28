package com.example.fragmentation_rxjava_retrofit.ui.fragment.fourth.child;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wp on 18/6/6.
 */
public class SettingsFragment extends BaseMainFragment {
    @BindView(R.id.toolbarSettings)
    Toolbar mToolbar;

    public static SettingsFragment newInstance() {

        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.toolbarSettings)
    void onClickBackPressed() {
        _mActivity.onBackPressed();
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_fourth_settings;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}
