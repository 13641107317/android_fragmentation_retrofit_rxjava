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
import com.vondear.rxtools.RxTool;
import com.vondear.rxtools.interfaces.OnDelayListener;
import com.vondear.rxtools.view.dialog.RxDialogLoading;
import com.vondear.rxtools.view.progressing.SpinKitView;
import com.vondear.rxtools.view.progressing.SpriteFactory;
import com.vondear.rxtools.view.progressing.Style;
import com.vondear.rxtools.view.progressing.sprite.Sprite;

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
        /**
         * dialog和loading配合使用 透明网络请求loading
         */

        final RxDialogLoading rxDialog = new RxDialogLoading(getContext(), R.style.Translucent_NoTitle);
        View view1 = rootView.inflate(getContext(), R.layout.spin_kit, null);
        SpinKitView loading = view1.findViewById(R.id.spin_kit);
        final Sprite sprite = SpriteFactory.create(Style.CHASING_DOTS);
        loading.setIndeterminateDrawable(sprite);
        rxDialog.setCancelable(false);
        rxDialog.setContentView(view1);
        rxDialog.show();
        RxTool.delayToDo(2000, new OnDelayListener() {
            @Override
            public void doSomething() {
                rxDialog.dismiss();
                rxDialog.cancel();
            }
        });
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
