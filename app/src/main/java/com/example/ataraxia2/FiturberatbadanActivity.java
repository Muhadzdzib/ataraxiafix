package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FiturberatbadanActivity extends AppCompatActivity {

    ImageButton btnbackturunbb;
    Button btnjogging, btnbersepeda, btnangkatbeban, btnberenang;

    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiturberatbadan);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        btnbackturunbb = findViewById(R.id.backturunbb);

        btnbackturunbb.setOnClickListener(v -> {
            Intent open = new Intent(getApplicationContext(), OlahragaActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        btnjogging = findViewById(R.id.tbbjogging);
        btnbersepeda = findViewById(R.id.tbbbersepeda);
        btnangkatbeban = findViewById(R.id.tbbangkatbeban);
        btnberenang = findViewById(R.id.tbbberenang);

        btnjogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.tbb_popupjogging);
                ImageButton back1 = findViewById(R.id.backjogging);
                back1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnbersepeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.tbb_popupbersepeda);
                ImageButton back2 = findViewById(R.id.backbersepeda);
                back2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnangkatbeban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.tbb_popupangkatbeban);
                ImageButton back3 = findViewById(R.id.backangkatbeban);
                back3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnberenang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.tbb_popupberenang);
                ImageButton back4 = findViewById(R.id.backberenang);
                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });


        Button btnmulai = findViewById(R.id.btnmulaitbb);
        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.tbb_mulaijogging);
                ImageButton btnclose = findViewById(R.id.txtclose1);
                Button btnlanjut = findViewById(R.id.btnlanjut1);
                btnclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
                btnlanjut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.tbb_mulaibersepeda);
                        ImageButton btnclose2 = findViewById(R.id.txtclose2);
                        btnclose2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                                open.putExtra("userid", userId);
                                startActivity(open);
                            }
                        });
                        Button btnlanjut2 = findViewById(R.id.btnlanjut2);

                        btnlanjut2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.tbb_mulaiangkatbeban);
                                ImageButton btnclose3 = findViewById(R.id.txtclose3);
                                Button btnlanjut3 = findViewById(R.id.btnlanjut3);
                                btnclose3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                                        open.putExtra("userid", userId);
                                        startActivity(open);
                                    }
                                });
                                btnlanjut3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setContentView(R.layout.tbb_mulaiberenang);
                                        ImageButton btnclose4 = findViewById(R.id.txtclose4);
                                        Button btnlanjut4 = findViewById(R.id.btnlanjut4);
                                        btnclose4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                                                open.putExtra("userid", userId);
                                                startActivity(open);
                                            }
                                        });
                                        btnlanjut4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                setContentView(R.layout.tbb_selesai);
                                                Button btnselesai = findViewById(R.id.btnselesai);
                                                btnselesai.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent open = new Intent(getApplicationContext(), FiturberatbadanActivity.class);
                                                        open.putExtra("userid", userId);
                                                        startActivity(open);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });

                            }
                        });

                    }
                });

            }
        });
    }
}