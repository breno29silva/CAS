package com.example.cervejas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.R;
import com.example.cervejas.controllers.MainController;
import com.example.cervejas.model.Beer;

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
        controller.showScreen();

    }

    @Override
    protected void onResume() {
        super.onResume();
        controller.updateRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        //Desabilitar o icon e de search do telcado
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                controller.searchFilter(newText);
                return false;
            }
        });

        return true;
    }
}


