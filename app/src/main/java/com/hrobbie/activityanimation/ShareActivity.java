package com.hrobbie.activityanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_blue;
    private Button btn_yellow;
    private Button btn_share;

    private View share_blue;
    private View share_yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        btn_blue = (Button)findViewById(R.id.btn_blue);
        btn_blue.setOnClickListener(this);
        btn_yellow = (Button)findViewById(R.id.btn_yellow);
        btn_yellow.setOnClickListener(this);
        btn_share = (Button)findViewById(R.id.btn_share);
        btn_share.setOnClickListener(this);

        share_blue = findViewById(R.id.share_blue);
        share_yellow = findViewById(R.id.share_yellow);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_blue:
                Intent intent1 = new Intent(ShareActivity.this, BlueActivity.class);
                startActivity(intent1, ActivityOptionsCompat.makeSceneTransitionAnimation(ShareActivity.this, share_blue, "sharedBlue").toBundle());
                break;
            case R.id.btn_yellow:
                Pair first = new Pair<>(share_blue, ViewCompat.getTransitionName(share_blue));

                Pair second = new Pair<>(share_yellow, ViewCompat.getTransitionName(share_yellow));
                ActivityOptionsCompat transitionActivityOptions =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(ShareActivity.this, first, second);
                Intent intent2 = new Intent(ShareActivity.this, BlueActivity.class);
                ActivityCompat.startActivity(ShareActivity.this,
                        intent2, transitionActivityOptions.toBundle());
                break;
            case R.id.btn_share:
                Intent intent = new Intent(this, CustomShareActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation
                        (ShareActivity.this, share_blue, "transition_morph_view");
                startActivity(intent, options.toBundle());
                break;
        }
    }
}
