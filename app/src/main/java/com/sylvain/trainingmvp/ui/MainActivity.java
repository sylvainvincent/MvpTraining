package com.sylvain.trainingmvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.sylvain.trainingmvp.R;
import com.sylvain.trainingmvp.adapter.UsersListAdapter;
import com.sylvain.trainingmvp.api.ApiHandler;
import com.sylvain.trainingmvp.api.GithubService;
import com.sylvain.trainingmvp.models.Users;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerViewUsers;
  ApiHandler apiHandler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerViewUsers = findViewById(R.id.recyclerview_users);

    GithubService githubService = apiHandler.getInstance().create(GithubService.class);
    Observable<List<Users>> usersObservable = githubService.getUsers();


    usersObservable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Users>>() {

      @Override
      public void onSubscribe(Disposable d) {
        Log.i("test", "onSubscribe: OK");
      }

      @Override
      public void onNext(List<Users> value) {
        recyclerViewUsers.setAdapter(new UsersListAdapter(MainActivity.this, value));
        Log.i("test", "onNext: pk");
      }

      @Override
      public void onError(Throwable e) {
        Log.e("test", "onError: error " + e.getMessage() );
        e.printStackTrace();
        e.fillInStackTrace();
      }

      @Override
      public void onComplete() {
        Log.e("test", "oncomplete: ok ");
      }
    });




  }
}
