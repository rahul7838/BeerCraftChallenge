package com.example.rahul1993.beercraft.ui;


import com.example.rahul1993.beercraft.ui.BeerList.HomeContract;
import com.example.rahul1993.beercraft.ui.BeerList.HomePresenter;
import com.example.rahul1993.beercraft.ui.search.SearchContract;
import com.example.rahul1993.beercraft.ui.search.SearchPresenter;

/**
   * Encapsulate creation of presenter
   *
   * Created by rahul1993 on 7/1/2018.
   */

  public class PresenterInjector {

  public static HomePresenter injectHomePresenter(HomeContract.HomeView homeView){
    return new HomePresenter(homeView);
  }

  public static SearchPresenter injectSearchPresenter(SearchContract.View view){
    return new SearchPresenter(view);
  }
}
