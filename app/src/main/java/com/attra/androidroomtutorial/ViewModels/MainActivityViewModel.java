package com.attra.androidroomtutorial.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class MainActivityViewModel extends AndroidViewModel {

    int counter=0;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public int getCounter() {
        return counter;
    }

    public int IncrementCounterByOne(){

        return counter =counter + 1;
    }
}
