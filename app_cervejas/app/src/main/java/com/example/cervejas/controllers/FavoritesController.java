package com.example.cervejas.controllers;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cervejas.helpers.Helpers;
import com.example.cervejas.activity.FavoritesActivity;
import com.example.cervejas.adapter.FavoritesAdapter;
import com.example.cervejas.model.Beer;
import java.util.ArrayList;
import java.util.List;

public class FavoritesController {

    private RecyclerView recyclerViewFavorite;
    private FavoritesActivity favoritesActivity;
    private FavoritesAdapter adapter;
    private List<Beer> favoriteBeers;
    private Helpers helpers;


    public FavoritesController(RecyclerView recyclerViewFavorite, FavoritesActivity favoritesActivity) {
        this.recyclerViewFavorite = recyclerViewFavorite;
        this.favoritesActivity = favoritesActivity;
        favoriteBeers = new ArrayList<>();
        helpers = new Helpers();

        favoriteBeers = helpers.allFavorite();

        adapter = new FavoritesAdapter(favoriteBeers, favoritesActivity);
    }

    public void showRecycleView() {
        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(favoritesActivity.getApplicationContext());
        recyclerViewFavorite.setLayoutManager(layoutManager);
        recyclerViewFavorite.setHasFixedSize(true);
        recyclerViewFavorite.setAdapter(adapter);
    }
}
