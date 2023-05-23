package com.example.ataraxia2;

import static android.util.Patterns.EMAIL_ADDRESS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;



public class ForgetpasswordActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    EditText inputemail;

    Button btnlogin;

    ImageButton btnbackforgotpass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        btnbackforgotpass = findViewById(R.id.backforgotpass);
        btnlogin = findViewById(R.id.buttonlogin);

        btnbackforgotpass.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });

        inputemail = findViewById(R.id.inputemaill);
        auth = FirebaseAuth.getInstance();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputemail.getText().toString();
                if (TextUtils.isEmpty(email) && !EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(ForgetpasswordActivity.this, "Masukkan email yang terdaftar", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ForgetpasswordActivity.this, "Pesan ubah password terkirim ke email anda", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetpasswordActivity.this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}