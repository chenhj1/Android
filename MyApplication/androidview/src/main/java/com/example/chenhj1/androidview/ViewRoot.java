package com.example.chenhj1.androidview;

import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;

public final class ViewRoot extends Handler implements ViewParent,
        View.AttachInfo.Callbacks {
//    ......

    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
//    ......

    View mView;
//    ......

    final View.AttachInfo mAttachInfo;
//    ......

    boolean mAdded;
//    ......

    public void setView(View view, WindowManager.LayoutParams attrs,
                        View panelParentView) {
        synchronized (this) {
            if (mView == null) {
                //step 1
                mView = view;

                //step 2
                mWindowAttributes.copyFrom(attrs);
//                ......

                mAttachInfo.mRootView = view;
//                .......

                //step 3
                if (panelParentView != null) {
                    mAttachInfo.mPanelParentWindowToken
                            = panelParentView.getApplicationWindowToken();
                }

                mAdded = true; //viewroot已经关联好view对象。 && 窗口及视图创建过程至此结束。

    //---------------------------------------分割线-----------------------------------------------------

//                ......

                //绘制第一次UI
                requestLayout();

//                ......

                //连接WindowManagerService
                try {
                    res = sWindowSession.add(mWindow, mWindowAttributes,
                            getHostVisibility(), mAttachInfo.mContentInsets,
                            mInputChannel);
                } catch (RemoteException e) {
                    mAdded = false;
                    mView = null;
//                    ......
                    throw new RuntimeException("Adding window failed", e);
                } finally {
                    if (restore) {
                        attrs.restore();
                    }
                }

//                ......
            }

//            ......
        }
    }

//    ......
}
