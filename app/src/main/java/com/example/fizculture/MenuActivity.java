package com.example.fizculture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_intent_new);
    }

    public void onClickMenu(View v) {
        switch (v.getId()) {
            case R.id.setting1:
                Intent intentSetting1 = new Intent(this, Setting1_teacher_intent.class);
                startActivity(intentSetting1);
                break;
            case R.id.setting2:
                Intent intentSetting2 = new Intent(this, Setting2_teacher_intent.class);
                startActivity(intentSetting2);
                break;
            case R.id.setting3:
                Intent intentSetting3 = new Intent(this, Login.class);
                startActivity(intentSetting3);
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
