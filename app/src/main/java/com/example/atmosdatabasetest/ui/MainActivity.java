package com.example.atmosdatabasetest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.atmosdatabasetest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.fragment_container, new MainFragment()).addToBackStack(null).commit();
        }
    }
}
