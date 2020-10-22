package com.example.mvvmapplication.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmapplication.R;
import com.example.mvvmapplication.adapter.UserAdapter;
import com.example.mvvmapplication.model.User;
import com.example.mvvmapplication.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        recyclerView=findViewById(R.id.recycler_Id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel.getAllUserData().observe(this, new Observer<User[]>() {
         @Override
         public void onChanged(@Nullable User[] users)
         {
            recyclerView.setAdapter(new UserAdapter(users));
     }
 });
    }

}
