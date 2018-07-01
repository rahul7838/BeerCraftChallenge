package com.example.rahul1993.beercraft.data;

import android.util.Log;
import android.widget.Toast;

import com.example.rahul1993.beercraft.MyApplication;
import com.example.rahul1993.beercraft.data.Model.Beer;
import com.example.rahul1993.beercraft.data.remote.RetrofitApiBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class DataHandlerImpl implements DataHandler {
  private static final String TAG = DataHandlerImpl.class.getSimpleName();
  private static DataHandler mDataHandler;
  private List<Beer> listOfBeer = new ArrayList<>();

  public static DataHandler getInstance(){
    if(mDataHandler == null){
      mDataHandler = new DataHandlerImpl();
    }
    return mDataHandler;
  }

  @Override
  public void fetchBeerData(final Callback<List<Beer>> callback) {
    RetrofitApiBuilder.getAuthApi()
        .getBeerResponse()
        .enqueue(new retrofit2.Callback<List<Beer>>() {
          @Override
          public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
            if (response.isSuccessful()) {
              Log.d(TAG, "onResponse");
              listOfBeer.addAll(response.body());
              callback.onResponse(response.body());
            } else {
//              TODO handle error code
              Log.d(TAG, "Error code" + response.code());
              Toast.makeText(MyApplication.getApplication(), "Error code"+ response.code(), Toast.LENGTH_SHORT).show();
            }
          }

          @Override
          public void onFailure(Call<List<Beer>> call, Throwable t) {
            Log.d(TAG, "onFailure");
            t.printStackTrace();
            callback.onError();
          }
        });
  }

  @Override
  public void getCacheListOfBeer(List<Beer> list) {
    list = this.listOfBeer;
  }
}
