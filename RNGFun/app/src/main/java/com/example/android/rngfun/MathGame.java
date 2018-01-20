package com.example.android.rngfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.input;

public class MathGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
    }
    //Create a placeholder for the solution
    String answerOfMath = "Placeholder";
    // Counts the number of levels completed
    int howMany =0;
    //Will determine the bounds/number of characters the user cannot delete (counted from the start)
    int base=16;
    //Holds the current level the player is on
    int currentLevel=0;

    //A void function that is used to start the game by letting user choose level
    public void getLevel(View view){
        //Link the view to the layout id
        final TextView mathQuestion= (TextView) findViewById(R.id.math_problem_time);
        //Get the level the user wants to play
        String level = mathQuestion.getText().toString();
        if(level.length() == 16){
            //If the string length is 16, this means the user has not entered anything
            //Prompt users to input value
            Toast toast = Toast.makeText(this, "Enter a level!",Toast.LENGTH_SHORT);
            toast.show();
        }//This means that they entered a number that is at least a 3 digit number
        else if(level.length() >  19){
            //Prompt the user to input a value that is  1 - 99
            Toast toast = Toast.makeText(this, "Choose a level between 1 and 99!!!",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            //Get the level of the of the string
            String actualLevel = level.substring(16,level.length());
            //Convert the string to an integer
            int numberLevel = Integer.parseInt(actualLevel);
            //If they manage to enter a level below 1
            if(numberLevel < 1){
                //Prompt users to enter a valid level
                Toast toast = Toast.makeText(this, "Please enter a level between 1 and 99!",Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                //Save the level and change the global value to be the given level
                currentLevel = numberLevel;
                //Let's the user submit the level
                Button start = (Button) findViewById(R.id.submit_level);
                //Start the questions
                mathQuestion.setText(newQuestion());
                //Save the new base to prevent question from being deleted
                base = mathQuestion.getText().length();
                //Set the title to hold the level
                setTitle("Math Challenge! Level: " + currentLevel);
                //Make the start button disappear
                start.setVisibility(View.GONE);
            }
        }
    }
    //Creates a new question each time the problem is solved
    public String newQuestion(){
        //Creates a random number from  1 -5
        double randomNumber = Math.random();
        randomNumber=randomNumber*5+1;
        //Each operation will link to an operation
        int whichOperations = (int) randomNumber;
        //Have the numbers randomly generate
        double firstNumber = Math.random();
        double secondNumber =Math.random();
        //If it is either addition or subtraction
        if(whichOperations == 1 ||whichOperations ==  2){
            //Change the numbers based on the levels
            firstNumber=firstNumber*(currentLevel*100)+501;
            secondNumber=secondNumber*(currentLevel*100)+1;
            //Cast value so the answer is an integer
            int firstNumbers = (int) firstNumber;
            int secondNumbers =(int) secondNumber;
            //1 equals subtraction
            if(whichOperations==1){
                //Find out the answer and save the string answer
                int total = firstNumbers-secondNumbers;
                answerOfMath = firstNumbers + " - " + secondNumbers +" = " + total;
                //Return the question
                return firstNumbers + " - " + secondNumbers +" = ";
            }
            else{
                //Calculate the answer and save the string to the global variable
                int total = firstNumbers+secondNumbers;
                answerOfMath = firstNumbers + " + " + secondNumbers +" = " + total;
                //Return question
                return firstNumbers + " + " + secondNumbers +" = ";
            }
        }//If the rng choose division or multiplication
        else if(whichOperations == 3 || whichOperations == 4){
            //Alter the values to make it fit the current level
            firstNumber=firstNumber*(currentLevel*10)+15;
            secondNumber=secondNumber*(currentLevel*10)+2;
            int firstNumbers = (int) firstNumber;
            int secondNumbers =(int) secondNumber;
            //Find the answer of them being multiplied
            int totalNumber = firstNumbers*secondNumbers;
            //Division
            if(whichOperations==3){
                //Save the answer and return the question
                answerOfMath = totalNumber + " / " + firstNumbers+ " = " +secondNumbers;
                return totalNumber + " / " + firstNumbers+ " = ";
            }//Multiplication
            else{
                //Save the answer and return the question
                answerOfMath = secondNumbers + " X " + firstNumbers+ " = " +totalNumber;
                return secondNumbers + " X " + firstNumbers+ " = ";
            }
        }//Otherwise it is exponential
        else{
            //Alter values for level
            firstNumber=firstNumber*(currentLevel*3)+1;
            secondNumber=secondNumber*3+2;
            int firstNumbers = (int) firstNumber;
            int secondNumbers =(int) secondNumber;
            int totalNumber=1;
            //Generate value
            for(int i = 0; i <secondNumbers; i++) {
                totalNumber = totalNumber*firstNumbers;
            }
            //Save and return answer
            answerOfMath = firstNumbers + "^" + secondNumbers + " = " + totalNumber;
            return firstNumbers + "^" + secondNumbers + " = ";
        }

    }

    //Update the string that shows the question  and user input
    public void updateValue(String s){


        final TextView mathQuestion= (TextView) findViewById(R.id.math_problem_time);
        //Get the current text
        String word=  mathQuestion.getText().toString();
        //Update string to include the input
        word = word + s;
        //If the input matches the asnwer
        if(answerOfMath.equals(word)){
            //Set it to a new question
            mathQuestion.setText(newQuestion());
            howMany +=1;
            //If they solved 25 questions they level up
            if(howMany ==25){
                //Up the level count
                currentLevel+=1;
                //Checks if the user is above 99 levels
                if(currentLevel >= 100){
                    //When they go beyond level 99, the title will change
                    setTitle("HARD MODE! LEVEL: " + (currentLevel - 99));
                }
                else{
                    //Update level
                    setTitle("Math Challenge! Level: " + currentLevel);
                }
                //Reset number of questions completed for the level
                howMany =0;
            }
            //Change the base again
            base = mathQuestion.getText().length();

        }
        else{
            //Otherwise update text to input
            mathQuestion.setText(word);
        }
    }

    //These functions update the text value
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
        //Gets the length of the string
        int checkSize = mathQuestion.getText().length();
        //Checks if the length is not equal to the preset base of characters not able to be deleted
        if(checkSize != base){
            //Delete the last character and update
            String sub = mathQuestion.getText().toString().substring(0,mathQuestion.getText().length()-1);
            mathQuestion.setText(sub);
        }
        else{
            //Otherwise tell user they have to solve question
            Toast toast = Toast.makeText(this,"Solve this!!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }



}
