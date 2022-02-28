package com.abao.onmic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    LinearLayout splashLayout, title;
    ShapeableImageView image;


    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashLayout = findViewById(R.id.splashLayout);
        title = findViewById(R.id.title);
        image = findViewById(R.id.image);

        // ANIMATION
        Animation animationIN = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        title.setAnimation(animationIN);
        image.setAnimation(animationIN);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LobbyActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}