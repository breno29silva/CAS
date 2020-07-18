package com.example.cervejas.utils;

import android.widget.ImageView;

import com.example.cervejas.R;
import com.squareup.picasso.Picasso;

public class Images {
    public static void showImages(ImageView imageView, String url) {
        Picasso.get().load(url).error(R.drawable.placeholder).into(imageView);
    }
}
