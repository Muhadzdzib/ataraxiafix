package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OlahragaActivity extends AppCompatActivity {
    ImageButton btnback;
    LinearLayout linearrumahan, linearcardio, linearturunbb;

    ImageButton iconhome, iconedukasi, iconmakanan, icondiagnosa;

    private FirebaseUser firebaseuser;

    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olahraga);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        iconedukasi = findViewById(R.id.menuedukasi2);
        iconhome = findViewById(R.id.menuhome2);
        iconmakanan = findViewById(R.id.menumakanan2);
        icondiagnosa = findViewById(R.id.menudiagnosa2);

        firebaseuser = FirebaseAuth.getInstance().getCurrentUser();

        btnback = findViewById(R.id.back1);
        linearcardio = findViewById(R.id.linearcardio);
        linearrumahan = findViewById(R.id.linearrumahan);
        linearturunbb = findViewById(R.id.linearturunbb);

        btnback.setOnClickListener(v -> {
            Intent open = new Intent(OlahragaActivity.this, MainActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        linearrumahan.setOnClickListener(v -> {
            Intent open = new Intent(OlahragaActivity.this, FiturolahragarumahanActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        linearcardio.setOnClickListener(v -> {
            Intent open = new Intent(OlahragaActivity.this, FiturolahragacardioActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        linearturunbb.setOnClickListener(v -> {
            Intent open = new Intent(OlahragaActivity.this, FiturberatbadanActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

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

    }
}