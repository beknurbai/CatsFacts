package com.example.catsfacts.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.catsfacts.R;
import com.example.catsfacts.presentation.adapters.SlideFragmentAdapter;
import com.example.catsfacts.presentation.fragments.AnimeFragment;
import com.example.catsfacts.presentation.fragments.CatsFactsFragment;
import com.example.catsfacts.presentation.fragments.FilmsFragment;
import com.example.catsfacts.presentation.fragments.ViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

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
        }else {
            super.onBackPressed();
        }

    }
}