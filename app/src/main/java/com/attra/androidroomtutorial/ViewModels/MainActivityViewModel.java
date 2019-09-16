package com.attra.androidroomtutorial.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.attra.androidroomtutorial.Database.Employee;
import com.attra.androidroomtutorial.Repository.AppRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    int counter=1;
    private AppRepository appRepository;

    private MutableLiveData<Integer> counterLiveData=new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {

        super(application);
        appRepository=AppRepository.getInstance(application.getApplicationContext());
    }

    public MutableLiveData<Integer> getCounter() {
        counterLiveData.setValue(counter);
        return counterLiveData;
    }

    public void IncrementCounterByOne(){

     counter =counter + 1;
     counterLiveData.setValue(counter);
        appRepository.AddEmployeeDataToDatabase(new Employee(counter,"Abhishek Aryan","Send2abhishek@live.com"));
    }

    public LiveData<List<Employee>> getEmps(){

         return appRepository.getEmpDetails();
    }
}
