package com.attra.androidroomtutorial;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.attra.androidroomtutorial.ViewModels.MainActivityViewModel;

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
}
