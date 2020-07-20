package com.example.cervejas.controllers;

import android.content.Context;
import android.content.Intent;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.activity.MainActivity;
import com.example.cervejas.R;
import com.example.cervejas.activity.BeearDetails_activity;
import com.example.cervejas.adapter.Beer_adapter;
import com.example.cervejas.api.ApiBeer;
import com.example.cervejas.fragments.FailInternetFragment;
import com.example.cervejas.fragments.LoadingFragment;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.RecyclerItemClickListener;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {
    private MainActivity mainActivity;
    private FailInternetFragment failInternetFragment;
    private LoadingFragment loadingFragment;
    private List<Beer> beers;
    private RecyclerView recyclerViewBeer;
    private Beer_adapter adapter;
    private Call<List<Beer>> beerList;


    public MainController(MainActivity mainActivity, RecyclerView recyclerViewBeer) {
        this.mainActivity = mainActivity;
        this.recyclerViewBeer = recyclerViewBeer;
    }

    public void closeFragment(Fragment fragment) {
        if (fragment != null)
            mainActivity.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }

    public void begin() {

        if (isConnected()) {
            showLoding();
            beerList = ApiBeer.getBeerService().getBeers();
            beerList.enqueue(new Callback<List<Beer>>() {
                @Override
                public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                    if (response.isSuccessful()) {
                        closeFragment(loadingFragment);
                        beers = response.body();
                        adapter = new Beer_adapter(beers, mainActivity);
                        showRecycleView(recyclerViewBeer);
                    } else {
                        Log.d("TAG", "onResponse Error");
                        showNoInternet();
                    }
                }

                @Override
                public void onFailure(Call<List<Beer>> call, Throwable t) {
                    Log.d("TAG", t.getMessage());
                    showNoInternet();
                }
            });
        } else {
            showNoInternet();
        }
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
                        intent.putExtra("selectBeer", (Serializable) selectedBeer);
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


    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    private void showNoInternet() {
        if (failInternetFragment == null)
            failInternetFragment = new FailInternetFragment();
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutMain, failInternetFragment);
        transaction.commit();
    }

    private void showLoding() {
        if (loadingFragment == null)
            loadingFragment = new LoadingFragment();
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutMain, loadingFragment);
        transaction.commit();
    }

    public void searchFilter(String search) {
        //Bucar apenas se o adater for criado
        if (adapter != null)
            adapter.getFilter().filter(search);
    }

    public void update() {
        if (adapter != null)
            adapter.update();
    }


}
