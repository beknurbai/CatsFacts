package com.example.catsfacts.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catsfacts.R;
import com.example.catsfacts.data.NewsService;
import com.example.catsfacts.interfaces.OnItemClick;
import com.example.catsfacts.models.NewsModels;
import com.example.catsfacts.presentation.adapters.AdapterForNews;
import com.example.catsfacts.presentation.adapters.FilmAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements NewsService.NewsCallback {
    private AdapterForNews adapter;
    private List<NewsModels> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NewsService newsService = new NewsService();
        newsService.getNews(this);
        RecyclerView recyclerView = view.findViewById(R.id.rec_view_news_fr);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();

        Log.e("TAG", "onViewCreated: " + recyclerView);


        adapter = new AdapterForNews(list, new OnItemClick() {
            @Override
            public void onItemClick(int pos) {
                Bundle bundle = new Bundle();
                bundle.putString("id", list.get(pos).getUrl());
                Log.d("TAG", list.get(pos).getUrl());
                NewsInfoFragment fragment = new NewsInfoFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, fragment).addToBackStack(null).commit();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSuccess(List<NewsModels> news) {
        adapter.setAll(news);
        Log.e("TAG", "onSuccess: " + news.size());
    }

    @Override
    public void onResponseFilm(NewsModels news) {

    }

    @Override
    public void onFailure(Exception exception) {
        Log.e("TAG", "onFailure: ",exception );
    }
}