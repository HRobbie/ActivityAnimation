package com.hrobbie.activityanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_common;
    private Button btn_explode;
    private Button btn_fade;
    private Button btn_share;
    private Button btn_circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_common = (Button)findViewById(R.id.btn_common);
        btn_common.setOnClickListener(this);
        btn_explode = (Button)findViewById(R.id.btn_explode);
        btn_explode.setOnClickListener(this);
        btn_fade = (Button)findViewById(R.id.btn_fade);
        btn_fade.setOnClickListener(this);
        btn_share = (Button)findViewById(R.id.btn_share);
        btn_share.setOnClickListener(this);
        btn_circle = (Button)findViewById(R.id.btn_circle);
        btn_circle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_common://先放大，后缩小
                Intent intent1 = new Intent(this, CommonActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.screen_zoom_in,R.anim.screen_zoom_out);
                break;
            case R.id.btn_explode:
                Intent intent2 = new Intent(this, ExplodeActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_fade:
                Intent intent3 = new Intent(this, FadeActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_share:
                Intent intent4 = new Intent(this, ShareActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_circle:
                Intent intent5 = new Intent(this, CircleActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
