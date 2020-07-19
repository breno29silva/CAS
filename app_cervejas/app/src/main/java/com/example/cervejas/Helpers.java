package com.example.cervejas;

import com.example.cervejas.model.Beer;

import java.util.List;

public class Helpers {


    public void saveData(Beer beer) {
        beer.setFavorite(false);
        beer.setId(beer.getId());

        beer.save();
    }

    public List<Beer> allFavorite() {
        List<Beer> favoriteBeers = Beer.listAll(Beer.class);




        return favoriteBeers;
    }

    public void deleteFavorite(Beer beer) {
        beer.delete();
    }


}
