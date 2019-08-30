package com.example.fizculture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Standard extends Fragment {

    private Button standard1;  // 3 виджета кнопки, которые отвечают за выбор норматива
    private Button standard2;
    private Button standard3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.standard_fragment, container, false);
    standard1=v.findViewById(R.id.setting1);
        standard1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //updateData();
        }
    });
    standard2=v.findViewById(R.id.setting2);
        standard2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //updateData();
        }
    });
    standard3=v.findViewById(R.id.setting3);
        standard3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //updateData();
        }
    });
        return v;
    }
    public void updateData(){
        standard1.setVisibility(View.INVISIBLE);
        standard1.setEnabled(false);
        standard2.setVisibility(View.INVISIBLE);
        standard2.setEnabled(false);
        standard3.setVisibility(View.INVISIBLE);
        standard3.setEnabled(false);
    }
}
