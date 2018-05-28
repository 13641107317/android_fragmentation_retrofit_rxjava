package com.example.fragmentation_rxjava_retrofit.ui.fragment.fourth.child;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.fourth.FourthFragment;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wp on 18/6/6.
 */
public class MeFragment extends BaseMainFragment {

    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_fourth_me;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }


    @OnClick(R.id.tv_btn_settings)
    void onClickStart() {
        start(SettingsFragment.newInstance());
    }

    @OnClick(R.id.tv_btn_more)
    void onClickMore() {
        start(SettingsFragment.newInstance());
    }

    @Override
    public boolean onBackPressedSupport() {
        // 这里实际项目中推荐使用 EventBus接耦
        ((FourthFragment) getParentFragment()).onBackToFirstFragment();
        return true;
    }
}
