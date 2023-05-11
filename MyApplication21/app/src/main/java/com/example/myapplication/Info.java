package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Info extends AppCompatActivity {
    TextView textView4, textView5, textView6, textView7, textView8;
    Button button;
    List<String> name, phone, description, date, location, status;
    DatabaseHelper db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        db = new DatabaseHelper(this);
        status = new ArrayList<>();
        description = new ArrayList<>();
        name = new ArrayList<>();
        phone = new ArrayList<>();
        date = new ArrayList<>();
        location = new ArrayList<>();
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        button = findViewById(R.id.button4);
        showData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num;
                Cursor cursor = db.getData();

                if (cursor.getCount() == 0) {
                    return;
                }


                while (cursor.moveToNext())
                {
                    db.deleteUser(Integer.parseInt(cursor.getString(0)));
                    System.out.println(Integer.parseInt(cursor.getString(0)));
                    startActivity(new Intent(Info.this, MainActivity.class));
                    break;
                }


            }
        });
    }

    public void showData() {
        Cursor cursor = db.getData();
        if (cursor.getCount() == 0) {
            return;
        } else {
            while (cursor.moveToNext()) {
                textView4.setText(cursor.getString(1));
                textView5.setText(cursor.getString(5));
                textView6.setText(cursor.getString(2));
                textView7.setText(cursor.getString(3));
                textView8.setText(cursor.getString(4));

            }
        }


    }

}