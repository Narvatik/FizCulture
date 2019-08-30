package com.example.fizculture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.content.pm.ActivityInfo;

public class Choose_status extends AppCompatActivity {
    public static final String EXTRA_IS_TEACHER ="com.example.fizculture.isTeacher";//передает код переменной в другой интент
    private boolean isTeacher; // передает указанное значение в другой интент, в данном случае ученик это или учитель

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.choosing_status);
        getSupportActionBar().hide();
    }
    @Override
    public void onBackPressed(){
        finish();
    }//double click for exit
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.students_button:
                isTeacher=false;
                Intent intentLoginStudent = new Intent(this, Login.class);
                intentLoginStudent.putExtra(EXTRA_IS_TEACHER, isTeacher);
                startActivity(intentLoginStudent);
                break;
            case R.id.teachers_button:
                 isTeacher=true;
                 Intent intentLoginTeacher = new Intent(this, Login.class);
                 intentLoginTeacher.putExtra(EXTRA_IS_TEACHER, isTeacher);
                 startActivity(intentLoginTeacher);
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
