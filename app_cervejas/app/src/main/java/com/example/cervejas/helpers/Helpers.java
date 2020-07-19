package com.example.cervejas.helpers;

import com.example.cervejas.model.Beer;

import java.util.List;

public class Helpers {


    public void saveData(Beer beer) {
        beer.setId(beer.getId());
        beer.save();
    }

    public List<Beer> allFavorite() {
        List<Beer> favoriteBeers = Beer.listAll(Beer.class);

        return favoriteBeers;
    }


    public void deleteFavorite(Long id) {
        Beer beer = Beer.findById(Beer.class, id);
        beer.delete();
    }


}
