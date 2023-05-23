package com.example.ataraxia2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    LinearLayout diagnosispenyakit, olahraga, makanan, edukasi;
    ImageButton menuedukasi, menumakanan, menuberanda, menudiagnosa, menuolahraga, menu;

    TextView nama;

    MenuBuilder menuBuilder;

    Dialog myDialog;

    private FirebaseUser firebaseuser;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private CollectionReference collectionReference = db.collection("users");

    String userId;

    ProgressDialog progressDialog;


    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Mohon Ditunggu.......");

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            progressDialog.show();
            userId = extra.getString("userid");
            loadProfile(userId);
        }




        menuberanda = findViewById(R.id.menuberanda);
        menumakanan = findViewById(R.id.menumakanan);
        menudiagnosa = findViewById(R.id.menudiagnosa);
        menuedukasi = findViewById(R.id.menuedukasi);
        menuolahraga = findViewById(R.id.menuolahraga);
        menu = findViewById(R.id.menu);
        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popupmenu, menuBuilder);

        myDialog = new Dialog(this);


        diagnosispenyakit = findViewById(R.id.diagnosispenyakit);
        olahraga = findViewById(R.id.olahraga);
        makanan = findViewById(R.id.makanan);
        edukasi = findViewById(R.id.edukasi);
        nama = findViewById(R.id.nama);

        firebaseuser = FirebaseAuth.getInstance().getCurrentUser();

        /** UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
         .setDisplayName("khoyrul")
         .build();

         firebaseuser.updateProfile(profileUpdates)
         .addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
        Log.d(TAG, "User profile updated.");
        }
        }
        }); */


       // if (firebaseuser.getDisplayName()!=null ) {
        //    nama.setText(firebaseuser.getDisplayName());
       // } else {
       //     nama.setText("login gagal");
      //  }

        olahraga.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, OlahragaActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        makanan.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, MakanannActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        edukasi.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, EdukasiActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        menuedukasi.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, EdukasiActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });
        menumakanan.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, MakanannActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });
        menuberanda.setOnClickListener(v -> {

        });
        menudiagnosa.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, diagnosapenyakit.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });
        menuolahraga.setOnClickListener(v -> {
            Intent open = new Intent(MainActivity.this, OlahragaActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        diagnosispenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MainActivity.this, diagnosapenyakit.class);
                open.putExtra("userid", userId);
                startActivity(open);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuPopupHelper optionMenu = new MenuPopupHelper(MainActivity.this, menuBuilder, view);
                optionMenu.setForceShowIcon(true);

                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menueditprofil:
                                Intent open = new Intent(MainActivity.this, Editprofil.class);
                                open.putExtra("userid", userId);
                                startActivity(open);
                                return true;
                            case R.id.menulogout:
                                ImageButton btnclose;
                                Button btnlogout;
                                myDialog.setContentView(R.layout.logout);

                                btnclose = (ImageButton) myDialog.findViewById(R.id.close);
                                btnlogout = (Button) myDialog.findViewById(R.id.btnlogout);

                                btnclose.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        myDialog.dismiss();
                                    }
                                });

                                btnlogout.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        FirebaseAuth.getInstance().signOut();
                                        startActivity(new Intent(getApplicationContext(), Halamanpertama.class));
                                        finish();
                                    }
                                });
                                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                myDialog.show();

                                return true;
                            case R.id.menuubahpass:
                                Intent openn = new Intent(MainActivity.this, UbahpasswordActivity.class);
                                openn.putExtra("userid", userId);
                                startActivity(openn);
                                return true;
                            default:
                                return false;
                        }
                    }

                    @Override
                    public void onMenuModeChange(@NonNull MenuBuilder menu) {

                    }
                });

                optionMenu.show();
            }
        });
    }

    public void showLogout (View v) {
        ImageButton btnclose;
        Button btnlogout;
        myDialog.setContentView(R.layout.logout);

        btnclose = (ImageButton) myDialog.findViewById(R.id.close);
        btnlogout = (Button) myDialog.findViewById(R.id.btnlogout);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Halamanpertama.class));
                finish();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    private void loadProfile(String userId){


        collectionReference.whereEqualTo("userid", userId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    QuerySnapshot  documentquery = task.getResult();
                    DocumentSnapshot document = documentquery.getDocuments().get(0);
                    nama.setText((String)document.get("nama"));
                    progressDialog.dismiss();
                }
            }
        });
    }


}