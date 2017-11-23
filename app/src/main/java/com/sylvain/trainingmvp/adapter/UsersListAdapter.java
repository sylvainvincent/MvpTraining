package com.sylvain.trainingmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.sylvain.trainingmvp.R;
import com.sylvain.trainingmvp.models.Users;
import java.util.List;

/**
 * Created by sylvain on 21/11/2017.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

  private List<Users> usersList;
  private Context context;

  public UsersListAdapter(Context context, List<Users> usersList){
    this.usersList = usersList;
    this.context = context;
  }

  @Override
  public UsersListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
  }

  @Override
  public void onBindViewHolder(UsersListAdapter.ViewHolder holder, int position) {
    Users user = usersList.get(position);

    if(user != null){
      if(user.getFistName() != null) {
        holder.firstName.setText(user.getFistName());
      }
      if(user.getLastName() != null) {
        holder.lastName.setText(user.getLastName());
      }
      Picasso.with(context).load(user.getImageLink()).fit().into(holder.profilPicture);

    }
    holder.itemView.setTag(user);
  }

  @Override
  public int getItemCount() {
    return usersList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    private TextView firstName;
    private TextView lastName;
    private ImageView profilPicture;

    ViewHolder(View itemView) {
      super(itemView);
      firstName = (TextView) itemView.findViewById(R.id.text_first_name);
      lastName = (TextView) itemView.findViewById(R.id.text_last_name);
      profilPicture = (ImageView) itemView.findViewById(R.id.image_user);
    }
  }


}
