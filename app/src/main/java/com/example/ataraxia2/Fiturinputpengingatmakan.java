package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Fiturinputpengingatmakan extends AppCompatActivity {
    ImageButton backforminput;

    Button btntambahkan;

    String userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiturinputpengingatmakan);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        backforminput = findViewById(R.id.backforminput);
        btntambahkan = findViewById(R.id.btntambahpengingat);

        backforminput.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PengingatmakanActivity.class));

        });

        btntambahkan.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PengingatmakanActivity.class));
        });

    }
}