package com.example.cervejas;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.AdapterView;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.activity.BeearDetails_activity;
import com.example.cervejas.adapter.Beer_adapter;
import com.example.cervejas.fragments.FailInternetFragment;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.RecyclerItemClickListener;

import java.util.List;

public class MainController {
    private MainActivity mainActivity;
    private FailInternetFragment failInternetFragment;
    private List<Beer> beers;
    private RecyclerView recyclerViewBeer;
    private Beer_adapter adapter;


    public MainController(MainActivity mainActivity, List<Beer> beers, RecyclerView recyclerViewBeer) {
        this.mainActivity = mainActivity;
        this.recyclerViewBeer = recyclerViewBeer;
        this.beers = beers;
        this.adapter = new Beer_adapter(this.beers);
    }


    public void showScreen() {
        if (!isConnected()) {
            showNoInternet();
        } else {
            showRecycleView(recyclerViewBeer);
        }
    }


    private boolean isConnected() {
        //Verificando conecao
        ConnectivityManager cm =
                (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }


    private void showRecycleView(RecyclerView recyclerViewBeer) {
        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainActivity.getApplicationContext());
        recyclerViewBeer.setLayoutManager(layoutManager);
        recyclerViewBeer.setHasFixedSize(true);
        recyclerViewBeer.setAdapter(adapter);

        recyclerViewBeer.addOnItemTouchListener(new RecyclerItemClickListener(mainActivity.getApplicationContext(),
                recyclerViewBeer,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Beer selectedBeer = beers.get(position);
                        //Passando dados para BeearDetails_activity
                        Intent intent = new Intent(mainActivity, BeearDetails_activity.class);
                        intent.putExtra("selectBeer", selectedBeer);
                        mainActivity.startActivity(intent);

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

    private void showNoInternet() {
        failInternetFragment = new FailInternetFragment();
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutMain, failInternetFragment);
        transaction.commit();
    }

    public void updateRecyclerView(){
        adapter.notifyDataSetChanged();
    }

}
