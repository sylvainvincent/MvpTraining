package com.sylvain.trainingmvp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sylvain on 20/11/2017.
 */

public class ApiHandler {

  private static String BASE_URL = "https://api.github.com/";

  private static Retrofit retrofit = null;

  public static Retrofit getInstance(){

    if(retrofit == null){

      // pour les logs
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

      // faire des appels reseaux plus rapides
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

       retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           // .client(client)
            .build();
    }

    return retrofit;
  }

}
