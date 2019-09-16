package com.attra.androidroomtutorial.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface EmployeeDAO {

   @Insert
   long addEmployeDetails(Employee employee);

   @Update
   void updateEmpDetails(Employee employee);


   @Delete
   void DeleteEmpDetails(Employee employee);

   @Query("select * from Employees")
    LiveData<List<Employee>> getAllEmployess();

   @Query("select * from Employees where Employees_id=:emp_id")
    Employee getAEmplDetails(int emp_id);

}
