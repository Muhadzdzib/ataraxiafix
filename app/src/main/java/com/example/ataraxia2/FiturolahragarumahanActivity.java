package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class FiturolahragarumahanActivity extends AppCompatActivity {

    Button lunges, squat, situp, pushup, plank, mountainclimbing;
    ImageButton btnbackor;
    private Animation fadein, fadeout;

    String userId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiturolahragarumahan);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        fadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        btnbackor = findViewById(R.id.backolahragarumahan);

        lunges = findViewById(R.id.btnlunges);
        squat = findViewById(R.id.btnsquat);
        situp = findViewById(R.id.btnsitup);
        pushup = findViewById(R.id.btnpushup);
        plank = findViewById(R.id.btnplank);
        mountainclimbing = findViewById(R.id.btnclimbing);




        lunges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             setContentView(R.layout.or_popuplunges);

                ImageButton back1 = findViewById(R.id.backlunges);
                back1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.or_popupsquat);
                ImageButton back2 = findViewById(R.id.backsquat);
                back2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        situp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.or_popupsitup);
                ImageButton back3 = findViewById(R.id.backsitup);
                back3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        pushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.or_popuppushup);
                ImageButton back4 = findViewById(R.id.backpushup);
                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.or_popupplank);
                ImageButton back5 = findViewById(R.id.backplank);
                back5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        mountainclimbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.or_popupmountainclimbing);
                ImageButton back6 = findViewById(R.id.backclimbing);
                back6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
            }
        });

        btnbackor.setOnClickListener(v -> {
            Intent open = new Intent(getApplicationContext(), OlahragaActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        Button btnmulaiolahragarumahan = findViewById(R.id.btnmulaiolahragarumahan);
        btnmulaiolahragarumahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.or_mulailunges);
                ImageButton btnclose = findViewById(R.id.txtclose1);
                Button btnlanjut = findViewById(R.id.btnlanjut1);
                btnclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                        open.putExtra("userid", userId);
                        startActivity(open);
                    }
                });
                btnlanjut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.or_mulaisquat);
                        ImageButton btnclose2 = findViewById(R.id.txtclose2);
                        btnclose2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                                open.putExtra("userid", userId);
                                startActivity(open);
                            }
                        });
                        Button btnlanjut2 = findViewById(R.id.btnlanjut2);

                        btnlanjut2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.or_mulaisitup);
                                ImageButton btnclose3 = findViewById(R.id.txtclose3);
                                Button btnlanjut3 = findViewById(R.id.btnlanjut3);
                                btnclose3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                                        open.putExtra("userid", userId);
                                        startActivity(open);
                                    }
                                });
                                btnlanjut3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setContentView(R.layout.or_mulaipushup);
                                        ImageButton btnclose4 = findViewById(R.id.txtclose4);
                                        Button btnlanjut4 = findViewById(R.id.btnlanjut4);
                                        btnclose4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                                                open.putExtra("userid", userId);
                                                startActivity(open);
                                            }
                                        });
                                        btnlanjut4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                setContentView(R.layout.or_mulaiplank);
                                                ImageButton btnclose5 = findViewById(R.id.txtclose5);
                                                Button btnlanjut5 = findViewById(R.id.btnlanjut5);
                                                btnclose5.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                                                        open.putExtra("userid", userId);
                                                        startActivity(open);
                                                    }
                                                });
                                                btnlanjut5.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        setContentView(R.layout.or_mulaimountainclimbing);
                                                        Button btnlanjut6 = findViewById(R.id.btnlanjut6);
                                                        ImageButton btnclose6 = findViewById(R.id.txtclose6);
                                                        btnclose6.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
                                                                open.putExtra("userid", userId);
                                                                startActivity(open);
                                                            }
                                                        });
                                                        btnlanjut6.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                setContentView(R.layout.or_selesai);
                                                                Button btnselesai = findViewById(R.id.txtclose7);
                                                                btnselesai.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        Intent open = new Intent(getApplicationContext(), FiturolahragarumahanActivity.class);
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
        });
    }
    public void switchLayout (View view){
        View mainLayout = findViewById(R.id.layout_olahraga_rumahan);
        mainLayout.startAnimation(fadeout);

        // Delay the layout change until the fade-out animation completes
        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Perform the layout change here
                setContentView(R.layout.or_popuplunges);
                View layoutTwo = findViewById(R.id.layout_lunges);
                layoutTwo.startAnimation(fadein);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}