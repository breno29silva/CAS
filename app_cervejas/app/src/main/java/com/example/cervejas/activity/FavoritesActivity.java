package com.example.cervejas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cervejas.R;
import com.example.cervejas.controllers.FavoritesController;
import com.orm.SugarRecord;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBeer;
    private FavoritesController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.screen_favorite_name);

        recyclerViewBeer = findViewById(R.id.recyclerViewFavorite);
        controller = new FavoritesController(recyclerViewBeer, FavoritesActivity.this);

        controller.showRecycleView();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
