package com.example.cervejas.controllers;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.activity.BeearDetails_activity;
import com.example.cervejas.activity.FavoritesActivity;
import com.example.cervejas.adapter.Favorites_adapter;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.RecyclerItemClickListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FavoritesController {

    private RecyclerView recyclerViewFavorite;
    private FavoritesActivity favoritesActivity;
    private Favorites_adapter adapter;
    private List<Beer> favoriteBeers;


    public FavoritesController(RecyclerView recyclerViewFavorite, FavoritesActivity favoritesActivity) {
        this.recyclerViewFavorite = recyclerViewFavorite;
        this.favoritesActivity = favoritesActivity;
        adapter = new Favorites_adapter();
        favoriteBeers = new ArrayList<>();
        favoriteBeers = Beer.listAll(Beer.class);
    }

   public void showRecycleView() {
        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(favoritesActivity.getApplicationContext());
       recyclerViewFavorite.setLayoutManager(layoutManager);
       recyclerViewFavorite.setHasFixedSize(true);
       recyclerViewFavorite.setAdapter(adapter);

       recyclerViewFavorite.addOnItemTouchListener(new RecyclerItemClickListener(favoritesActivity.getApplicationContext(),
               recyclerViewFavorite,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Beer selectedBeer = favoriteBeers.get(position);
                        //Passando dados para BeearDetails_activity
                        Intent intent = new Intent(favoritesActivity, BeearDetails_activity.class);
                        intent.putExtra("selectBeer", (Serializable) selectedBeer);
                        favoritesActivity.startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }

}
