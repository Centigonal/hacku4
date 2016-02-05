package com.mateoj.hacku4;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

/**
 * Created by jose on 2/4/16.
 */
public class HackUApp extends Application{
    public static final String TAG = HackUApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseObject.registerSubclass(Building.class);
        ParseObject.registerSubclass(Event.class);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
