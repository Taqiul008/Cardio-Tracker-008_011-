package com.example.cardio_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/**
 * Will show splash screen.
 */
public class splash_screen extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler=new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(splash_screen.this,recycler_Show.class);
            startActivity(intent);
            finish();
        },3000);
    }
}