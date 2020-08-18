package com.example.catsfacts.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.catsfacts.R;
import com.example.catsfacts.presentation.fragments.ViewPagerFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, new ViewPagerFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        String currentFragmentName = getSupportFragmentManager().findFragmentById(R.id.container_fr).getClass().getSimpleName();
        Log.d("check", currentFragmentName);
        if (currentFragmentName.equals("FactsFragment")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, new ViewPagerFragment()).commit();
        } else if (currentFragmentName.equals("AnimeFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, new ViewPagerFragment()).commit();
        }
        else {
            super.onBackPressed();
        }

    }
}