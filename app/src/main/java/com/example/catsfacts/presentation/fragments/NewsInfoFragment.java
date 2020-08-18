package com.example.catsfacts.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catsfacts.App;
import com.example.catsfacts.R;
import com.example.catsfacts.data.NewsService;
import com.example.catsfacts.models.NewsModels;

import java.util.List;

public class NewsInfoFragment extends Fragment  implements NewsService.NewsCallback {
TextView newsTitle,newsDesc;
ImageView newsImage;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsTitle=view.findViewById(R.id.new_heading_in_fr);
        newsDesc=view.findViewById(R.id.news_desc_in_fr);
        if (getArguments() != null) {
            String id = getArguments().getString("id");
            App.newsService.getNewsById(id,this );
        }
    }

    @Override
    public void onSuccess(List<NewsModels> news) {

    }

    @Override
    public void onResponseFilm(NewsModels news) {
        newsTitle.setText(news.getTitle());
        newsDesc.setText(news.getDescription());

    }

    @Override
    public void onFailure(Exception exception) {

    }
}