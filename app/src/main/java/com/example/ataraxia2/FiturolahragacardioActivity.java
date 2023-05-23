package com.example.ataraxia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class FiturolahragacardioActivity extends AppCompatActivity {
    Button btnlompattali, btnjumpingjack, btnmountainclimbing, btncirclehopsquat, btnjogging;
    ImageButton btnbackcardio;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("image");

    String userId;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiturolahragacardio);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        btnbackcardio = findViewById(R.id.backcardio);

        btnlompattali = findViewById(R.id.btnlompattali);
        btnjumpingjack = findViewById(R.id.btnjumpingjack);
        btncirclehopsquat = findViewById(R.id.btncirclehop);
        btnmountainclimbing = findViewById(R.id.btnmountainclimbing);
        btnjogging = findViewById(R.id.btnjogging);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnlompattali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.oc_popuplompattali);
                ImageButton back1 = findViewById(R.id.backlompattali);
                back1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnjumpingjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.oc_popupjumpingjack);
                ImageButton back2 = findViewById(R.id.backjumpingjack);
                back2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btncirclehopsquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.oc_popupcirclehopsquat);
                ImageButton back3 = findViewById(R.id.backcirclehop);
                back3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnmountainclimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.oc_popupmountainclimbing);
                ImageButton back4 = findViewById(R.id.backmountainclimbing);
                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnjogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.oc_popupjogging);
                ImageButton back5 = findViewById(R.id.backjogging);
                back5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnbackcardio.setOnClickListener(v -> {
            Intent open = new Intent(FiturolahragacardioActivity.this, OlahragaActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        Button btnmulai = findViewById(R.id.btnmulaicardio);
        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.oc_mulailompattali);
                ImageButton btnclose = findViewById(R.id.txtclose);
                Button btnlanjut = findViewById(R.id.btnlanjut);
                btnclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
                btnlanjut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.oc_mulaijumpingjack);
                        ImageButton btnclose2 = findViewById(R.id.txtclose2);
                        btnclose2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                                open.putExtra("userid", userId);
                                startActivity(open);
                            }
                        });
                        Button btnlanjut2 = findViewById(R.id.btnlanjut2);

                        btnlanjut2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.oc_mulaicirclehopsquat);
                                ImageButton btnclose3 = findViewById(R.id.txtclose3);
                                Button btnlanjut3 = findViewById(R.id.btnlanjut3);
                                btnclose3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                                        open.putExtra("userid", userId);
                                        startActivity(open);
                                    }
                                });
                                btnlanjut3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setContentView(R.layout.oc_mulaimountainclimbing);
                                        ImageButton btnclose4 = findViewById(R.id.txtclose4);
                                        Button btnlanjut4 = findViewById(R.id.btnlanjut4);
                                        btnclose4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                                                open.putExtra("userid", userId);
                                                startActivity(open);
                                            }
                                        });
                                        btnlanjut4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                setContentView(R.layout.oc_mulaijogging);
                                                ImageButton btnclose5 = findViewById(R.id.txtclose5);
                                                Button btnlanjut5 = findViewById(R.id.btnlanjut5);
                                                btnclose5.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
                                                        open.putExtra("userid", userId);
                                                        startActivity(open);
                                                    }
                                                });
                                                btnlanjut5.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        setContentView(R.layout.oc_selesai);
                                                        Button btnclose6 = findViewById(R.id.txtclose6);
                                                        btnclose6.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                Intent open = new Intent(getApplicationContext(), FiturolahragacardioActivity.class);
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
        });

    }
}