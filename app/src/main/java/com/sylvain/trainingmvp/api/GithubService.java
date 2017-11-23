package com.sylvain.trainingmvp.api;

import com.sylvain.trainingmvp.models.Users;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sylvain on 20/11/2017.
 */

public interface GithubService {

  @GET("users")
  Observable<List<Users>> getUsers();

}
