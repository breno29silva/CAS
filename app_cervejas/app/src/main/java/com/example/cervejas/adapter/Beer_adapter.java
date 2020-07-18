package com.example.cervejas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cervejas.R;
import com.example.cervejas.model.Beer;

import java.util.List;

public class Beer_adapter extends RecyclerView.Adapter<Beer_adapter.MyViewHolder> {

    private List<Beer> beers;

    public Beer_adapter(List<Beer> beers) {
        this.beers = beers;
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

        holder.title.setText(beer.getTitle());
        holder.subTitle.setText(beer.getSubTitle());
        holder.btnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        Button btnIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewTitle);
            subTitle = itemView.findViewById(R.id.textViewSubTitle);
            btnIcon = itemView.findViewById(R.id.buttonIcon);
        }
    }
}
