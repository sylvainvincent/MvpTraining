package com.sylvain.trainingmvp.ui.base;

/**
 * Created by sylvain on 20/11/2017.
 */

import io.reactivex.disposables.CompositeDisposable;

/**
 *
 */
public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

  private V mvpView;

  @Override
  public void onAttach(V view) {
    mvpView = view;
  }

  @Override
  public void onDetach() {

  }
}
