package com.example.ataraxia2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;



public class LoginActivity extends AppCompatActivity {
    TextView textregister, textforgetpass;
    private FirebaseAuth mAuth;

    boolean inputpasswordVisible;

    EditText inputusername, inputpassword;

    Button btnlogin;

    ImageButton btnback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputusername = findViewById(R.id.inputusername);
        inputpassword = findViewById(R.id.inputpassword);
        textregister = findViewById(R.id.textregister);
        textforgetpass = findViewById(R.id.textforgetpass);
        btnback = findViewById(R.id.btnback1);
        btnlogin = findViewById(R.id.buttonlogin);

        mAuth = FirebaseAuth.getInstance();

        inputpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX()>= inputpassword.getRight()- inputpassword.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = inputpassword.getSelectionEnd();
                        if (inputpasswordVisible) {
                            inputpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0);
                            inputpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            inputpasswordVisible = false;
                        } else {
                            inputpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_24, 0);
                            inputpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            inputpasswordVisible = true;
                        }
                        inputpassword.setSelection(selection);
                        return true;
                    }
                }


                return false;
            }
        });

        btnback.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Halamanpertama.class));
        });

        textregister.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        });

        textforgetpass.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ForgetpasswordActivity.class));
        });

        btnlogin.setOnClickListener(v -> {
            if(inputusername.getText().length()>0 && inputpassword.getText().length()>0) {
                login(inputusername.getText().toString(), inputpassword.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "Data tidak boleh kosong", Toast.LENGTH_LONG).show();
            }

            /**   String user = inputusername.getText().toString();
             String pass = inputpassword.getText().toString();

             if (!user.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
             if (!pass.isEmpty()) {
             mAuth.signInWithEmailAndPassword(user, pass)
             .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
            FirebaseUser user = mAuth.getCurrentUser();
            assert user != null;
            final String userId = user.getUid();
            Toast.makeText(LoginActivity.this, "Login Berhasil ", Toast.LENGTH_SHORT).show();
            Intent keMain = new Intent(LoginActivity.this, MainActivity.class);
            keMain.putExtra("email", userId);
            startActivity(keMain);
            finish();
            }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
            }
            });
             } else {
             inputpassword.setError("Empty fields are not allowed");
             }
             } else if (user.isEmpty()) {
             inputusername.setError("Empty fields are not allowed");
             } else {
             inputusername.setError("Please enter correct email");
             } */

        });
    }

    private void login (String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null) {
                    if(task.getResult().getUser()!=null) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        assert user != null;
                        final String userId = user.getUid();
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("userid", userId);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}