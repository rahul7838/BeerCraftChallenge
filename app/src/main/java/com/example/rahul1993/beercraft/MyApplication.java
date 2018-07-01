package com.example.rahul1993.beercraft;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class MyApplication extends Application {

  @SuppressLint("StaticFieldLeak")
  private static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    context = getApplicationContext();
  }

  public static Context getApplication(){
    return context;
  }
}
