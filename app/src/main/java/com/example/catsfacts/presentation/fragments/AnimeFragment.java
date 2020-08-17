package com.example.catsfacts.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catsfacts.R;
import com.example.catsfacts.data.GhibliService;
import com.example.catsfacts.interfaces.OnItemClick;
import com.example.catsfacts.models.FilmGhibli;
import com.example.catsfacts.presentation.adapters.FilmAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnimeFragment extends Fragment implements GhibliService.GhibliCallback {
    private FilmAdapter adapter;
    private List<FilmGhibli> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GhibliService ghibliService=new GhibliService();
        ghibliService.getListFilms(this);
        RecyclerView recyclerView = view.findViewById(R.id.rec_view_anime_fr);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();
        adapter = new FilmAdapter(list);
        Log.d("TAG", "onViewCreated: "+recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClick() {
            @Override
            public void onItemClick(int pos) {
                Bundle bundle = new Bundle();
                bundle.putString("id", list.get(pos).getId());
                FilmInfoFragment fragment = new FilmInfoFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.container_fr, fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void onSuccess(List<FilmGhibli> films) {
        adapter.setAll(films);
        Log.e("TAG", "onSuccess: "+films.size());
    }

    @Override
    public void onResponseFilm(FilmGhibli film) {
        Log.e("TAG", "resp " );
    }

    @Override
    public void onFailure(Exception exception) {
        Log.e("TAG", "oshobka " );
    }
}