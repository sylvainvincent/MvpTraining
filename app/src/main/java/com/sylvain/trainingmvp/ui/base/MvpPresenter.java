package com.sylvain.trainingmvp.ui.base;

/**
 * Created by sylvain on 20/11/2017.
 */

/**
 * Tous les presenters doivent implementer cette interface ou BasePresenter
 * @param <V>
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V view);

    void onDetach();

}
