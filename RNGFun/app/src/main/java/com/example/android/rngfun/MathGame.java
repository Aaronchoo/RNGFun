package com.example.android.rngfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathGame extends AppCompatActivity {

    String answerOfMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
    }

    TextView mathQuestion = (TextView) findViewById(R.id.math_problem_time);
    //Creates a new question each time the problem is sovled
    public String newQuestion(){
        //Creates a random number from  1 -7
        double randomNumber = Math.random();
        randomNumber=randomNumber*7+1;
        int whichOperations = (int) randomNumber;
        double firstNumber = Math.random();
        double secondNumber =Math.random();
        if(whichOperations == 1 ||whichOperations ==  2){
            firstNumber=firstNumber*500+501;
            secondNumber=secondNumber*500+1;
            int firstNumbers = (int) firstNumber;
            int secondNumbers =(int) secondNumber;
            //1 equals subtraction
            if(whichOperations==1){
                int total = firstNumbers-secondNumbers;
                answerOfMath = firstNumbers + " - " + secondNumbers +" = " + total;
                return firstNumbers + " - " + secondNumbers +" = ";
            }
            else{
                int total = firstNumbers+secondNumbers;
                answerOfMath = firstNumbers + " + " + secondNumbers +" = " + total;
                return firstNumbers + " + " + secondNumbers +" = ";
            }
        }
        else if(whichOperations == 3 || whichOperations == 4){
            
        }
    }

    public void ButtonZero(View view){

    }
    public void ButtonOne(View view){

    }
    public void ButtonTwo(View view){

    }
    public void ButtonThree(View view){

    }
    public void ButtonFour(View view){

    }
    public void ButtonFive(View view){

    }
    public void ButtonSix(View view){

    }
    public void ButtonSeven(View view){

    }
    public void ButtonEight(View view){

    }
    public void ButtonNine(View view){

    }
    public void ButtonRemove(View view){

    }


}
