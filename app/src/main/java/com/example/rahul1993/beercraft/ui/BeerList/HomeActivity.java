package com.example.rahul1993.beercraft.ui.BeerList;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rahul1993.beercraft.R;
import com.example.rahul1993.beercraft.data.Model.Beer;
import com.example.rahul1993.beercraft.databinding.ToolbarHomeBinding;
import com.example.rahul1993.beercraft.ui.PresenterInjector;
import com.example.rahul1993.beercraft.ui.search.SearchActivity;
import com.example.rahul1993.beercraft.utils.Connectivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeView, View.OnClickListener{
private HomeContract.Presenter mPresenter;
private ToolbarHomeBinding toolbarHomeBinding;
private BeerListAdapter adapter;
private List<Beer> listOfBeer = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    toolbarHomeBinding = DataBindingUtil.setContentView(this, R.layout.toolbar_home);
    PresenterInjector.injectHomePresenter(this);
    setSupportActionBar(toolbarHomeBinding.toolBarNav);
    if (Connectivity.isNetworkAvailable(this)) {
      mPresenter.fetchBeer();
    } else {
      noInternetMessage();
    }
    toolbarHomeBinding.searchBarHomeActivity.setOnClickListener(this);
  }

  @Override
  public void setPresenter(Object presenter) {
    mPresenter = (HomeContract.Presenter)presenter;
  }

  @Override
  public void replaceListOfBeer(List list) {
    adapter.swapList(list);
  }

  @Override
  public void showLoading() {
    toolbarHomeBinding.progressBar1.progressBarId.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    toolbarHomeBinding.progressBar1.progressBarId.setVisibility(View.GONE);
  }

  @Override
  public void getListOfBeer(List list) {
    listOfBeer.addAll(list);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    toolbarHomeBinding.homeActivityRecyclerView.setHasFixedSize(true);
    toolbarHomeBinding.homeActivityRecyclerView.setLayoutManager(linearLayoutManager);
    adapter = new BeerListAdapter(list);
    toolbarHomeBinding.homeActivityRecyclerView.setAdapter(adapter);
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(this, SearchActivity.class);
//    intent.putExtra(AppConstants.LIST_BEER, (Serializable)listOfBeer);
    startActivity(intent);
  }

  private void noInternetMessage() {
    toolbarHomeBinding.homeActivityRecyclerView.setVisibility(View.GONE);
    toolbarHomeBinding.noInternet.setVisibility(View.VISIBLE);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id){
      case R.id.menu_sort_asc :
        mPresenter.sortAsc();
        break;
      case R.id.menu_sort_desc :
        mPresenter.sortDesc();
        break;
      case R.id.menu_filter_by_lager:
        mPresenter.filterByLager();
        break;
      case R.id.menu_filter_by_IPA:
        mPresenter.filterByIPA();
        break;
      case R.id.all_beer:
        adapter.swapList(listOfBeer);
    }
    return super.onOptionsItemSelected(item);
  }
}
