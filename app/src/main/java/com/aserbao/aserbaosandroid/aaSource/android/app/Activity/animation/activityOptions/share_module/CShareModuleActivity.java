package com.aserbao.aserbaosandroid.aaSource.android.app.Activity.animation.activityOptions.share_module;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import android.util.Pair;
import android.view.View;

import com.example.base.base.BaseRecyclerViewActivity;
import com.example.base.base.beans.BaseRecyclerBean;
import com.example.base.utils.data.ASourceUtil;
import com.example.base.utils.data.StaticFinalValues;

public class CShareModuleActivity extends BaseRecyclerViewActivity {
    public static void launch(int whichLinearInterpolator, Activity activity, int position, Pair<View, String>... sharedElements) {
        Intent intent = new Intent(activity, CShareModuleActivity.class);
        intent.putExtra(StaticFinalValues.POSITION,position);
        intent.putExtra(StaticFinalValues.WHICH_INTERPOLATOR, whichLinearInterpolator);
        activity.startActivityForResult(intent, StaticFinalValues.COME_FROM_A_SHARE_MODULE_ACTIVITY, ActivityOptions.makeSceneTransitionAnimation(activity, sharedElements).toBundle());
    }


    @Override
    public void initGetData() {
        changeOrientation(StaticFinalValues.LINEAR_LAYOUTMANAGER, LinearLayoutManager.HORIZONTAL);
        int position = getIntent().getIntExtra(StaticFinalValues.POSITION, 0);
        mOpenglRecyclerView.setTransitionName(String.valueOf(ASourceUtil.imageUrls[position]));
//        setMode(LinearLayoutManager.HORIZONTAL);
        new PagerSnapHelper().attachToRecyclerView(mOpenglRecyclerView);
        mOpenglRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mBaseRecyclerViewFl.setBackgroundColor(Color.BLACK);
                mOpenglRecyclerView.scrollToPosition(position);
            }
        });
        int[] imageUrl = ASourceUtil.imageUrls;
        for (int i = 0; i < imageUrl.length ; i++) {
            mBaseRecyclerBean.add(new BaseRecyclerBean(imageUrl[i%imageUrl.length],StaticFinalValues.VIEW_FULL_IMAGE_ITEM));
        }
    }

    @Override
    public void itemClickBack(View view, int position, boolean isLongClick, int comeFrom) {
//        mOpenglRecyclerView.setTransitionName(String.valueOf(ASourceUtil.imageUrls[position]));
        mOpenglRecyclerView.setTransitionName(String.valueOf(ASourceUtil.imageUrls[0]));
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
