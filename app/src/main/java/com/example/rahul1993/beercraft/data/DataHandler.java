package com.example.rahul1993.beercraft.data;



import com.example.rahul1993.beercraft.data.Model.Beer;

import java.util.List;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public interface DataHandler {

    /**
     * Generic callback interface for passing response to caller.
     * <p>
     *
     * @param <T> Type of expected response
     */

    interface Callback<T> {
      /**
       * Gets invoked when call was successful
       *
       * @param result Result of the operation
       */
      void onResponse(T result);

      /**
       * Gets invoked when there is an error in the operation
       */
      void onError();
    }

    /**
     * Fetch Beer from hacker earth  api
     *
     * @param callback Callback for receiving result
     *
     */
    void fetchBeerData(Callback<List<Beer>> callback);


    void getCacheListOfBeer(List<Beer> list);
  }
