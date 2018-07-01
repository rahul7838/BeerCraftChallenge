package com.example.rahul1993.beercraft.data.remote;

import com.example.rahul1993.beercraft.data.Model.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public interface ApiCalls {

  interface BeerService{
    @GET("beercraft")
    Call<List<Beer>> getBeerResponse();
  }
}
