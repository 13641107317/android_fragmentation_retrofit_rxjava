package com.example.fragmentation_rxjava_retrofit.base;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.fragmentation_rxjava_retrofit.R;

import me.yokeyword.fragmentation.SupportFragment;



public class BaseBackFragment extends SupportFragment {

    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressed();
            }
        });
    }
}
