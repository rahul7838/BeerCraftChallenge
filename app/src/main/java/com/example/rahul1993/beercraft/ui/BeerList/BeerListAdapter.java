package com.example.rahul1993.beercraft.ui.BeerList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul1993.beercraft.R;
import com.example.rahul1993.beercraft.data.Model.Beer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class BeerListAdapter extends RecyclerView.Adapter<BeerListAdapter.BeerViewHolder> {
  private List<Beer> beerList = new ArrayList<>();
  BeerListAdapter(List<Beer> list){
    this.beerList = list;
  }

  @Override
  public BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_list_item, parent, false);
    return new BeerViewHolder(viewHolder);
  }

  @Override
  public void onBindViewHolder(BeerViewHolder holder, int position) {
    holder.setBeerName(beerList.get(position).getName());
    holder.setBeerStyle(beerList.get(position).getStyle());
    holder.setAlcoholContent(beerList.get(position).getAbv());
  }

  @Override
  public int getItemCount() {
    return beerList.size();
  }

  public void swapList(List<Beer> listOfBeer){
    this.beerList = listOfBeer;
    notifyDataSetChanged();
  }


  class BeerViewHolder extends RecyclerView.ViewHolder {
//    private BeerItemBinding beerItemBinding;
    private View view;
    private TextView beerName;
    private TextView alcoholContent;
    private TextView beerStyle;
    BeerViewHolder(View itemView) {
      super(itemView);
      view = itemView;
      beerName = view.findViewById(R.id.beer_name);
      alcoholContent = view.findViewById(R.id.beer_alcohol_content);
      beerStyle = view.findViewById(R.id.beer_style);
    }

    void setBeerName(String name){
      beerName.setText(name);
    }


    void setBeerStyle(String style){
      beerStyle.setText(style);
    }

    void setAlcoholContent(String content){
      alcoholContent.setText("Alcohol Content: " +content);
    }



  }
}
