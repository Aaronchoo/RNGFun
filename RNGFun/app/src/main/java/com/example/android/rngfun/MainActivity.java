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

        Button headsOrTails = (Button) findViewById(R.id.heads_or_tails_start);
        headsOrTails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHeadsOrTails = new Intent(MainActivity.this, HeadsOrTailsFair.class);
                startActivity(openHeadsOrTails);
            }
        });

        Button rockPaperScissors = (Button) findViewById(R.id.rock_paper_scissors);
        rockPaperScissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent openRock = new Intent(MainActivity.this,RockPaperScissors.class);
                startActivity(openRock);
            }

        });

        Button realRandomNumber = (Button) findViewById(R.id.giving_a_random_number);
        realRandomNumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startRandomNumber = new Intent(MainActivity.this,GiveRandomNumbers.class);
                startActivity(startRandomNumber);
            }
        });
        Button choosingChoice = (Button) findViewById(R.id.choosing_names);
        choosingChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startChoices = new Intent(MainActivity.this, NameActivity.class);
                startActivity(startChoices);
            }
        });

        //Unsure why onclick did not work (Must check later)
        Button startMathGame = (Button) findViewById(R.id.math_game_start);
        startMathGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            Intent startMathGames = new Intent(MainActivity.this,MathGame.class);
            startActivity(startMathGames);
            }
        });

    }

}
