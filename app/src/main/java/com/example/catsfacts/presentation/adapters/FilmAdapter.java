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

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {


    public void setOnItemClickListener(OnItemClick onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    private OnItemClick onItemClickListener;
    private List<FilmGhibli> list;

    public FilmAdapter(List<FilmGhibli> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_anime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(List<FilmGhibli> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitleAnime, textDescAnime;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));
            textTitleAnime = itemView.findViewById(R.id.facts_title);
            textDescAnime = itemView.findViewById(R.id.text_facts_description_anime);

        }

        private void bind(FilmGhibli film) {
            textTitleAnime.setText(film.getTitle());
            textDescAnime.setText(film.getDescription());
        }
    }
}