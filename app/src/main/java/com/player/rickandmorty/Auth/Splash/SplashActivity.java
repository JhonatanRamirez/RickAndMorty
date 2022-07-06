package com.player.rickandmorty.Auth.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.player.rickandmorty.Auth.LoginByGoogle;
import com.player.rickandmorty.Manager.VolleyManager;
import com.player.rickandmorty.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initSingleton();
        openNewWindows();
    }

    private void openNewWindows() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginByGoogle.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }

    private void initSingleton() {
        VolleyManager.get(this);
    }
}