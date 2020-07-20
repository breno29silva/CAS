package com.example.cervejas.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.activity.BeearDetailsActivity;
import com.example.cervejas.activity.FavoritesActivity;
import com.example.cervejas.helpers.Helpers;
import com.example.cervejas.R;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.Images;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.io.Serializable;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MyViewHolder> {

    private List<Beer> favoriteBeers;
    private Helpers helpers;
    private FavoritesActivity favoritesActivity;

    public FavoritesAdapter(List<Beer> favoriteBeers, FavoritesActivity favoritesActivity) {
        this.favoriteBeers = favoriteBeers;
        this.favoritesActivity = favoritesActivity;
        helpers = new Helpers();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View favoritesList = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_adapter, parent, false);

        return new MyViewHolder(favoritesList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Beer favoteBeer = favoriteBeers.get(position);
        holder.title.setText(favoteBeer.getName());
        holder.subTitle.setText(favoteBeer.getTagline());
        Images.showImages(holder.imageViewBeer, favoteBeer.getImage_url());
        holder.favoriteButton.setLiked(true);
        holder.position = position;

        holder.favoriteButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Long id = favoteBeer.getId();
                helpers.deleteFavorite(id);
                favoriteBeers = helpers.allFavorite();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteBeers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;
        LikeButton favoriteButton;
        ImageView imageViewBeer;
        View view;
        int position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.item_layout);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDetails(position);
                }
            });

            title = itemView.findViewById(R.id.textViewTitle);
            subTitle = itemView.findViewById(R.id.textViewSubTitle);
            favoriteButton = itemView.findViewById(R.id.star_button);
            imageViewBeer = itemView.findViewById(R.id.imageViewBeer);

        }
    }

    public void showDetails(int position){
        Beer selectedBeer = favoriteBeers.get(position);
        //Passando dados para BeearDetails_activity
        Intent intent = new Intent(favoritesActivity, BeearDetailsActivity.class);
        intent.putExtra("selectBeer", (Serializable) selectedBeer);
        favoritesActivity.startActivity(intent);
    }

}
