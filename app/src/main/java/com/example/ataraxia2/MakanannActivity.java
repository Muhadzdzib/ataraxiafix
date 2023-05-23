package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MakanannActivity extends AppCompatActivity {
    ImageButton btnrekomen, btnback, btnpengingat;

    ImageButton iconhome, iconedukasi, iconolahraga, icondiagnosa;

    String userId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanann);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        iconedukasi = findViewById(R.id.menuedukasi4);
        iconhome = findViewById(R.id.menuhome4);
        iconolahraga = findViewById(R.id.menuolahraga4);
        icondiagnosa = findViewById(R.id.menudiagnosa4);

        iconedukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), EdukasiActivity.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });

        iconhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), MainActivity.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });

        iconolahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), OlahragaActivity.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });

        icondiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), diagnosapenyakit.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });


        btnpengingat = findViewById(R.id.btnpengingatmakan);
        btnback = findViewById(R.id.backmakanan);
        btnrekomen = findViewById(R.id.btnrekomendasi);

        btnrekomen.setOnClickListener(v -> {
            Intent open = new Intent(MakanannActivity.this, Fiturrekomendasimakanan.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        btnback.setOnClickListener(v -> {
            Intent open = new Intent(MakanannActivity.this, MainActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        btnpengingat.setOnClickListener(v ->{
            Intent open = new Intent(MakanannActivity.this, PengingatmakanActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });
    }
}