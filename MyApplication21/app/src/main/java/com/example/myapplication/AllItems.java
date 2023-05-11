package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AllItems extends AppCompatActivity implements ClickListener {
    RecyclerView recyclerView;

    RecyclerAllItems recyclerViewAdapter;

    List<String> status, description, name, phone, date, location;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_row);
        recyclerView = findViewById(R.id.recyclerView);
        status = new ArrayList<>();
        description = new ArrayList<>();
        recyclerViewAdapter = new RecyclerAllItems(this, status, description, this);
        db = new DatabaseHelper(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showData();

    }

    private void showData() {
        Cursor cursor = db.getData();

        if (cursor.getCount() == 0) {
            return;
        }

        else {
            while (cursor.moveToNext()) {
                status.add(cursor.getString(6));
                description.add(cursor.getString(2));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(AllItems.this, Info.class);
        startActivity(intent);
    }
}

