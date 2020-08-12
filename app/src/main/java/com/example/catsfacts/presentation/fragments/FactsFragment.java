package com.example.catsfacts.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String id = bundle.getString("id");
            App.factsService.getFactsById(id, this);}

        return inflater.inflate(R.layout.fragment_facts, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        factsHeading = view.findViewById(R.id.facts_heading);
        factDescription = view.findViewById(R.id.text_facts_description);
        if (model!=null){

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