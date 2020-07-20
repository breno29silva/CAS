package com.example.cervejas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.WindowManager;

import com.example.cervejas.R;
import com.example.cervejas.api.ApiBeer;
import com.example.cervejas.model.Beer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    private List<Beer> beers = new ArrayList<>();
    private static int SPLASH_TIME_OUT = 1500;
    private final static String TAG = "Splash_activity";

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
        }, SPLASH_TIME_OUT);
    }


}
