package com.example.rahul1993.beercraft.data.Model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rahul1993 on 7/1/2018.
 */

public class Beer implements Serializable{

  @SerializedName("abv")
  @Expose
  private String abv;
  @SerializedName("ibu")
  @Expose
  private String ibu;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("style")
  @Expose
  private String style;
  @SerializedName("ounces")
  @Expose
  private float ounces;

  public String getAbv() {
    return abv;
  }

  public void setAbv(String abv) {
    this.abv = abv;
  }

  public String getIbu() {
    return ibu;
  }

  public void setIbu(String ibu) {
    this.ibu = ibu;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public float getOunces() {
    return ounces;
  }

  public void setOunces(float ounces) {
    this.ounces = ounces;
  }
}

