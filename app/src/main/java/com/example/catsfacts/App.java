package com.example.catsfacts;

import android.app.Application;

import com.example.catsfacts.data.CatsFactsService;
import com.example.catsfacts.data.GhibliService;
import com.example.catsfacts.data.NewsService;

public class App extends Application {
    public static CatsFactsService factsService = new CatsFactsService();
    public static GhibliService ghibliService=new GhibliService();
    public static NewsService newsService=new NewsService();

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
