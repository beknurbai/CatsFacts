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
import com.example.catsfacts.data.CatsFactsService;
import com.example.catsfacts.models.CatsFactsModel;

import java.util.List;

public class FactsFragment extends Fragment  implements CatsFactsService.CatFactCallback {
    private TextView factsHeading, factDescription;
    private CatsFactsModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_facts, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        factsHeading = view.findViewById(R.id.text_heading_in_fr);
        factDescription = view.findViewById(R.id.text_desc_in_fr);
        if (model!=null){

        }
        if (getArguments() != null) {
            String id = getArguments().getString("id");
            Log.d("check", id);
                App.factsService.getFactsById(id, new CatsFactsService.CatFactCallback() {
                    @Override
                    public void onSuccess(List<CatsFactsModel> facts) {

                    }

                    @Override
                    public void onResponseFacts(CatsFactsModel facts) {
                        factsHeading.setText(facts.getType());
                        factDescription.setText(facts.getText());
                    }

                    @Override
                    public void onFailure(Exception exception) {

                    }
                });
        }
    }

    @Override
    public void onSuccess(List<CatsFactsModel> facts) {

    }

    @Override
    public void onResponseFacts(CatsFactsModel facts) {
        factsHeading.setText(model.getType());
        factDescription.setText(model.getText());
    }

    @Override
    public void onFailure(Exception exception) {

    }
}