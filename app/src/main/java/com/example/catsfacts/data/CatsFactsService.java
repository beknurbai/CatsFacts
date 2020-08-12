package com.example.catsfacts.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.catsfacts.models.CatsFactsModel;
import com.example.catsfacts.models.FilmGhibli;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class CatsFactsService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    CatFactApi service = retrofit.create(CatFactApi.class);

    public void getFactsById(String id, CatFactCallback callback) {
        Call<CatsFactsModel> call = service.getFactsById(id);
        call.enqueue(new Callback<CatsFactsModel>() {
            @Override
            public void onResponse(Call<CatsFactsModel> call, Response<CatsFactsModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponseFacts(response.body());
                }
            }

            @Override
            public void onFailure(Call<CatsFactsModel> call, Throwable t) {

            }
        });


    }

    public void getListFacts(CatFactCallback callback) {
        Call<List<FilmGhibli>> call = service.getFacts();
        call.enqueue(new Callback<List<FilmGhibli>>() {
            @Override
            public void onResponse(Call<List<FilmGhibli>> call, Response<List<FilmGhibli>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    }
                } else {
                    callback.onFailure(new NetworkErrorException());
                }
            }

            @Override
            public void onFailure(Call<List<FilmGhibli>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
                callback.onFailure(new Exception());
            }
        });
    }

    public   interface CatFactCallback {
        void onSuccess(List<FilmGhibli> facts);

        void onResponseFacts(CatsFactsModel facts);

        void onFailure(Exception exception);
    }

    public interface CatFactApi {
        @GET("/films")
        Call<List<FilmGhibli>> getFacts();

        @GET("facts/:factID")
        Call<CatsFactsModel> getFactsById(String factsId);

    }
}
