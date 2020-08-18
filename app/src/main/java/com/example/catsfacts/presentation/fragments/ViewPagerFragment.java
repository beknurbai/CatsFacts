package com.example.catsfacts.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catsfacts.R;
import com.example.catsfacts.presentation.adapters.SlideFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragment extends Fragment {
    private ViewPager viewPager;
    private SlideFragmentAdapter fragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new CatsFactsFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new AnimeFragment());


        viewPager = view.findViewById(R.id.view_pager_in_main);
        fragmentAdapter = new SlideFragmentAdapter(getChildFragmentManager(), fragmentList);
        viewPager.setAdapter(fragmentAdapter);
    }
}