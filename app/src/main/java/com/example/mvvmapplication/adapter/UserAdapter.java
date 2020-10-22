package com.example.mvvmapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvvmapplication.R;
import com.example.mvvmapplication.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.user_list,viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        userViewHolder.name.setText(users[i].getLogin());
        userViewHolder.id.setText(String.valueOf(users[i].getId()));
        userViewHolder.reposeUrl.setText(users[i].getReposUrl());

        Glide.with(userViewHolder.avatarImg.getContext()).load(users[i].getAvatarUrl()).into(userViewHolder.avatarImg);

    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder
    {

        ImageView avatarImg;
        TextView name,id,reposeUrl;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImg=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.tvName);
            id=itemView.findViewById(R.id.tvId);
            reposeUrl=itemView.findViewById(R.id.tvReposUrl);

        }
    }
}
