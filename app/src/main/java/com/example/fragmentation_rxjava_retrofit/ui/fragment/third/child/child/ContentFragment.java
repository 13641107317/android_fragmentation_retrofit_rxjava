package com.example.fragmentation_rxjava_retrofit.ui.fragment.third.child.child;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.CycleFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.third.child.ShopFragment;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by wp on 18/2/9.
 */
public class ContentFragment extends BaseMainFragment {
    private static final String ARG_MENU = "arg_menu";

    @BindView(R.id.tv_content)
     TextView mTvContent;
    @BindView(R.id.btn_next)
     Button mBtnNext;

    private String mMenu;

    public static ContentFragment newInstance(String menu) {

        Bundle args = new Bundle();
        args.putString(ARG_MENU, menu);

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mMenu = args.getString(ARG_MENU);
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_content;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initView();
    }


    private void initView() {
        mTvContent.setText("Content:\n" + mMenu);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 和MsgFragment同级别的跳转 交给MsgFragment处理
                if (getParentFragment() instanceof ShopFragment) {
                    ((ShopFragment) getParentFragment()).start(CycleFragment.newInstance(1));
                }
            }
        });
    }

    @Override
    public boolean onBackPressedSupport() {
        // ContentFragment是ShopFragment的栈顶子Fragment,可以在此处理返回按键事件
        return super.onBackPressedSupport();
    }
}
