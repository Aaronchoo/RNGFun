package com.example.android.rngfun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.onClick;
import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the first button to the heads or tails
        Button headsOrTails = (Button) findViewById(R.id.heads_or_tails_start);
        headsOrTails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets an onclicklistener to open the heads or tails screen when the heads or tails
                // button is being clicked
                Intent openHeadsOrTails = new Intent(MainActivity.this, HeadsOrTailsFair.class);
                startActivity(openHeadsOrTails);
            }
        });

        //Assign the second button to the rock paper scissors game
        Button rockPaperScissors = (Button) findViewById(R.id.rock_paper_scissors);
        //Makes the program wait for possible interactions such as the button being pressed
        rockPaperScissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //If the button is pressed then open the rock paper scissors activity
                Intent openRock = new Intent(MainActivity.this,RockPaperScissors.class);
                startActivity(openRock);
            }

        });

        //Assigning the third button to the RNG number button
        Button realRandomNumber = (Button) findViewById(R.id.giving_a_random_number);
        //When the button is clicked the application will open the RNG number generator acitivity
        realRandomNumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startRandomNumber = new Intent(MainActivity.this,GiveRandomNumbers.class);
                startActivity(startRandomNumber);
            }
        });

        //Assigning the fourth button to the random name chooser button
        Button choosingChoice = (Button) findViewById(R.id.choosing_names);
        //When the button is clicked the application will open the name activity
        choosingChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startChoices = new Intent(MainActivity.this, NameActivity.class);
                startActivity(startChoices);
            }
        });


        //Assign the last button the the math game
        Button startMathGame = (Button) findViewById(R.id.math_game_start);
        //Will open the math game activty when pressed
        startMathGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            Intent startMathGames = new Intent(MainActivity.this,MathGame.class);
            startActivity(startMathGames);
            }
        });



    }

}
