package com.example.rahul1993.beercraft.ui.BeerList;


import android.util.Log;

import com.example.rahul1993.beercraft.data.DataHandler;
import com.example.rahul1993.beercraft.data.DataHandlerImpl;
import com.example.rahul1993.beercraft.data.Model.Beer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class HomePresenter implements HomeContract.Presenter {
  private static final String TAG = HomePresenter.class.getSimpleName();
  private HomeContract.HomeView mView;
  private List<Beer> listBeer = new ArrayList<>();

  private DataHandler mDataHandler;

  public HomePresenter(HomeContract.HomeView view){
    this.mView = view;
    mView.setPresenter(this);
    mDataHandler = DataHandlerImpl.getInstance();
  }

  @Override
  public void fetchBeer() {
    mView.showLoading();
    mDataHandler.fetchBeerData(new DataHandler.Callback<List<Beer>>() {
      @Override
      public void onResponse(List<Beer> result) {
        listBeer.clear();
        listBeer.addAll(result);
        mView.getListOfBeer(result);
        Log.d(TAG, Integer.toString(result.size()));
        mView.hideLoading();
      }
      @Override
      public void onError() {
        Log.d(TAG, "onError");
//        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        // TODO Handle error
      }
    });
  }

  @Override
  public void sortAsc() {
    filterList();
    Collections.sort(listBeer, new Comparator<Beer>() {
      @Override
      public int compare(Beer o1, Beer o2) {
          return Float.valueOf(o1.getAbv()).compareTo(Float.valueOf(o2.getAbv()));
      }
    });
    mView.replaceListOfBeer(listBeer);
  }

  private void filterList() {
    ListIterator<Beer> listIterator = listBeer.listIterator();
    while (listIterator.hasNext()){
      if(listIterator.next().getAbv().equals("")){
        listIterator.remove();
      }
    }
  }

  @Override
  public void sortDesc() {
    filterList();
    sortAsc();
    Collections.reverse(listBeer);
  }

  @Override
  public void filterByIPA() {
    List<Beer> IPAList = new ArrayList<>();
    IPAList.addAll(listBeer);
    ListIterator<Beer> listIterator = IPAList.listIterator();
    while (listIterator.hasNext()){
      if(!listIterator.next().getStyle().contains("IPA")){
        listIterator.remove();
      }
    }
    mView.replaceListOfBeer(IPAList);
  }

  @Override
  public void filterByLager() {
    List<Beer> lagerList = new ArrayList<>();
    lagerList.addAll(listBeer);
    ListIterator<Beer> listIterator = lagerList.listIterator();
    while (listIterator.hasNext()){
      if(!listIterator.next().getStyle().contains("Lager")){
        listIterator.remove();
      }
    }
    mView.replaceListOfBeer(lagerList);
  }
}
