package com.example.rahul1993.beercraft.ui.BeerList;

import android.content.Context;

import com.example.rahul1993.beercraft.data.Model.Beer;

import java.util.List;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class HomeContract {



  public interface HomeView<T> {

    void setPresenter(T presenter);

    void getListOfBeer(List<Beer> list);

    void replaceListOfBeer(List<Beer> list);

    void showLoading();

    void hideLoading();

  }



  public interface Presenter{

    void fetchBeer();

    void sortAsc();

    void sortDesc();

    void filterByIPA();

    void filterByLager();

  }
}
