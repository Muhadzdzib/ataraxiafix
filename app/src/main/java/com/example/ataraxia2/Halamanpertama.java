package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Halamanpertama extends AppCompatActivity {
    Button btnlogin;
    Button btnregister ;

    ImageSlider imageslider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanpertama);

        btnlogin = findViewById(R.id.button1);
        btnregister = findViewById(R.id.button2);

        imageslider = findViewById(R.id.imageslider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slidersatu, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sliderdua, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slidertiga, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sliderempat, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sliderlima, ScaleTypes.FIT));

        imageslider.setImageList(slideModels, ScaleTypes.FIT);

        btnlogin.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });

        btnregister.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        });
    }




}