package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());
    }
}