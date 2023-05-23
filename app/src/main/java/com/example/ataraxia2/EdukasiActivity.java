package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EdukasiActivity extends AppCompatActivity {
    ImageButton btnback, btnmenjagakesehatan, btnolahraga, btnmakanansehat;

    ImageButton iconhome, iconolahraga, iconmakanan, icondiagnosa;

    String userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edukasi);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        iconolahraga = findViewById(R.id.menuolahraga3);
        iconhome = findViewById(R.id.menuhome3);
        iconmakanan = findViewById(R.id.menumakanan3);
        icondiagnosa = findViewById(R.id.menudiagnosa3);

        btnback = findViewById(R.id.back);
        btnmenjagakesehatan = findViewById(R.id.btnmenjagakesehatan);
        btnolahraga = findViewById(R.id.btnolahraga);
        btnmakanansehat = findViewById(R.id.btnmakanansehat);

        btnback.setOnClickListener(v -> {
            Intent open = new Intent(EdukasiActivity.this, MainActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        iconolahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), OlahragaActivity.class);
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

        iconmakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), MakanannActivity.class);
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

        btnmenjagakesehatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edu_menjagakesehatan);
                ImageButton btnclosemk = findViewById(R.id.btnclosemk);
                btnclosemk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), EdukasiActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnolahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edu_olahraga);
                ImageButton btncloseolahraga = findViewById(R.id.btncloseolahraga);
                btncloseolahraga.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), EdukasiActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnmakanansehat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edu_makanansehat);
                ImageButton btnclosemakansehat = findViewById(R.id.btnclosems);
                btnclosemakansehat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), EdukasiActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });
    }
}