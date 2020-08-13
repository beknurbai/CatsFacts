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

import com.example.catsfacts.App;
import com.example.catsfacts.R;
import com.example.catsfacts.data.CatsFactsService;
import com.example.catsfacts.interfaces.OnItemClick;
import com.example.catsfacts.models.CatsFactsModel;
import com.example.catsfacts.presentation.adapters.ForCatsFactsAdapter;

import java.util.ArrayList;
import java.util.List;


public class CatsFactsFragment extends Fragment implements CatsFactsService.CatFactCallback {
    private ForCatsFactsAdapter adapter;
    private List<CatsFactsModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cats_facts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CatsFactsService catsFactsService = new CatsFactsService();

        catsFactsService.getListFacts(this);

        RecyclerView recyclerView = view.findViewById(R.id.rec_view_cats_fr);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        list = new ArrayList<>();
        adapter = new ForCatsFactsAdapter(list, new OnItemClick() {
            @Override
            public void onItemClick(int pos) {
                Bundle bundle = new Bundle();
                bundle.putString("id", list.get(pos).getId());
                FactsFragment fragment = new FactsFragment();
                fragment.setArguments(bundle);
                Log.d("check", list.get(pos).getId());
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fr, fragment).addToBackStack(null).commit();

            }
        });
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSuccess(List<CatsFactsModel> facts) {
        adapter.setAll(facts);
        Log.e("TAG", "onSuccess: " + facts.size());
    }

    @Override
    public void onResponseFacts(CatsFactsModel facts) {

    }

    @Override
    public void onFailure(Exception exception) {
        Log.e("TAG", "onSuccess: ");

    }
}