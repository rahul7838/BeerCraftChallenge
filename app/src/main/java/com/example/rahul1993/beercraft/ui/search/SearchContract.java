package com.example.rahul1993.beercraft.ui.search;


/**
 * Created by rahul1993 on 7/1/2018.
 */

public interface SearchContract {

  interface View<T>{

    void showList();

    void setPresenter(T presenter);


  }

  interface Presenter{

    void getListBySearchQuery();

  }

}
