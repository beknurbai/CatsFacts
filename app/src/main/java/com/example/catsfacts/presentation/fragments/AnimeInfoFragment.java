package com.example.catsfacts.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catsfacts.App;
import com.example.catsfacts.R;
import com.example.catsfacts.data.GhibliService;
import com.example.catsfacts.models.FilmGhibli;

import java.util.List;

public class AnimeInfoFragment extends Fragment implements GhibliService.GhibliCallback {
    private TextView filmsHeading, filmsDesc;
    private FilmGhibli model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filmsHeading = view.findViewById(R.id.film_heading_in_fr);
        filmsDesc = view.findViewById(R.id.film_desc_in_fr);
        if (getArguments() != null) {
            String id = getArguments().getString("id");
            App.ghibliService.getFilmById(id,this );
        }

    }

    @Override
    public void onSuccess(List<FilmGhibli> films) {
        Log.e("TAG", "onSuccess: ");
    }

    @Override
    public void onResponseFilm(FilmGhibli film) {
        filmsHeading.setText(film.getTitle());
        filmsDesc.setText(film.getDescription());
    }

    @Override
    public void onFailure(Exception exception) {
        Log.e("TAG", "onFailure: ",exception );
    }
}