package com.dicoding.picodiploma.pedulipanti.adapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.dicoding.picodiploma.pedulipanti.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Tentang Saya");
    }
}
