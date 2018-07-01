package com.example.rahul1993.beercraft.ui.search;


import com.example.rahul1993.beercraft.data.DataHandler;
import com.example.rahul1993.beercraft.data.DataHandlerImpl;
import com.example.rahul1993.beercraft.ui.BeerList.HomeContract;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class SearchPresenter implements SearchContract.Presenter {

  private final DataHandler mDataHandler;
  private final SearchContract.View mView;

  public SearchPresenter(SearchContract.View view){
    this.mView = view;
    mView.setPresenter(this);
    mDataHandler = DataHandlerImpl.getInstance();
  }

  @Override
  public void getListBySearchQuery() {

  }
}
