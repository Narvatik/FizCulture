package com.example.fizculture;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class Student_work extends FragmentActivity {


    private TextView lessonInfo[]=new TextView[6];
    private TextView standardInfo[]=new TextView[6];
    private String lesson_info_data[]=new String[6];
    private String standard_info_data[]=new String[6];
    private String infoAboutStudent;
    private CheckBox visited[]=new CheckBox[6];
    private boolean visits_students[]=new boolean[6];
    private Button openStandardResults;
    private boolean fragmentClose=false;
    private Fragment fragment1;
    private FragmentManager fm1;
    private boolean fragmentCloseMenu=false;
    private Fragment fragment;
    private FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.student_activity);
        openStandardResults=findViewById(R.id.open_standard_results);
    }
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tests:
                Intent intentTests = new Intent(this, Test.class);
                startActivity(intentTests);
                break;
            case R.id.menuBtnStudent:
                if (!fragmentCloseMenu){
                    fm = getSupportFragmentManager();//при нажатии на menuBtn вызывается фрагмент menu
                    fragment = fm.findFragmentById(R.id.studentContainer);
                    if (fragment == null) {
                        fragment = new MenuStudent();
                      fm.beginTransaction()
                                .add(R.id.studentContainer, fragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .commit();
                    }
                    fragmentCloseMenu=true;
                }else {
                        fragment.getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        fragmentCloseMenu=false;
                }
                /*Intent intentMenuStudent = new Intent(this, MenuActivityStudent.class);
                startActivity(intentMenuStudent);*/
                break;
            case R.id.openCalendar:
                Intent intentCalend = new Intent(Student_work.this, com.example.fizculture.Calendar.class);
                startActivity(intentCalend);
                break;
            case R.id.open_standard_results:
                if (!fragmentClose) {
                    fm1 = getSupportFragmentManager();
                    fragment1 = fm1.findFragmentById(R.id.studentContainer);
                    //if (fragment1 == null) {
                    fragment1 = new Standard_Student();
                    fm1.beginTransaction()
                            .add(R.id.studentContainer, fragment1)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                    fragmentClose=true;
                } else {
                    fragment1.getActivity().getSupportFragmentManager().beginTransaction().remove(fragment1).commit();
                    fragmentClose=false;
                }
                break;
        }
    }
    private void loadData(){
        for (int i=0;i<6;i++){
            lesson_info_data[i]="Занятие от " + Integer.toString(i * 4)+ " мая";
            if (i%2==1){visits_students[i]=true;}
        }
        standard_info_data[0]="Норматив по прыжкам в длину: \n" + Integer.toString(220)+" см";
        standard_info_data[0]="Норматив по бегу на 100 м: \n" + Integer.toString(10)+" сек";
        standard_info_data[0]="Норматив по наклонам: \n" + Integer.toString(15)+" см";

    }
    @Override
    public void onResume(){
        super.onResume();
        openStandardResults.setEnabled(true);
    }
    private void setData(){

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    /*public void openMenu(){

    }*/
}