package com.example.ataraxia2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Editprofil extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener authStateListener;

    FirebaseUser firebaseUser;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference collectionReference = db.collection("users");

    ImageButton backprofil;

    EditText inputnama, inputtanggallahir, inputjeniskelamin, inputusia, inputemail;

    Button btnsimpan;

    String userId;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        backprofil = findViewById(R.id.btnbackeditprofil);
        inputnama = findViewById(R.id.inputnamaa);
        inputtanggallahir = findViewById(R.id.inputdate);
        inputjeniskelamin = findViewById(R.id.inputjeniskelaminn);
        inputusia = findViewById(R.id.inputusiaa);
        inputemail = findViewById(R.id.inputusernamee);
        btnsimpan = findViewById(R.id.buttonSimpan);

        firebaseAuth = firebaseAuth.getInstance();

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        inputtanggallahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Editprofil.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        inputtanggallahir.setText(date);
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
            loadProfile(userId);
        }

        backprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(Editprofil.this, MainActivity.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateptofil(userId);
            }
        });

    }

    private void loadProfile(String userId){
        collectionReference.whereEqualTo("userid", userId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    QuerySnapshot  documentquery = task.getResult();
                    DocumentSnapshot document = documentquery.getDocuments().get(0);

                    inputnama.setText((String)document.get("nama"));
                    inputtanggallahir.setText((String)document.get("tanggal_lahir"));
                    inputjeniskelamin.setText((String)document.get("jenis_kelamin"));
                    inputusia.setText((String)document.get("usia"));
                    inputemail.setText((String)document.get("email"));
                }
            }
        });
    }

    private void updateptofil(String userId){
        final String nama = inputnama.getText().toString().trim();
        final String tanggallahir = inputtanggallahir.getText().toString().trim();
        final String jeniskelamin = inputjeniskelamin.getText().toString().trim();
        final String usia  = inputusia.getText().toString().trim();
        final String email  = inputemail.getText().toString().trim();
        collectionReference.whereEqualTo("userid", userId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    QuerySnapshot documentquery = task.getResult();
                    DocumentSnapshot document = documentquery.getDocuments().get(0);
                    String documentid = document.getId();
                    Map<String, Object> updatedata = new HashMap<>();
                    updatedata.put("nama", nama);
                    updatedata.put("tanggal_lahir", tanggallahir);
                    updatedata.put("jenis_kelamin", jeniskelamin);
                    updatedata.put("usia", usia);
                    updatedata.put("email", email);

                    FirebaseUser firebaseuser;
                    firebaseuser = FirebaseAuth.getInstance().getCurrentUser();

                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(nama)
                            .build();

                    firebaseuser.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "User profile updated.");
                                    }
                                }
                            });

                    firebaseuser.updateEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "User email address updated.");
                                    }
                                }
                            });
                    collectionReference.document(documentid).update(updatedata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Editprofil.this, "Edit data berhasil", Toast.LENGTH_SHORT).show();
                            Intent open = new Intent(Editprofil.this, MainActivity.class);
                            open.putExtra("userid", userId);
                            startActivity(open);
                        }
                    });
                }
            }
        });
    }

}
