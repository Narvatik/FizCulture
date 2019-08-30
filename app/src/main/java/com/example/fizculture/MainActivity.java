package com.example.fizculture;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private TextView teacher_info;
    //private ConstraintLayout layOut;
    private RecyclerView recyclerView;
    private List<Student> students = new ArrayList<>();
    private String infoAboutTeacher;
    private String Text[]=new String[13];//В будущем массив динамический и содержит информацию о студентах;
    private String TextSt[]=new String[13];
    private boolean visits[]=new boolean[26];// Массив с посещениями студентов
    private TextView TextView[]=new TextView[13];
    private TextView TextViewSt[]=new TextView[13];
    private CheckBox checkBoxes[]=new CheckBox[26];
    private TextView Data;
    private String text;
    private Button addStudent;
    private Button logOut;
    private boolean fragmentClose=false;
    private boolean fragmentCloseMenu=false;
    private FragmentManager fm1;
    private Fragment fragment1;
    private FragmentManager fm;
    private Fragment fragment;
    public int i=20;
    final Context context = this;
    private String str="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.teacher_activity);
        setData();
        setInitialData();
        recyclerView = findViewById(R.id.list);
        DataAdapter adapter = new DataAdapter(this, students);
        recyclerView.setAdapter(adapter);
        addStudent=findViewById(R.id.add_student);
    }
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }
    public void onClickTeacher(View view) {
        switch (view.getId()) {
            case R.id.openCalendar:
                Intent intentCalendar = new Intent(MainActivity.this, com.example.fizculture.Calendar.class);
                startActivity(intentCalendar);
                break;
            case R.id.LogOut:
                Intent intentLogOut = new Intent(this, Login.class);
                startActivity(intentLogOut);
                break;
            case R.id.Menu:
                /*Intent intentMenu = new Intent(this, MenuActivity.class);
                startActivity(intentMenu);*/
                //recyclerView.setVisibility(View.INVISIBLE);
                //layOut.setVisibility(View.INVISIBLE);
                //Нужен код, который убирает все, что было на экране до этого, а потом возвращает!!!
                // Весь следующий код вставляет фрагмент меню на экран
                if(!fragmentCloseMenu){
                fm = getSupportFragmentManager();
                fragment = fm.findFragmentById(R.id.teacherContainer);
                //if (fragment == null) {
                    fragment = new Menu();
                    fm.beginTransaction()
                            .add(R.id.teacherContainer, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                //}
                    fragmentCloseMenu=true;
                }else {
                    fragment.getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                    fragmentCloseMenu=false;
                }
                 //новый интент меню:
                break;
            case R.id.add_student:
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompt_add, null);

                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                mDialogBuilder.setView(promptsView);

                final EditText eName =  promptsView.findViewById(R.id.name);
                final EditText eSecond_name =  promptsView.findViewById(R.id.second_name);
                final EditText eCourse = promptsView.findViewById(R.id.course);
                final EditText eObuch = promptsView.findViewById(R.id.obuch);
                final EditText eGroup = promptsView.findViewById(R.id.group);

                //Настраиваем сообщение в диалоговом окне:
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        str=String.valueOf(eName.getText())+" "+String.valueOf(eSecond_name.getText());
                                        students.add(new Student (str, "12 сек",false,false));
                                    }
                                })
                        .setNegativeButton("Отмена",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();
                // Сделать 13 кнопок, которые будут становиться видимыми при параметре, который будет у каждой группы
                i++;

                recyclerView = findViewById(R.id.list);
                DataAdapter adapter = new DataAdapter(this, students);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.choose_standard:
                if (!fragmentClose) {
                    fm1 = getSupportFragmentManager();
                    fragment1 = fm1.findFragmentById(R.id.teacherContainer);
                    //if (fragment1 == null) {
                    fragment1 = new Standard();
                    fm1.beginTransaction()
                            .add(R.id.teacherContainer, fragment1)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                    //}
                    fragmentClose=true;
                }else {
                    fragment1.getActivity().getSupportFragmentManager().beginTransaction().remove(fragment1).commit();
                    fragmentClose=false;
                }
                break;
        }
    }

    /*public void onClicAdd(View v){
        switch(v.getId()){
            case R.id.add_student:
                LayoutInflater li=LayoutInflater.from(context);
                View prompt_add=
                break;
        }
    }*/


    public void loadData(){

    }
    private void loadStartTeacherData(){

        infoAboutTeacher="Чичерин В.П.";
        for (int i=0;i<13;i++){
            Text[i]="Студент " + Integer.toString(i);
        }
        for (int i=0;i<26;i++){
            if (i%2==0){visits[i]=true;}
        }
        for (int i=0;i<13;i++){
            TextSt[i]=Integer.toString(i) + " сек";
        }
        //код, который получает всю информацию с сервера для стартового экрана активити
    }
    private void setInitialData(){
        for (int i=1;i<21;i++){
            students.add(new Student ("Студент "+Integer.toString(i), "10 сек",true,false));
            i++;
            students.add(new Student ("Студент "+Integer.toString(i), "12 сек",false,true));
            i++;
            students.add(new Student ("Студент "+Integer.toString(i), "11 сек",true,true));
            i++;
            students.add(new Student ("Студент "+Integer.toString(i), "9  сек",false,false));
        }
    }
    public void setData(){
        Calendar date = Calendar.getInstance();
        int day=date.get(date.DAY_OF_MONTH);
        int month=date.get(date.MONTH);
        int year=date.get(date.YEAR);
        text = Integer.toString(day)+"."+ Integer.toString(month+1)+"."+Integer.toString(year);
        Data=findViewById(R.id.Date);
        Data.setText(text);
    }
    private void setStartTeacherData(){
        teacher_info=findViewById(R.id.teacher_info);

        for (int i=0;i<13;i++){
            TextView[i].setText(Text[i]);
            checkBoxes[i*2].setChecked(visits[i*2]);
            checkBoxes[i*2-1].setChecked(visits[i*2-1]);
            TextViewSt[i].setText(TextSt[i]);
        }
        teacher_info.setText(infoAboutTeacher);

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
