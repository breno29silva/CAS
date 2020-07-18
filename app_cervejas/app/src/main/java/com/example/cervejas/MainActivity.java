package com.example.cervejas;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.activity.BeearDetails_activity;
import com.example.cervejas.adapter.Beer_adapter;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBeer;
    private List<Beer> beers;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewBeer = findViewById(R.id.recyclerViewBeer);
        beers = new ArrayList<>();
        controller = new MainController();

        //Recuperando dados
        beers = (List<Beer>) getIntent().getSerializableExtra("listBeers");

        //Configurando Adapter
        final Beer_adapter adapter = new Beer_adapter(beers);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewBeer.setLayoutManager(layoutManager);
        recyclerViewBeer.setHasFixedSize(true);
        recyclerViewBeer.setAdapter(adapter);

        recyclerViewBeer.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recyclerViewBeer,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Beer selectedBeer = beers.get(position);

                        Intent intent = new Intent(MainActivity.this, BeearDetails_activity.class);
                        intent.putExtra("selectBeer", selectedBeer);
                        startActivity(intent);

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