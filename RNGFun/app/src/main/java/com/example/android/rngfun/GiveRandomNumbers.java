package com.example.android.rngfun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class GiveRandomNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_random_numbers);
    }
    //Decided to use an onclick method instead of a onclicklistener jsut for fun
    public void giveRandomNumber(View v){

        EditText smallestInput = (EditText) findViewById(R.id.random_number_smallest_input);
        EditText largestInput = (EditText) findViewById(R.id.random_number_largest_input);
        //Check to see if the editText are empty
        if(smallestInput.getText().toString().length() ==0 || largestInput.getText().toString().length() == 0){
            //Will tell the user to add numbers since they left one or both blank
            Toast addStuff = Toast.makeText(this,"Add the Range!",Toast.LENGTH_SHORT);
            addStuff.show();
        }
        //Checks to see if it's too long
        else if(smallestInput.getText().toString().length() > 10|| largestInput.getText().toString().length() >10){
            //Will tell the user that number is too long
            Toast addStuff = Toast.makeText(this,"Those are some big numbers! Please make them smaller :(",Toast.LENGTH_SHORT);
            addStuff.show();
        }
        else {
            //Convert the strings into integers
            long smallest = Long.parseLong(smallestInput.getText().toString());
            long largest = Long.parseLong(largestInput.getText().toString());
            //Check if the smallest is actually the smallest
            if (smallest > largest) {
                //If not tell them to fix it
                Toast addStuff = Toast.makeText(this, "Cannot have the smaller number bigger than the other", Toast.LENGTH_SHORT);
                addStuff.show();
            }
            //Check to see if it is beyond the limit
            else if (smallest < -2147483648 || largest > 2147483647) {
                //Tell them the number is too big
                Toast addStuff = Toast.makeText(this, "Numbers are too big/small!!!", Toast.LENGTH_SHORT);
                addStuff.show();
            }
            else{
                //Create the Random nUMBER generator
                double randomNumber = Math.random();
                //Create the range of the random number
                randomNumber = randomNumber*(largest-smallest)+smallest;
                //Cast the double to be an integer
                long nice = (long) randomNumber;
                TextView showRandom = (TextView)findViewById(R.id.show_the_number);
                //Set the text to the new Random Number
                showRandom.setText("The number is: " + '\n' + nice);

            }
        }



    }
}
