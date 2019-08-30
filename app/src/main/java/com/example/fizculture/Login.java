package com.example.fizculture;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    public static final String EXTRA_IS_TEACHER ="com.example.fizculture.isTeacher"; // дешифрует код переменной в этом интенте
    private boolean isTeacher; // дешифрует саму переменную в этом интенте
    public boolean remStatus=false;
    // ***************
    public SharedPreferences AutoLogin; // В локальном хранилище сохраняется последний введенный пароль и логин
    public String savedUsername="1234"; // Используется для дешифровки имени из файла AutoLogin
    public String savedPassword="12345"; // Используется для дешифровки пароля из файла AutoLogin
    public EditText username; // Здесь хранится виджет имени, введенном в этой Activity
    public EditText password; // Здесь хранится виджет пароля, введенного в этой Activity
    //String UserLogin=username.getText().toString();    // Внесение имени в строковую переменную
    //String UserPassword=password.getText().toString(); // Внесение пароля в строковую переменную
        // возможно, переменных довольно много, поэтому придется их перенести
    //*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.loginning);
        getSupportActionBar().hide();
        isTeacher = getIntent().getBooleanExtra(EXTRA_IS_TEACHER,false);
        remStatus=isTeacher;
        username =  findViewById(R.id.username);                    //******
        password =  findViewById(R.id.password);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                loadData();

                String UserLogin=username.getText().toString();
                String UserPassword=password.getText().toString();

                if (UserLogin.equals(savedUsername) && UserPassword.equals(savedPassword)){
                    if (remStatus){
                        Intent intentStudentWork = new Intent(this, MainActivity.class);
                        startActivity(intentStudentWork);
                    } else {
                        Intent intentTeacherWork = new Intent(this, Student_work.class);
                        startActivity(intentTeacherWork);
                    }
                }
                // Здесь будет код, который отправляет логин и пароль на сервер
                // А после получает ответ в виде bool переменной о том, что нашел/не нашел имя/пароль на сервере
                break;
        }
    }
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        finish();
    }
    void loadData() {
        AutoLogin = getSharedPreferences("test.txt",MODE_PRIVATE);
        savedUsername = AutoLogin.getString("login", "1234");
        savedPassword = AutoLogin.getString("password", "12345");
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
