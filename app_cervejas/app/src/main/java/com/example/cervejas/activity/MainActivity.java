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


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBeer;

    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewBeer = findViewById(R.id.recyclerViewBeer);

        controller = new MainController(MainActivity.this, recyclerViewBeer);
        controller.begin();
    }

    @Override
    protected void onResume() {
        super.onResume();
        controller.update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        //Desabilitar o icon e de search do telcado
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint(getString(R.string.hint_search));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemFavorite:
                startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                break;
            default:
                break;
        }
        return true;
    }


}



