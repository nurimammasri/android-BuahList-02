package com.dicoding.buahlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String title = "Mode List";
    //untuk deklarasi recycler view
    private RecyclerView rvFruits;
    private ArrayList<Fruit> list = new  ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvFruits = findViewById(R.id.rv_list_item);
        rvFruits.setHasFixedSize(true);

        list.addAll(FruitData.getListData());
        showRecyclerCardView();

    }

    private void showRecyclerList() {
        rvFruits.setLayoutManager(new LinearLayoutManager(this));
        ListFruitAdapter ListFruitAdapter = new ListFruitAdapter(list);
        rvFruits.setAdapter(ListFruitAdapter);

        ListFruitAdapter.setOnItemClickCallback(new ListFruitAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Fruit data) {
                showSelectedFruit(data);
            }
        });
    }

    private void showRecyclerGrid() {
        rvFruits.setLayoutManager(new GridLayoutManager(this, 2));
        GridFruitAdapter gridHeroAdapter = new GridFruitAdapter(list);
        rvFruits.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new GridFruitAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Fruit data) {
                showSelectedFruit(data);
            }
        });
    }

    private void showRecyclerCardView() {
        rvFruits.setLayoutManager(new LinearLayoutManager(this));
        CardViewFruitAdapter cardViewFruitAdapter = new CardViewFruitAdapter(list);
        rvFruits.setAdapter(cardViewFruitAdapter);

        cardViewFruitAdapter.setOnItemClickCallback(new CardViewFruitAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Fruit data) {
                showSelectedFruit(data);
            }
        });
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedFruit(Fruit Fruit) {
        Toast.makeText(this, "Kamu memilih " + Fruit.getNamaBuah(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.menu_about:
                Intent goToAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(goToAbout);
                break;
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;

        }
    }
}