package com.example.mvvmapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.mvvmapplication.model.User;
import com.example.mvvmapplication.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository=new UserRepository(application);
    }
    public LiveData<User[]> getAllUserData()
    {
        return userRepository.getUserData();
    }
}
