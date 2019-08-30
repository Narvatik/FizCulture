package com.example.fizculture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Menu extends Fragment {

    private Button option;  // 3 Виджета кнопки, с помощью которого мы будем брать информацию о изменениях в какой-либо настройке
    private Button option2;
    private Button option3;
    public boolean setting1=false; // 3 Переменные, которые изменяют настройки при нажатии на кнопку
    public boolean setting2=false;
    public boolean setting3=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_activity_teacher, container, false);
        // Примечание: весь код, который работает с activity меню, нужно вставить между строкой выше и "return v"
        option=v.findViewById(R.id.option);
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting1 = new Intent(getActivity(), Setting1_teacher_intent.class);
                startActivity(intentSetting1);
            }
        });
        option2=v.findViewById(R.id.option2);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting1 = new Intent(getActivity(), Setting2_teacher_intent.class);
                startActivity(intentSetting1);
            }
        });
        option3=v.findViewById(R.id.option3);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting1 = new Intent(getActivity(), Choose_status.class);
                startActivity(intentSetting1);
            }
        });
        return v;
    }

}