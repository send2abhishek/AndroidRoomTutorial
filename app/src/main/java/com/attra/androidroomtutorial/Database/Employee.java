package com.attra.androidroomtutorial.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Employees")
public class Employee {

    @ColumnInfo(name = "Employees_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Employees_name")
    private String name;

    @ColumnInfo(name = "Employees_email")
    private String email;

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Ignore
    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
