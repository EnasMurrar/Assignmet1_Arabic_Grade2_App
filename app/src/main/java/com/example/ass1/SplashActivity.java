package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView gifImageView = findViewById(R.id.gif_imageView);
        Glide.with(this).asGif().load(R.drawable.childs).into(gifImageView);


        TextView textView = findViewById(R.id.textView2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.jump_anim);
        textView.setAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, FirstActivity.class);
            startActivity(intent);
            finish();
        }, 2000);


    }
}