package com.hrobbie.activityanimation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ArcMotion;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import com.hrobbie.activityanimation.util.CustomChangeBounds;

public class CustomShareActivity extends AppCompatActivity {

    private View share_blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_share);

        share_blue = findViewById(R.id.share_blue);
        // Activity设置自定义 Shared Element切换动画
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //定义ArcMotion
            ArcMotion arcMotion = new ArcMotion();
            arcMotion.setMinimumHorizontalAngle(50f);
            arcMotion.setMinimumVerticalAngle(50f);

            //插值器，控制速度
            Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in);

            //实例化自定义的ChangeBounds
            CustomChangeBounds changeBounds = new CustomChangeBounds();

            changeBounds.setPathMotion(arcMotion);
            changeBounds.setInterpolator(interpolator);
            changeBounds.addTarget(share_blue);

            //将切换动画应用到当前的Activity的进入和返回
            getWindow().setSharedElementEnterTransition(changeBounds);
            getWindow().setSharedElementReturnTransition(changeBounds);
        }



    }
}
