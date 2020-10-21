package com.example.mvvmapplication.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<String> resultLiveData;

public MutableLiveData<String> additionFunction(String value1,String value2)
{
    int num1=Integer.parseInt(value1);
    int num2=Integer.parseInt(value2);
    int result=num1+num2;

    if (resultLiveData==null){
        resultLiveData=new MutableLiveData<>();
    }
    resultLiveData.setValue(String.valueOf(result));
    return resultLiveData;
}
}
