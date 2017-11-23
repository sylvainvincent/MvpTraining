package com.sylvain.trainingmvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sylvain on 20/11/2017.
 */

public class Users {

  @SerializedName("login")
  private String fistName;
  @SerializedName("url")
  private String lastName;
  @SerializedName("avatar_url")
  private String imageLink;

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }
}
