package com.sylvain.trainingmvp.ui.base;

import java.util.List;

/**
 * Created by sylvain on 20/11/2017.
 */

public interface MvpView {

  //onError
  //ShowMessage

  void showProgress();

  void hideProgress();

  void setItems(List<String> items);

  void showMessage(String message);

}
