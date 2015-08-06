package br.goncalves.dribbble;

import android.app.Application;
import android.content.Context;


public class Dribbble extends Application {
    private static Dribbble application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    public static Dribbble getApplication() {
        return application;
    }

    public static Context getContext() {
        return application.getApplicationContext();
    }
}
