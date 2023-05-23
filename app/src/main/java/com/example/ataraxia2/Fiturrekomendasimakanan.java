package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;

public class Fiturrekomendasimakanan extends AppCompatActivity {
    ImageButton btnbackrekomen;

    String userId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiturrekomendasimakanan);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        btnbackrekomen = findViewById(R.id.backrekomen);

        btnbackrekomen.setOnClickListener(v -> {
            Intent open = new Intent(Fiturrekomendasimakanan.this, MakanannActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });
    }
}