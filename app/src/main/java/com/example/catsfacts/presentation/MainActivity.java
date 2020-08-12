package com.example.catsfacts.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.catsfacts.R;
import com.example.catsfacts.presentation.adapters.SlideFragmentAdapter;
import com.example.catsfacts.presentation.fragments.AnimeFragment;
import com.example.catsfacts.presentation.fragments.CatsFactsFragment;
import com.example.catsfacts.presentation.fragments.FilmsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideFragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new CatsFactsFragment());
        fragmentList.add(new FilmsFragment());
        fragmentList.add(new AnimeFragment());


        viewPager = findViewById(R.id.view_pager_in_main);
        fragmentAdapter = new SlideFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(fragmentAdapter);
    }
}