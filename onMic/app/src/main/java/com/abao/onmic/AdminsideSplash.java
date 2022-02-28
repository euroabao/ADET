package com.abao.onmic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdminsideSplash extends AppCompatActivity {

    LinearLayout logo;
    TextView title, welcome;

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminside_splash);

        title = findViewById(R.id.title);
        logo = findViewById(R.id.splashLayout);
        welcome = findViewById(R.id.welcome);

        // ANIMATION
        Animation animationIN = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        title.setAnimation(animationIN);
        logo.setAnimation(animationIN);
        welcome.setAnimation(animationIN);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AdminsideSplash.this, AdminsideContentActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}