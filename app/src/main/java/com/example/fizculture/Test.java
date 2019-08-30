package com.example.fizculture;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends FragmentActivity {
    public String test_answer;
    public String test_answers[]=new String[4];
    public int countOfRightAnswers;
    public String test_question;
    public int CountOfQuestion=1;
    public boolean next_question_available=false;
    public Button NextQuestion;
    public Button Answer[]=new Button[4];
    public int countOfAnswer=0;
    public TextView count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.tests_activity);
        NextQuestion=findViewById(R.id.next_question);
        Answer[0]=findViewById(R.id.TestAnswer1);
        Answer[1]=findViewById(R.id.TestAnswer2);
        Answer[2]=findViewById(R.id.TestAnswer3);
        Answer[3]=findViewById(R.id.TestAnswer4);
        count=findViewById(R.id.questionNumber);
    }
    @Override
    public void onBackPressed(){
        finish();
    }
    //Для представления программы не нужно обновлять вопрос, но для приложения его нужно прописать
    public void onClickTest(View v){
        switch (v.getId()){
            case R.id.TestAnswer1:
                setAnswer("1");
                countOfAnswer=0;
                Answer[countOfAnswer].setBackgroundColor(Color.parseColor("#29afdd"));
                Answer[1].setBackgroundColor(0xffffff);
                Answer[2].setBackgroundColor(0xffffff);
                Answer[3].setBackgroundColor(0xffffff);
            break;
            case R.id.TestAnswer2:
                setAnswer("2");
                countOfAnswer=1;
                Answer[countOfAnswer].setBackgroundColor(Color.parseColor("#29afdd"));
                Answer[0].setBackgroundColor(0xffffff);
                Answer[2].setBackgroundColor(0xffffff);
                Answer[3].setBackgroundColor(0xffffff);
                break;
            case R.id.TestAnswer3:
                setAnswer("3");
                countOfAnswer=2;
                Answer[countOfAnswer].setBackgroundColor(Color.parseColor("#29afdd"));
                Answer[0].setBackgroundColor(0xffffff);
                Answer[1].setBackgroundColor(0xffffff);
                Answer[3].setBackgroundColor(0xffffff);
                break;
            case R.id.TestAnswer4:
                setAnswer("4");
                countOfAnswer=3;
                Answer[countOfAnswer].setBackgroundColor(Color.parseColor("#29afdd"));
                Answer[0].setBackgroundColor(0xffffff);
                Answer[1].setBackgroundColor(0xffffff);
                Answer[2].setBackgroundColor(0xffffff);
                break;
            case R.id.next_question:
                if(next_question_available){
                    Answer[countOfAnswer].setBackgroundColor(0xffffff);
                    String text=Integer.toString(CountOfQuestion+1)+"/10";
                    count.setText(text);
                    next_question_available=false;
                    CountOfQuestion++;
                }
                break;
            case R.id.BackBtn:
                /*FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.testContainer);
                if (fragment == null) {
                    fragment = new Menu();
                    fm.beginTransaction()
                            .add(R.id.testContainer, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }*/
                Intent intentStudent = new Intent(this, Student_work.class);
                startActivity(intentStudent);
                break;
            case R.id.applyBtn:
                if (getAnswer().equals(getRightAnswer())){
                    Answer[countOfAnswer].setBackgroundColor(Color.parseColor("#51f0b5"));
                }
                else {Answer[countOfAnswer].setBackgroundColor(Color.parseColor("#fc7d5b"));}
                    next_question_available=true;
                break;
                //NextQuestion.setBackgroundColor();
                //работа с typeFace
        }
    }
    private void setQuestion(String s){
        test_question=s;
    }
    private void setAnswer(String s){
        test_answer=s;
    }
    private String getAnswer(){
        return test_answer;
    }
    private String getRightAnswer(){
        //Здесь наполовину костыль, при подключении к серверу изменить код
        String rightAnswer="";
        if (CountOfQuestion==1){rightAnswer="1";}
        if (CountOfQuestion==2){rightAnswer="2";}
        if (CountOfQuestion==3){rightAnswer="4";}
        if (CountOfQuestion==4){rightAnswer="2";}
        return rightAnswer;
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

