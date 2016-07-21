package com.example.chenhj1.androidview;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class WindowManagerImpl implements WindowManager {
//    ......

    private View[] mViews;
    private ViewRoot[] mRoots;
    private WindowManager.LayoutParams[] mParams;

//    ......

    public void addView(View view, ViewGroup.LayoutParams params)
    {
        addView(view, params, false);
    }

//    ......

    private void addView(View view, ViewGroup.LayoutParams params, boolean nest)
    {
//        ......

        final WindowManager.LayoutParams wparams
                = (WindowManager.LayoutParams)params;

        ViewRoot root;
        View panelParentView = null;

        synchronized (this) {
            // Here's an odd/questionable case: if someone tries to add a
            // view multiple times, then we simply bump up a nesting count
            // and they need to remove the view the corresponding number of
            // times to have it actually removed from the window manager.
            // This is useful specifically for the notification manager,
            // which can continually add/remove the same view as a
            // notification gets updated.
            int index = findViewLocked(view, false);
            if (index >= 0) {
                if (!nest) {
                    throw new IllegalStateException("View " + view
                            + " has already been added to the window manager.");
                }
                root = mRoots[index];
                root.mAddNesting++;
                // Update layout parameters.
                view.setLayoutParams(wparams);
                root.setLayoutParams(wparams, true);
                return;
            }

            // If this is a panel window, then find the window it is being
            // attached to for future reference.
            if (wparams.type >= WindowManager.LayoutParams.FIRST_SUB_WINDOW &&
                    wparams.type <= WindowManager.LayoutParams.LAST_SUB_WINDOW) {
                final int count = mViews != null ? mViews.length : 0;
                for (int i=0; i<count; i++) {
                    if (mRoots[i].mWindow.asBinder() == wparams.token) {
                        panelParentView = mViews[i];
                    }
                }
            }

            root = new ViewRoot(view.getContext());
            root.mAddNesting = 1;

            view.setLayoutParams(wparams);

            if (mViews == null) {
                index = 1;
                mViews = new View[1];
                mRoots = new ViewRoot[1];
                mParams = new WindowManager.LayoutParams[1];
            } else {
                index = mViews.length + 1;
                Object[] old = mViews;
                mViews = new View[index];
                System.arraycopy(old, 0, mViews, 0, index-1);
                old = mRoots;
                mRoots = new ViewRoot[index];
                System.arraycopy(old, 0, mRoots, 0, index-1);
                old = mParams;
                mParams = new WindowManager.LayoutParams[index];
                System.arraycopy(old, 0, mParams, 0, index-1);
            }
            index--;

            mViews[index] = view;
            mRoots[index] = root;
            mParams[index] = wparams;
        }
        // do this last because it fires off messages to start doing things
        root.setView(view, wparams, panelParentView);
    }


//    ......
}
