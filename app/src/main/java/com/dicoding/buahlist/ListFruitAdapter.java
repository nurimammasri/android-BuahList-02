package com.dicoding.buahlist;


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

import java.util.ArrayList;


public class ListFruitAdapter extends RecyclerView.Adapter<ListFruitAdapter.ListViewHolder> {

    private ArrayList<Fruit> listFruit;

    public ListFruitAdapter(ArrayList<Fruit> list) {
        this.listFruit = list;
    }

    //Untuk Ketika menekan Area List

    //Objek OnItemClickCallBack
    private OnItemClickCallback onItemClickCallback;

    //Metode Set OnItemClickCallback
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Fruit data);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_fruit, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Fruit fruit = listFruit.get(position);

        //Holder Image
        Glide.with(holder.itemView.getContext())
                .load(fruit.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        //Holder Nama Buah
        holder.tvName.setText(fruit.getNamaBuah());
        //Holder Detail Buah
        holder.tvDetail.setText(fruit.getDetail());
        //HolderRating Buah
        holder.tvRating.setText(fruit.getRating());


        //Holder SetOnClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listFruit.get(holder.getAdapterPosition()));

                //Intent Ke More Detail
                Intent goToDetail = new Intent(v.getContext().getApplicationContext(), MoreDetailFruits.class);
                //Mengirim Data
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



    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail, tvRating;
        //Buat Text format

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.image_buah);
            tvName = itemView.findViewById(R.id.nama);
            tvDetail = itemView.findViewById(R.id.keterangan);
            tvRating = itemView.findViewById(R.id.rating);

        }


    }

}
