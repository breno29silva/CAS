package com.example.cervejas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.WindowManager;

import com.example.cervejas.MainActivity;
import com.example.cervejas.R;
import com.example.cervejas.api.ApiBeer;
import com.example.cervejas.model.Beer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash_activity extends AppCompatActivity {
    private List<Beer> beers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);

        ApiBeer apiBeer = new ApiBeer();

        //Esconder ActionBar
        getSupportActionBar().hide();
        //Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        final Call<List<Beer>> beerList = ApiBeer.getBeerService().getBeers();

        beerList.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    beers = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                Log.d("OI", "onResponse: " + t.getLocalizedMessage());

            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("listBeers", (Serializable) beers);
                //Abrir a mainActivity
                //new Intent(getBaseContext(), MainActivity.class)
                startActivity(intent);

                //Matar activity
                finish();

            }
        }, 1500);
    }


}
