package com.attra.androidroomtutorial;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.attra.androidroomtutorial.Database.Employee;
import com.attra.androidroomtutorial.ViewModels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView counterTextView;
    private Button increment;
    private MainActivityViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTextView=findViewById(R.id.activity_main_counter);
        increment=findViewById(R.id.activity_main_counter_btn);
        increment.setOnClickListener(this);

        initViewModel();

    }

    private void initViewModel() {

        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        counterTextView.setText(String.valueOf(viewModel.getCounter()));

        LiveData<Integer> counterData=viewModel.getCounter();
        counterData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                counterTextView.setText(String.valueOf(integer));
            }
        });

    }

    @Override
    public void onClick(View v) {

        viewModel.IncrementCounterByOne();
    }

    public void shwodata(View view) {

        LiveData<List<Employee>> listLiveData=viewModel.getEmps();
        listLiveData.observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {

                Log.d("Aryan", "Employee data is -"+  employees.size());

                for (Employee emp:employees) {


                    Log.d("Aryan", "Employee data is -"+  emp.getEmail());
                }

            }
        });



    }
}
