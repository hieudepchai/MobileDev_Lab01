package com.example.md_lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {
    private int noCreate = 0;
    private int noStart = 0;
    private int noResume = 0;
    private int noRestart = 0;
    private TextView tvCreate, tvStart, tvResume, tvRestart;
    private final static String TAG = "ActivityTwo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final Button btnClose = findViewById(R.id.btnClose);
        //event for btnClose
        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        //get var from savedInstanceState
        if(savedInstanceState!=null){
            noCreate = savedInstanceState.getInt("noCreate");
            noStart = savedInstanceState.getInt("noStart");
            noResume = savedInstanceState.getInt("noResume");
            noRestart = savedInstanceState.getInt("noRestart");
        }
        //
        Log.i(TAG,"onCreate()..");
        ++noCreate;
        Log.i(TAG,"No of onCreate(): "+noCreate);
        //get tv
        tvCreate = findViewById(R.id.tvOnCreate);
        tvStart = findViewById(R.id.tvOnStart);
        tvResume = findViewById(R.id.tvOnResume);
        tvRestart = findViewById(R.id.tvOnRestart);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("noCreate",noCreate);
        savedInstanceState.putInt("noStart",noStart);
        savedInstanceState.putInt("noResume",noResume);
        savedInstanceState.putInt("noRestart",noRestart);
        Log.i(TAG,"onSaveInstanceState()..");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()..");
        ++noStart;
        Log.i(TAG,"No of onStart(): "+ noStart);

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume()..");
        ++noResume;
        Log.i(TAG,"No of onResume(): "+noResume);
        //update  tv
        tvCreate.setText("onCreate() calls: "+noCreate);
        tvStart.setText("onStart() calls: "+noStart);
        tvResume.setText("onResume() calls:"+noResume);
        tvRestart.setText("onRestart() calls: "+noRestart);
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.i(TAG,"onPause()..");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop()..");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart()..");
        ++noRestart;
        Log.i(TAG,"No of onRestart(): "+noRestart);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"onDestroy()..");
    }
}
