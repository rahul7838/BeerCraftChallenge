package com.example.rahul1993.beercraft.ui.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rahul1993.beercraft.R;
import com.example.rahul1993.beercraft.data.Model.Beer;
import com.example.rahul1993.beercraft.databinding.SearchBarFragmentBinding;
import com.example.rahul1993.beercraft.ui.PresenterInjector;
import com.example.rahul1993.beercraft.utils.AppConstants;

import java.util.List;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, SearchContract.View{
  private static final String TAG = SearchActivity.class.getSimpleName();
  private List<Beer> listOfBeer;
  private SearchBarFragmentBinding searchBarFragmentBinding;
  private SearchContract.Presenter mPresenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    searchBarFragmentBinding = DataBindingUtil.setContentView(this, R.layout.search_bar_fragment);
    searchBarFragmentBinding.searchActivityBackArrow.setOnClickListener(this);
    PresenterInjector.injectSearchPresenter(this);
  }

  @Override
  public void onClick(View v) {
    onBackPressed();
  }

  @Override
  public void showList() {

  }

  @Override
  public void setPresenter(Object presenter) {
    mPresenter = (SearchContract.Presenter) presenter;
  }
}
