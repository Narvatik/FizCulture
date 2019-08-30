package com.example.fizculture;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Calendar extends AppCompatActivity {
    public static final String EXTRA_IS_TEACHER ="com.example.fizculture.isTeacher"; // дешифрует код переменной в этом интенте
    private boolean isTeacher; // дешифрует саму переменную в этом интенте
    public boolean remStatus=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.calendar_activity);
        isTeacher = getIntent().getBooleanExtra(EXTRA_IS_TEACHER,false);
        getSupportActionBar().hide();
    }
    public void onClickC(View vie){
        switch (vie.getId()){
            case R.id.backTest:
                remStatus=isTeacher;
                    if (remStatus){
                        Intent intentStudentWork = new Intent(this, MainActivity.class);
                        startActivity(intentStudentWork);
                    } else {
                        Intent intentTeacherWork = new Intent(this, Student_work.class);
                        startActivity(intentTeacherWork);
                    }
                break;
            case R.id.okTest:
                    if (remStatus){
                        Intent intentStudentWork = new Intent(this, MainActivity.class);
                        startActivity(intentStudentWork);
                    } else {
                        Intent intentTeacherWork = new Intent(this, Student_work.class);
                        startActivity(intentTeacherWork);
                    }
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
