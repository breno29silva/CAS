package com.example.cervejas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.R;
import com.example.cervejas.model.Beer;
import com.example.cervejas.utils.Images;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

public class Beer_adapter extends RecyclerView.Adapter<Beer_adapter.MyViewHolder> implements Filterable {

    private List<Beer> beers;
    private List<Beer> allBeers;


    public Beer_adapter(List<Beer> beers) {
        this.beers = beers;
        this.allBeers = new ArrayList<>(beers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View beerList = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_adapter, parent, false);

        return new MyViewHolder(beerList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Beer beer = beers.get(position);

        holder.title.setText(beer.getName());
        holder.subTitle.setText(beer.getTagline());
        Images.showImages(holder.imageViewBeer, beer.getImage_url());
        holder.likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;
        LikeButton likeButton;
        ImageView imageViewBeer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewTitle);
            subTitle = itemView.findViewById(R.id.textViewSubTitle);
            likeButton = itemView.findViewById(R.id.star_button);
            imageViewBeer = itemView.findViewById(R.id.imageViewBeer);

        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Beer> filterList = new ArrayList<>();



            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(allBeers);
            } else {
                String filter = constraint.toString().toLowerCase().trim();

                for (Beer beer : allBeers) {
                    if (beer.getName().toLowerCase().contains(filter)) {
                        filterList.add(beer);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            beers.clear();
            beers.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}
