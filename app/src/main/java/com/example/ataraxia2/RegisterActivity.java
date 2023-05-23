package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.rpc.Help;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {
    Button btnregister;

    EditText inputnama, inputdate, inputusia, inputusername, inputpassword, inputjeniskelamin;
    ImageButton btnback;

    DatabaseReference reference;

    FirebaseDatabase database;

    private FirebaseUser firebaseUser;

    boolean inputpasswordVisible;

    private FirebaseAuth mAuth;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private CollectionReference collectionReference = db.collection("users");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputnama = findViewById(R.id.inputnama);
        inputdate = findViewById(R.id.inputdate);
        inputusia = findViewById(R.id.inputusia);
        inputusername = findViewById(R.id.inputusername);
        inputpassword = findViewById(R.id.inputpassword);
        inputjeniskelamin = findViewById(R.id.inputjeniskelamin);

        mAuth = FirebaseAuth.getInstance();

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        inputdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        inputdate.setText(date);
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });



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

        btnregister = findViewById(R.id.buttonRegister);
        btnback = findViewById(R.id.btnback);


        btnregister.setOnClickListener(v -> {
            if (inputnama.getText().length()>0 && inputdate.getText().length()>0 && inputjeniskelamin.getText().length()>0 && inputusia.getText().length()>0 &&
                    inputusername.getText().length()>0 && inputpassword.getText().length()>0 && inputpassword.getText().length()>0 ) {
                register(inputnama.getText().toString(), inputusername.getText().toString(), inputpassword.getText().toString());

            } else {
                Toast.makeText(getApplicationContext(), "Data tidak boleh kosong", Toast.LENGTH_LONG).show();
            }

        });

        btnback.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Halamanpertama.class));
        });
    }

    private void register (String nama, String username, String pass) {

        mAuth.createUserWithEmailAndPassword(username, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null) {
                    firebaseUser = mAuth.getCurrentUser();
                    assert firebaseUser != null;
                    final String user = firebaseUser.getUid();

                    String nama = inputnama.getText().toString();
                    String tgllahir = inputdate.getText().toString();
                    String jeniskelamin = inputjeniskelamin.getText().toString();
                    String usia = inputusia.getText().toString();
                    String email = inputusername.getText().toString();
                    String password = inputpassword.getText().toString();

                    saveData(nama, tgllahir, jeniskelamin, usia, email, password, user);

                    //HelperClass helperClass = new HelperClass(nama, tgllahir, jeniskelamin, usia, email, password);
                    //reference.child(nama).setValue(helperClass);

                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser != null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(nama)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(RegisterActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    i.putExtra("userId", user);
                    i.putExtra("nama", nama);
                    i.putExtra("email", email);
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        firebaseUser = mAuth.getCurrentUser();
        if(firebaseUser != null){

        }
    }

    private void saveData (String nama, String tgllahir, String jeniskelamin, String usia, String email, String pass, String userid) {
        Map<String, Object> user = new HashMap<>();
        user.put("nama", nama);
        user.put("tanggal_lahir", tgllahir);
        user.put("jenis_kelamin", jeniskelamin);
        user.put("usia", usia);
        user.put("email", email);
        user.put("pass", pass);
        user.put("userid", userid);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

}