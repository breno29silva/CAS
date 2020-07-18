package com.example.cervejas.api;

import com.example.cervejas.model.Beer;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IBeerService {

    @GET("/v2/beers")
    Call<List<Beer>> getBeers();
}
