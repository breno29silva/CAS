package com.example.cervejas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.activity.BeearDetails_activity;
import com.example.cervejas.adapter.Beer_adapter;
import com.example.cervejas.fragments.FailInternetFragment;
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
        //Recuperando dados
        beers = (List<Beer>) getIntent().getSerializableExtra("listBeers");
        controller = new MainController(MainActivity.this, beers, recyclerViewBeer);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        controller.showScreen();
    }
}


