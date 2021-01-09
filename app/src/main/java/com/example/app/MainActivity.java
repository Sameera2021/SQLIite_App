package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private CarRVAdapter adapter;
    private DatabaseAccess db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.main_rv);
        fab = findViewById(R.id.main_fab);

        db =  DatabaseAccess.getInstance(this);
        db.open();
        ArrayList<Car> cars = db.getAllCars();
        db.close();
        adapter = new CarRVAdapter(cars);
        rv.setAdapter(adapter);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this,2);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.main_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Submit is clicked", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, "text changed", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(MainActivity.this, "search finshed", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}