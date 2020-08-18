package com.example.catsfacts.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catsfacts.R;
import com.example.catsfacts.interfaces.OnItemClick;
import com.example.catsfacts.models.FilmGhibli;
import com.example.catsfacts.models.NewsModels;

import java.util.ArrayList;
import java.util.List;

public class AdapterForNews extends RecyclerView.Adapter<AdapterForNews.NewsViewHolder> {
    private List<NewsModels> list = new ArrayList<>();
    private OnItemClick onItemClick;


    public AdapterForNews(List<NewsModels> list, OnItemClick onItemClick) {
        this.list = list;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setAll(List<NewsModels> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle,newsDesc;
        ImageView newsImage;

        public NewsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(getAdapterPosition());
                }
            });
            newsTitle=itemView.findViewById(R.id.new_heading);
            newsDesc=itemView.findViewById(R.id.text_news_description);
            newsImage=itemView.findViewById(R.id.news_image_view);
        }

        public void bind(NewsModels newsModels) {
            newsTitle.setText(newsModels.getTitle());
            newsDesc.setText(newsModels.getDescription());

        }
    }
}
