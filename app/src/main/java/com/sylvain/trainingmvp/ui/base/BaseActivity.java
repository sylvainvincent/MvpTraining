package com.sylvain.trainingmvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sylvain on 21/11/2017.
 */

public abstract class BaseActivity<V extends MvpView> extends AppCompatActivity implements MvpView {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
