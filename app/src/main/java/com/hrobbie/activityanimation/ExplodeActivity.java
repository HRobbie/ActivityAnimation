package com.hrobbie.activityanimation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ExplodeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_explode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_explode);

        btn_explode = (Button)findViewById(R.id.btn_explode);
        btn_explode.setOnClickListener(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
            //退出时使用
            getWindow().setExitTransition(explode);
            //第一次进入时使用
            getWindow().setEnterTransition(explode);
            //再次进入时使用
            getWindow().setReenterTransition(explode);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_explode:
                Intent intent2 = new Intent(this, CommonActivity.class);
                startActivity(intent2, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }
}
