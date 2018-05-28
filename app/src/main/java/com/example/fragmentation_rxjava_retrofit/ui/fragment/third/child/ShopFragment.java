package com.example.fragmentation_rxjava_retrofit.ui.fragment.third.child;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.third.child.child.ContentFragment;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.third.child.child.MenuListFragment;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wp on 18/2/4.
 */
public class ShopFragment extends BaseMainFragment {
    public static final String TAG = ShopFragment.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static ShopFragment newInstance() {
        Bundle args = new Bundle();

        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_shop;
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

        mToolbar.setTitle(R.string.shop);

        if (findChildFragment(MenuListFragment.class) == null) {
            ArrayList<String> listMenus = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_menu)));
            MenuListFragment menuListFragment = MenuListFragment.newInstance(listMenus);
            loadRootFragment(R.id.fl_list_container, menuListFragment);
            // false:  不加入回退栈;  false: 不显示动画
            loadRootFragment(R.id.fl_content_container, ContentFragment.newInstance(listMenus.get(0)),
                    false, false);
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        // ContentFragment是ShopFragment的栈顶子Fragment,会先调用ContentFragment的onBackPressedSupport方法
        Toast.makeText(_mActivity, "onBackPressedSupport-->return false, " + getString(R.string.upper_process), Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * 替换加载 内容Fragment
     *
     * @param fragment
     */
    public void switchContentFragment(ContentFragment fragment) {
        SupportFragment contentFragment = findChildFragment(ContentFragment.class);
        if (contentFragment != null) {
            contentFragment.replaceFragment(fragment, false);
        }
    }
}
