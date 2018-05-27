package com.example.fragmentation_rxjava_retrofit.base;

import java.util.List;

/**
 * Created by mac on 2018/5/27.
 */

public interface PermissionListener {

        void onGranted();

        void onDenied(List<String> deniedPermissions);

}
