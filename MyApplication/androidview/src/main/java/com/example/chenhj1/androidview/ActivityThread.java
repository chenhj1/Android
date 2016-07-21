package com.example.chenhj1.androidview;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewManager;
import android.view.WindowManager;

public final class ActivityThread {
//    ......

    //Activity创建
    private final void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
//        ......

        Activity a = performLaunchActivity(r, customIntent);

        if (a != null) {
//            ......

            handleResumeActivity(r.token, false, r.isForward);

//            ......
        }

//        ......
    }

    //Activity运行
    final void handleResumeActivity(IBinder token, boolean clearHide, boolean isForward) {
//        ......

        ActivityClientRecord r = performResumeActivity(token, clearHide);

        if (r != null) {
            final Activity a = r.activity;
//            ......

            // If the window hasn't yet been added to the window manager,
            // and this guy didn't finish itself or start another activity,
            // then go ahead and add the window.
            boolean willBeVisible = !a.mStartedActivity;//mStartedActivity标识是否正在启动一个新的Activity组件。
            if (!willBeVisible) {
                try {
                    willBeVisible = ActivityManagerNative.getDefault().willActivityBeVisible(
                            a.getActivityToken());
                } catch (RemoteException e) {
                }
            }
            if (r.window == null && !a.mFinished && willBeVisible) {
                r.window = r.activity.getWindow();
                View decor = r.window.getDecorView();
                decor.setVisibility(View.INVISIBLE);
                ViewManager wm = a.getWindowManager();
                WindowManager.LayoutParams l = r.window.getAttributes();
                a.mDecor = decor;
                l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
//                ......
                if (a.mVisibleFromClient) {
                    a.mWindowAdded = true;
                    wm.addView(decor, l);//调用
                }
            }

//            ......
        }

//        ......
    }

//    ......
}
