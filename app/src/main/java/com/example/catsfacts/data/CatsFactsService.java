package com.example.catsfacts.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.catsfacts.models.CatsFactsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class CatsFactsService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    CatFactApi service = retrofit.create(CatFactApi.class);

    public void getFactsById(String id, CatFactCallback callback) {
        Call<CatsFactsModel> call = service.getFactsById(id);
        call.enqueue(new Callback<CatsFactsModel>() {
            @Override
            public void onResponse(@NonNull Call<CatsFactsModel> call,@NonNull Response<CatsFactsModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponseFacts(response.body());
                    Log.e("lolo", "onResponse: "+response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CatsFactsModel> call, Throwable t) {
                Log.e("lolo", "onFailure: "+t.getMessage() );
            }
        });


    }

    public void getListFacts(CatFactCallback callback) {
        Call<List<CatsFactsModel>> call = service.getFacts();
        call.enqueue(new Callback<List<CatsFactsModel>>() {
            @Override
            public void onResponse(Call<List<CatsFactsModel>> call, Response<List<CatsFactsModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    }
                } else {
                    //callback.onFailure(new NetworkErrorException());
                }
            }

            @Override
            public void onFailure(Call<List<CatsFactsModel>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
                callback.onFailure(new Exception());
            }
        });
    }

  public   interface CatFactCallback {
        void onSuccess(List<CatsFactsModel> facts);

        void onResponseFacts(CatsFactsModel facts);

        void onFailure(Exception exception);
    }

   public interface CatFactApi {
        @GET("facts/random?animal_type=dog&amount=10")
        Call<List<CatsFactsModel>> getFacts();

        @GET("facts/{id}")
        Call<CatsFactsModel> getFactsById (
       @Path("id")String factsId);

    }
}
