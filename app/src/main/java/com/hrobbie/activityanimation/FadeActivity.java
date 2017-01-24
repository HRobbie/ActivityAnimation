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

public class FadeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_fade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_fade);



        btn_fade = (Button)findViewById(R.id.btn_fade);
        btn_fade.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition fade = TransitionInflater.from(this).inflateTransition(R.transition.fade);
            //退出时使用
            getWindow().setExitTransition(fade);
            //第一次进入时使用
            getWindow().setEnterTransition(fade);
            //再次进入时使用
            getWindow().setReenterTransition(fade);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fade:
                Intent intent = new Intent(this, CommonActivity.class);
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }
}
