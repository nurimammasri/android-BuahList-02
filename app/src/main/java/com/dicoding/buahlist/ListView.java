package com.dicoding.buahlist;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListView extends AppCompatActivity {
    ImageView imgPhoto;
    TextView tvName, tvDetail, tvRating;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_fruit);

        imgPhoto = findViewById(R.id.image_buah);
        tvName = findViewById(R.id.nama);
        tvDetail = findViewById(R.id.keterangan);
        tvRating = findViewById(R.id.rating);

        String metropolis = "metropolis.otf";
        Typeface font_metropolis = Typeface.createFromAsset(getAssets(), metropolis);

        tvName.setTypeface(font_metropolis);
        tvDetail.setTypeface(font_metropolis);
        tvRating.setTypeface(font_metropolis);
    }
}
