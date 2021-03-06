package com.example.cervejas.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiBeer {

    private static final String URL_API = "https://api.punkapi.com";
    final String TAG = "ApiBeer";


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
