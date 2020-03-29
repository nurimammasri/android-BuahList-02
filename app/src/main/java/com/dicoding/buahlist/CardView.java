package com.dicoding.buahlist;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CardView extends AppCompatActivity {
    ImageView imgPhoto;
    TextView tvName, tvDetail, tvRating;
    Button btnMore, btnFavorite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card_fruit);


        String metropolis = "metropolis.otf";
        Typeface font_metropolis = Typeface.createFromAsset(getAssets(), metropolis);


        imgPhoto = findViewById(R.id.image_buah);
        tvName = findViewById(R.id.judul);
        tvDetail = findViewById(R.id.keterangan);
        btnMore = findViewById(R.id.more);
        btnFavorite = findViewById(R.id.favorite);
        tvRating = findViewById(R.id.rating);

        tvName.setTypeface(font_metropolis);
        tvDetail.setTypeface(font_metropolis);
        tvRating.setTypeface(font_metropolis);
        btnFavorite.setTypeface(font_metropolis);
        btnMore.setTypeface(font_metropolis);

    }
}
