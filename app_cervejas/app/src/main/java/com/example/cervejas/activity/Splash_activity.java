package com.example.cervejas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.cervejas.MainActivity;
import com.example.cervejas.R;

public class Splash_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);


        //Esconder ActionBar
        getSupportActionBar().hide();
        //Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Abrir a mainActivity
                startActivity(new Intent(getBaseContext(), MainActivity.class));

                //Matar activity
                finish();

            }
        }, 1500);
    }


}
