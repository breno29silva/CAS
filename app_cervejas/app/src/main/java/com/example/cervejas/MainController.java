package com.example.cervejas;

import com.example.cervejas.model.Beer;

import java.util.ArrayList;
import java.util.List;

public class MainController {


    public List<Beer> getData() {
        List<Beer> beers = new ArrayList<>();

        Beer beer = new Beer(
                "Scol Beats",
                "ASDSADSADASDSADAS",
                "dsassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                        "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                        "ssssssssssssssssssssssssssssssss",
                "https://images.punkapi.com/v2/2.png");

        beers.add(beer);


        beers.add(new Beer(
                "Título 2",
                "Sub",
                "TESTE URGENTE",
                "https://images.punkapi.com/v2/2.png"));


        return beers;
    }
}
