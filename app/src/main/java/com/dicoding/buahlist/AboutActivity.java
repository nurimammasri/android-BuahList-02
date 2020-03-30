package com.dicoding.buahlist;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    TextView nama, email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        //Buat Text format
        String metropolis = "metropolis.otf";
        Typeface font_metropolis = Typeface.createFromAsset(getAssets(), metropolis);

        email = findViewById(R.id.tv_about_email);
        nama = findViewById(R.id.tv_about_nama);

        email.setTypeface(font_metropolis);
        nama.setTypeface(font_metropolis);


    }
}
