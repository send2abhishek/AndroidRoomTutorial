package com.attra.androidroomtutorial.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class MainActivityViewModel extends AndroidViewModel {

    int counter=1;

    private MutableLiveData<Integer> counterLiveData=new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Integer> getCounter() {
        counterLiveData.setValue(counter);
        return counterLiveData;
    }

    public void IncrementCounterByOne(){

     counter =counter + 1;
     counterLiveData.setValue(counter);
    }
}
