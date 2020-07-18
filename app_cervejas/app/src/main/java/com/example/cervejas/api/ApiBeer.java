package com.example.cervejas.api;

import android.util.Log;

import com.example.cervejas.model.Beer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiBeer {

    private static final String URL_API = "https://api.punkapi.com";


    private static Retrofit getRetrofit() {

        //Criando retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static IBeerService getBeerService() {

        IBeerService beerService = getRetrofit().create(IBeerService.class);

        return beerService;

    }
}
