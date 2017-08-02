package com.example.android.rngfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MathGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
    }
    String answerOfMath = "1 + 1 = 2";
    int base=7;
    //Creates a new question each time the problem is sovled
    public String newQuestion(){
        //Creates a random number from  1 -5
        double randomNumber = Math.random();
        randomNumber=randomNumber*5+1;
        int whichOperations = (int) randomNumber;
        double firstNumber = Math.random();
        double secondNumber =Math.random();
        if(whichOperations == 1 ||whichOperations ==  2){
            firstNumber=firstNumber*630+501;
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
            firstNumber=firstNumber*15+15;
            secondNumber=secondNumber*15+2;
            int firstNumbers = (int) firstNumber;
            int secondNumbers =(int) secondNumber;
            int totalNumber = firstNumbers*secondNumbers;
            //Division
            if(whichOperations==3){
                answerOfMath = totalNumber + " / " + firstNumbers+ " = " +secondNumbers;
                return totalNumber + " / " + firstNumbers+ " = ";
            }
            else{
                answerOfMath = secondNumbers + " X " + firstNumbers+ " = " +totalNumber;
                return secondNumbers + " X " + firstNumbers+ " = ";
            }
        }
        else{
            firstNumber=firstNumber*20+1;
            secondNumber=secondNumber*2+2;
            int firstNumbers = (int) firstNumber;
            int secondNumbers =(int) secondNumber;
            int totalNumber=1;
            for(int i = 0; i <secondNumbers; i++) {
                totalNumber = totalNumber*firstNumbers;
            }
            answerOfMath = firstNumbers + "^" + secondNumbers + " = " + totalNumber;
            return firstNumbers + "^" + secondNumbers + " = ";
        }

    }

    public void updateValue(String s){

        final TextView mathQuestion= (TextView) findViewById(R.id.math_problem_time);
        String word=  mathQuestion.getText().toString();
        word = word + s;
        if(answerOfMath.equals(word)){
            mathQuestion.setText(newQuestion());
            base = mathQuestion.getText().length();
        }
        else{
            mathQuestion.setText(word);
        }
    }

    public void ButtonZero(View view){
        updateValue("0");

    }
    public void ButtonOne(View view){
        updateValue("1");
    }
    public void ButtonTwo(View view){
        updateValue("2");
    }
    public void ButtonThree(View view){
        updateValue("3");
    }
    public void ButtonFour(View view){
        updateValue("4");
    }
    public void ButtonFive(View view){
        updateValue("5");
    }
    public void ButtonSix(View view){
        updateValue("6");
    }
    public void ButtonSeven(View view){
        updateValue("7");
    }
    public void ButtonEight(View view){
        updateValue("8");
    }
    public void ButtonNine(View view){
        updateValue("9");
    }
    public void ButtonRemove(View view){
        final TextView mathQuestion= (TextView) findViewById(R.id.math_problem_time);
        int checkSize = mathQuestion.getText().length();
        if(checkSize != base){
            String sub = mathQuestion.getText().toString().substring(0,mathQuestion.getText().length()-1);
            mathQuestion.setText(sub);
        }
        else{
            Toast toast = Toast.makeText(this,"Solve this!!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }



}
