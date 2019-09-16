package com.attra.androidroomtutorial.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Employee.class},version = 1)
public abstract class EmployeeAppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME="employeeDatabase.db";
    public static volatile EmployeeAppDatabase instance;
    private static final Object LOCK=new Object();

    public abstract EmployeeDAO getEmployeeDAO();

    public static EmployeeAppDatabase getInstance(Context context){


        if(instance==null){
            synchronized (LOCK){

                if(instance==null){
                    instance= Room.databaseBuilder(context.getApplicationContext(),
                            EmployeeAppDatabase.class,DATABASE_NAME
                    ).build();
                }
            }
        }
        return  instance;


    }
}
