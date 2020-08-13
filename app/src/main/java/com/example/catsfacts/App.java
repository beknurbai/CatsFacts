package com.example.catsfacts;

import android.app.Application;

import com.example.catsfacts.data.CatsFactsService;

public class App extends Application {
    public static CatsFactsService factsService = new CatsFactsService();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
