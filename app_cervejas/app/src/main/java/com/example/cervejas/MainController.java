package com.example.cervejas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MainController {
    private Context context;

    public MainController(Context context) {
        this.context = context;
    }


    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }
}
