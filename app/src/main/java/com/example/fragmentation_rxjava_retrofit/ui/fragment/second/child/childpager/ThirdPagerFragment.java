package com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.childpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fragmentation_rxjava_retrofit.R;
import com.example.fragmentation_rxjava_retrofit.adapter.HomeAdapter;
import com.example.fragmentation_rxjava_retrofit.base.BaseMainFragment;
import com.example.fragmentation_rxjava_retrofit.entity.Article;
import com.example.fragmentation_rxjava_retrofit.event.TabSelectedEvent;
import com.example.fragmentation_rxjava_retrofit.listener.OnItemClickListener;
import com.example.fragmentation_rxjava_retrofit.ui.MainActivity;
import com.example.fragmentation_rxjava_retrofit.ui.fragment.second.child.DetailFragment;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wp on 18/6/3.
 */
public class ThirdPagerFragment extends BaseMainFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String ARG_TITLE = "arg_title";
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    private HomeAdapter mAdapter;
    private boolean mAtTop = true;
    private int mScrollTotal;
    private String[] mTitles;
    private String[] mContents;

    public static ThirdPagerFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(ARG_TITLE,title);
        ThirdPagerFragment fragment = new ThirdPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_second_pager_first;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        EventBusActivityScope.getDefault(_mActivity).register(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initView();
    }

    private void initView() {

        mTitles = getResources().getStringArray(R.array.array_title);
        mContents = getResources().getStringArray(R.array.array_content);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mAdapter = new HomeAdapter(_mActivity);
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                // 这里的DetailFragment在flow包里
                // 这里是父Fragment启动,要注意 栈层级
                ((SupportFragment) getParentFragment()).start(DetailFragment.newInstance(mAdapter.getItem(position).getTitle()));
            }
        });

        // Init Datas
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int index = (int) (Math.random() * 3);
            Article article = new Article(mTitles[index], mContents[index]);
            articleList.add(article);
        }
        mAdapter.setDatas(articleList);

        mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollTotal += dy;
                if (mScrollTotal <= 0) {
                    mAtTop = true;
                } else {
                    mAtTop = false;
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    private void scrollToTop() {
        mRecy.smoothScrollToPosition(0);
    }

    /**
     * 选择tab事件
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainActivity.SECOND) return;
        if (mAtTop) {
            mRefreshLayout.setRefreshing(true);
            onRefresh();
        } else {
            scrollToTop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }

}
