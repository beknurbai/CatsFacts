package com.example.catsfacts.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.catsfacts.models.FilmGhibli;
import com.example.catsfacts.models.NewsModels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class NewsService {
    public static List<NewsModels> list = new ArrayList<>();

    public static NewsModels getPos(int pos) {
        return list.get(pos);

    }

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://newsapi.org/")
            .build();
    NewsApi service = retrofit.create(NewsApi.class);

    public void getNewsById(String id, NewsCallback callback) {
        Call<NewsModels> call = service.getNewsById(id);
        call.enqueue(new Callback<NewsModels>() {
            @Override
            public void onResponse(Call<NewsModels> call, Response<NewsModels> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponseFilm(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsModels> call, Throwable t) {
                callback.onFailure(new NetworkErrorException());
            }
        });

    }


    public void getNews(NewsCallback callback) {
        Call<List<NewsModels>> call = service.getNews("ru","df9f8d1aa6de490a8d4e1d0d93a6ff91");
        call.enqueue(new Callback<List<NewsModels>>() {
            @Override
            public void onResponse(Call<List<NewsModels>> call, Response<List<NewsModels>> response) {
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
            public void onFailure(Call<List<NewsModels>> call, Throwable t) {
                callback.onFailure(new Exception());
                Log.e("TAG", "onFailure: "+t.getMessage() );
            }

        });

    }

    public interface NewsCallback {
        void onSuccess(List<NewsModels> news);

        void onResponseFilm(NewsModels news);

        void onFailure(Exception exception);


    }

    public interface NewsApi {
        @GET("v2/top-headlines/")
        Call<List<NewsModels>> getNews( @Query("country") String country,@Query("apiKey") String apiKey);

        @GET("/{id}")
        Call<NewsModels> getNewsById(@Query("id") String newsId);

    }


}
