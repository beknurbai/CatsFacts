package com.example.catsfacts.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.catsfacts.models.FilmGhibli;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GhibliService {

    public static List<FilmGhibli> list = new ArrayList<>();

    public static FilmGhibli getFilmNamePosition(int position) {
        return list.get(position);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);

    public void getFilmById(String id, GhibliCallback callback) {
        Call<FilmGhibli> call = service.getFilmById(id);
        call.enqueue(new Callback<FilmGhibli>() {
            @Override
            public void onResponse(Call<FilmGhibli> call, Response<FilmGhibli> response) {
                if (response.isSuccessful() && response.body() != null){
                    callback.onResponseFilm(response.body());
                }
            }

            @Override
            public void onFailure(Call<FilmGhibli> call, Throwable t) {
                callback.onFailure(new NetworkErrorException());
            }
        });
    }

    public void getListFilms(GhibliCallback callback) {
        Call<List<FilmGhibli>> call = service.getFilms();
        call.enqueue(new Callback<List<FilmGhibli>>() {
            @Override
            public void onResponse(Call<List<FilmGhibli>> call, Response<List<FilmGhibli>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                        Log.d("tag", response.body().toString());
                    } else {
                        Log.d("tag", "response body is null");
                        callback.onFailure(new NetworkErrorException());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<FilmGhibli>> call, Throwable t) {
                Log.d("tag", "Error");
                callback.onFailure(new Exception());
            }
        });

    }

    public interface GhibliCallback {
        void onSuccess(List<FilmGhibli> films);

        void onResponseFilm(FilmGhibli film);

        void onFailure(Exception exception);
    }

    public interface GhibliApi {
        @GET("films/")
        Call<List<FilmGhibli>> getFilms();

        @GET("films/{id}")
        Call<FilmGhibli> getFilmById(@Path("id") String filmId);
    }
}
