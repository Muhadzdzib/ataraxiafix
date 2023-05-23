package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class diagnosapenyakit extends AppCompatActivity {
    ImageButton backdiagnosa;

    CheckBox cxdemamtinggi, cxsakitkepala, cxnyeriotot, cxmualmuntah, cxsakitdibelakangmata, cxpembengkakankelenjar, cxbercakkulit
            , cxmenggigil, cxbatuk, cxkeringatpadamalamhari, cxhilangnafsumakan, cxpenurunanberatbadan, cxlemaslelah, cxgangguanpencernaan
            , cxmimisan;

    Button btndiagnosa;

    ImageButton iconedukasi, iconhome, iconmakanan, iconolahraga;

    String userId;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosapenyakit);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        backdiagnosa = findViewById(R.id.backdiagnosa);
        btndiagnosa = findViewById(R.id.buttondiagnosa);

        cxdemamtinggi = findViewById(R.id.cx_demamtinggi);
        cxsakitkepala = findViewById(R.id.cx_sakitkepala);
        cxnyeriotot = findViewById(R.id.cx_nyeriotot);
        cxmualmuntah = findViewById(R.id.cx_mualdanmuntah);
        cxsakitdibelakangmata = findViewById(R.id.cx_sakitdibelakangmata);
        cxpembengkakankelenjar = findViewById(R.id.cx_pembengkakankelenjar);
        cxbercakkulit = findViewById(R.id.cx_bercakpadakulit);
        cxmenggigil = findViewById(R.id.cx_menggigil);
        cxbatuk = findViewById(R.id.cx_batuk);
        cxkeringatpadamalamhari = findViewById(R.id.cx_keringatpadamalam);
        cxhilangnafsumakan = findViewById(R.id.cx_hilangnafsumakan);
        cxpenurunanberatbadan = findViewById(R.id.cx_penurunanberatbadan);
        cxlemaslelah = findViewById(R.id.cx_lemasmudahlelah);
        cxgangguanpencernaan = findViewById(R.id.cx_gangguanpencernaan);
        cxmimisan = findViewById(R.id.cx_mimisan);

        iconedukasi = findViewById(R.id.menuedukasi1);
        iconhome = findViewById(R.id.menuhome1);
        iconolahraga = findViewById(R.id.menuolahraga1);
        iconmakanan = findViewById(R.id.menumakanan1);

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

        iconmakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(getApplicationContext(), MakanannActivity.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });


        backdiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(diagnosapenyakit.this, MainActivity.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });




        btndiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double totaldemam = 0;
                double totaltbc = 0;
                double totaltipes = 0;

                // gabungan

                if (cxdemamtinggi.isChecked()) {
                    totaldemam += 14.28;
                    totaltbc += 16.66;
                    totaltipes += 12.5;
                }

                if (cxsakitkepala.isChecked()) {
                    totaldemam += 14.28;
                    totaltipes += 12.5;
                }

                if (cxmualmuntah.isChecked()) {
                    totaldemam += 14.28;
                    totaltipes += 12.5;
                }

                if (cxbatuk.isChecked()) {
                    totaltbc += 16.66;
                    totaltipes += 12.5;
                }

                if (cxhilangnafsumakan.isChecked()) {
                    totaltbc += 16.66;
                    totaltipes += 12.5;
                }

                // demam berdarah

                if (cxnyeriotot.isChecked()) { totaldemam += 14.28; }

                if (cxsakitdibelakangmata.isChecked()) { totaldemam += 14.28; }

                if (cxpembengkakankelenjar.isChecked()) { totaldemam += 14.28; }

                if (cxbercakkulit.isChecked()) { totaldemam += 14.28; }

                if (cxdemamtinggi.isChecked() && cxsakitkepala.isChecked() && cxnyeriotot.isChecked() && cxmualmuntah.isChecked() && cxsakitdibelakangmata.isChecked() &&
                        cxpembengkakankelenjar.isChecked() && cxbercakkulit.isChecked()) {
                    totaldemam = 100;
                }

                // tbc

                if (cxmenggigil.isChecked()) { totaltbc += 16.66; }

                if (cxkeringatpadamalamhari.isChecked()) { totaltbc += 16.66; }

                if (cxpenurunanberatbadan.isChecked()) { totaltbc += 16.66; }

                if (cxdemamtinggi.isChecked() && cxmenggigil.isChecked() && cxbatuk.isChecked() && cxkeringatpadamalamhari.isChecked() && cxhilangnafsumakan.isChecked() &&
                        cxpenurunanberatbadan.isChecked()) {
                    totaltbc = 100;
                }

                // tipes

                if (cxlemaslelah.isChecked()) { totaltipes += 12.5; }

                if (cxgangguanpencernaan.isChecked()) { totaltipes += 12.5; }

                if (cxmimisan.isChecked()) { totaltipes += 12.5; }

                if (cxdemamtinggi.isChecked() && cxlemaslelah.isChecked() && cxhilangnafsumakan.isChecked() && cxmualmuntah.isChecked() && cxsakitkepala.isChecked() &&
                        cxgangguanpencernaan.isChecked() && cxbatuk.isChecked() && cxmimisan.isChecked()) {
                    totaltipes = 100;
                }


                setContentView(R.layout.hasil_diagnosa);

                ImageButton closediagnosa = findViewById(R.id.imageclose);
                TextView hasildemam, hasiltbc, hasiltipes;

                hasildemam = findViewById(R.id.hasildemam);
                hasiltbc = findViewById(R.id.hasiltbc);
                hasiltipes = findViewById(R.id.hasiltipes);

                double finalTotaldemam = totaldemam;
                double finalTotaltbc = totaltbc;
                double finalTotaltipes = totaltipes;

                DecimalFormat df = new DecimalFormat("#.##");

                hasildemam.setText("" + df.format(finalTotaldemam) +"%");
                hasiltbc.setText("" + df.format(finalTotaltbc) + "%");
                hasiltipes.setText("" + df.format(finalTotaltipes) + "%");



                closediagnosa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), diagnosapenyakit.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });



            }
        });

    }
}