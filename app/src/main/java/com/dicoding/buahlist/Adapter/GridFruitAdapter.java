package com.dicoding.buahlist.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.buahlist.Model.Fruit;
import com.dicoding.buahlist.MoreDetailFruits;
import com.dicoding.buahlist.R;

import java.util.ArrayList;

public class GridFruitAdapter extends RecyclerView.Adapter<GridFruitAdapter.GridViewHolder> {
    private ArrayList<Fruit> listFruit;

    public GridFruitAdapter(ArrayList<Fruit> list) {
        this.listFruit = list;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Fruit data);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_fruit, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        final Fruit fruit = listFruit.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listFruit.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvRating.setText(fruit.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listFruit.get(holder.getAdapterPosition()));

                Intent goToDetail = new Intent(v.getContext().getApplicationContext(), MoreDetailFruits.class);
                goToDetail.putExtra("FOTO", fruit.getPhoto());
                goToDetail.putExtra("NAMA_BUAH", fruit.getNamaBuah());
                goToDetail.putExtra("ABOUT", fruit.getMoreDetailBuah());
                goToDetail.putExtra("DESKRIPSI", fruit.getDetail());
                goToDetail.putExtra("RATING", fruit.getRating());

                v.getContext().startActivity(goToDetail);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listFruit.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvRating;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.image_buah);
            tvRating = itemView.findViewById(R.id.rating);
        }
    }

}
