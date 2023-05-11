package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class NewAdvert extends AppCompatActivity {

    DatabaseHelper db;
    String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button3 = findViewById(R.id.button3);
        EditText name = findViewById(R.id.name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText description = findViewById(R.id.description);
        EditText date = findViewById(R.id.date);
        EditText location = findViewById(R.id.location);
        EditText phone = findViewById(R.id.phone);
        CheckBox lost = findViewById(R.id.lost);
        CheckBox found = findViewById(R.id.found);

        db = new DatabaseHelper(this);

        lost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                status = "Lost";
                System.out.println(status);

            }
        });

        found.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                status = "Found";
                System.out.println(status);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEdit = name.getText().toString();
                String descEdit = description.getText().toString();
                String dateEdit = date.getText().toString();
                String locEdit = location.getText().toString();
                String phoneEdit = phone.getText().toString();

                long insert = db.insertData(new User(nameEdit, descEdit, dateEdit, locEdit, phoneEdit, status));

                if (insert > 0) {
                    startActivity(new Intent(NewAdvert.this, MainActivity.class));
                    Toast.makeText(NewAdvert.this, "This insert has worked", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(NewAdvert.this, "This insert has not worked", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}