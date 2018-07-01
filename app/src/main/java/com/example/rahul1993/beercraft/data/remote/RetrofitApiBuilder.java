package com.example.rahul1993.beercraft.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class RetrofitApiBuilder {

  public static ApiCalls.BeerService getAuthApi(){

    return new Retrofit.Builder()
        .baseUrl("http://starlord.hackerearth.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiCalls.BeerService.class);
  }
}
