package com.example.catsfacts.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catsfacts.R;
import com.example.catsfacts.interfaces.OnItemClick;
import com.example.catsfacts.models.CatsFactsModel;
import com.example.catsfacts.models.FilmGhibli;

import java.util.ArrayList;
import java.util.List;

public class ForCatsFactsAdapter extends RecyclerView.Adapter<ForCatsFactsAdapter.CatsViewHolder> {

    private List<FilmGhibli> list;
    private OnItemClick onItemClick;

    public ForCatsFactsAdapter(List<FilmGhibli> list, OnItemClick onItemClick) {
        this.list = list;
        this.onItemClick = onItemClick;
    }

    public void setAll(@NonNull List<FilmGhibli> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_facts_view, parent, false);
        return new CatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatsViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CatsViewHolder extends RecyclerView.ViewHolder {
        private TextView textType, textFacts;

        public CatsViewHolder(@NonNull View itemView) {
            super(itemView);
            initializationViews(itemView);
        }

        private void initializationViews(View itemView) {
            textType = itemView.findViewById(R.id.facts_heading);
            textFacts = itemView.findViewById(R.id.text_facts_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(getAdapterPosition());
                }
            });
        }

        public void onBind(FilmGhibli catsFactsModel) {
            textType.setText(catsFactsModel.getTitle());
            textFacts.setText(catsFactsModel.getDescription());
        }
    }

}
