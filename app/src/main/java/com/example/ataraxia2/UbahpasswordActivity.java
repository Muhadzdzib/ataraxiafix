package com.example.ataraxia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class UbahpasswordActivity extends AppCompatActivity {

    EditText inputpasslama, inputpassbaru;

    boolean inputpasswordVisible;

    Button btnsimpan;

    ImageButton btnback;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference collectionReference = db.collection("users");

    private FirebaseUser firebaseUser;

    String userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubahpassword);

        inputpasslama = findViewById(R.id.inputpasslama);
        inputpassbaru = findViewById(R.id.inputpassbaru);
        btnsimpan = findViewById(R.id.buttonsimpan);
        btnback = findViewById(R.id.btnback2);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");

        }

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldpass = inputpasslama.getText().toString().trim();
                String newpass = inputpassbaru.getText().toString().trim();

                if (TextUtils.isEmpty(oldpass)) {
                    Toast.makeText(UbahpasswordActivity.this, "Masukkan password lama", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (newpass.length() <6) {
                    Toast.makeText(UbahpasswordActivity.this, "Panjang passsword minimal 6 karakter", Toast.LENGTH_SHORT).show();
                    return;
                }

                updatePassword(oldpass, newpass) ;
            }

            private void updatePassword(String oldpass, String newpass) {
                firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                AuthCredential authCredential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), oldpass);
                firebaseUser.reauthenticate(authCredential).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        firebaseUser.updatePassword(newpass).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                collectionReference.whereEqualTo("userid", userId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if(task.isSuccessful()) {
                                            QuerySnapshot documentquery = task.getResult();
                                            DocumentSnapshot document = documentquery.getDocuments().get(0);
                                            String documentid = document.getId();
                                            Map<String, Object> updatedata = new HashMap<>();
                                            updatedata.put("pass", newpass);

                                            collectionReference.document(documentid).update(updatedata).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                }
                                            });
                                        }
                                    }
                                });
                                Toast.makeText(UbahpasswordActivity.this, "Password berhasil di ubah", Toast.LENGTH_SHORT).show();
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UbahpasswordActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UbahpasswordActivity.this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        inputpasslama.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX()>= inputpasslama.getRight()- inputpasslama.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = inputpasslama.getSelectionEnd();

                        if (inputpasswordVisible) {
                            inputpasslama.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0);
                            inputpasslama.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            inputpasswordVisible = false;
                        } else {
                            inputpasslama.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_24, 0);
                            inputpasslama.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            inputpasswordVisible = true;
                        }
                        inputpasslama.setSelection(selection);
                        return true;
                    }
                }


                return false;
            }
        });

        inputpassbaru.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX()>= inputpassbaru.getRight()- inputpassbaru.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = inputpassbaru.getSelectionEnd();

                        if (inputpasswordVisible) {
                            inputpassbaru.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0);
                            inputpassbaru.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            inputpasswordVisible = false;
                        } else {
                            inputpassbaru.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_24, 0);
                            inputpassbaru.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            inputpasswordVisible = true;
                        }
                        inputpassbaru.setSelection(selection);
                        return true;
                    }
                }


                return false;
            }
        });
    }
}