package com.attra.androidroomtutorial.Repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.attra.androidroomtutorial.Database.Employee;
import com.attra.androidroomtutorial.Database.EmployeeAppDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {

    private static  AppRepository ourInstance;
    private List<Employee> employeeList;
    private Executor executor= Executors.newSingleThreadExecutor();
    private EmployeeAppDatabase employeeAppDatabase;

    public static AppRepository getInstance(Context context){

        return ourInstance=new AppRepository(context);
    }

    private AppRepository(Context context) {

        employeeAppDatabase=EmployeeAppDatabase.getInstance(context);

    }

    public void AddEmployeeDataToDatabase(final Employee employee){

        executor.execute(new Runnable() {
            @Override
            public void run() {
               long data=employeeAppDatabase.getEmployeeDAO().addEmployeDetails(employee);
                Log.d("Aryan", "run: data inserted"+ data);
            }
        });
    }

    public LiveData<List<Employee>> getEmpDetails(){



//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                employeeList= employeeAppDatabase.getEmployeeDAO().getAllEmployess();
//
//            }
//        });

        return employeeAppDatabase.getEmployeeDAO().getAllEmployess();
    }
}
