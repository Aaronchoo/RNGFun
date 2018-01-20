package com.example.android.rngfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RockPaperScissors extends AppCompatActivity {
    //An integer that will count the totalNumberOfFlips number of times the person has played the game
    int countNumberOfGames = 0;
    //The integer that will count the totalNumberOfFlips number of wins the person has gotten
    int wins = 0;
    //The number of times the player has lost the game
    int loss = 0;
    //The number of ties the player has
    int tie = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        //Assign associated views to ids
        final EditText userInputRoPaSci = (EditText) findViewById(R.id.input_rock_paper_or_scissors);
        final Button btnRoPaSci = (Button) findViewById(R.id.rng_for_ropasci);
        final TextView answerForRoPaSci = (TextView) findViewById(R.id.answer_for_ro_pa_sci);
        final TextView titleForRoPaSci = (TextView) findViewById(R.id.title_of_game_for_rock_paper_scissors);
        final ImageView rockPaperOrSciPic = (ImageView) findViewById(R.id.out_of_three_ropasci);
        final TextView  countTheWins = (TextView) findViewById(R.id.counter_wins_or_loss_in_RoPaSci);

        //Onclicklistener that will activate when the button is pressed
        btnRoPaSci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Take the user input and save it to a string
                String userInput = userInputRoPaSci.getText().toString();
                //Make the input into all upper case so it is easier to compare
                userInput=userInput.toUpperCase();
                //Set up the rng
                double randomNumber = Math.random();
                //Set up the rang of the int
                randomNumber = randomNumber*3 + 1;
                //Casting it and getting rid of the decimals
                int randomCasted = (int) randomNumber;
                //The value 1 represents the rng choosing paper
                if(randomCasted == 1){
                    //Will save the string of whether the player won or not
                    String answer;
                    //Checks if the user chose scissors as scissors beats rock therefore they win
                    if(userInput.equals("SCISSORS") ||userInput.equals("SCISSOR")){
                        //Tells them they win and update the win count
                        answer = "You Win!";
                        wins+=1;
                    }
                    //Else they check if they chose paper
                    else if(userInput.equals("PAPER")){
                        //It would be a tie because they chose the same thing
                        //Update the string and tie countNumberOfGames
                        answer = "Ohh it's a tie! :O";
                                tie+=1;
                    }
                    //If their input isn't the other two meaning it's rock or something random they lose
                    else{
                        //Update the string to tell the player lost and increase loss countNumberOfGames
                        answer = "You lose :(";
                        loss+=1;
                    }
                    //Update the TextView to tell the player the situation
                    answerForRoPaSci.setText("Paper! " + answer);
                    rockPaperOrSciPic.setImageResource(R.drawable.paper);
                }
                //2 represents the rng choosing scissors
                else if(randomCasted == 2){
                    //The string will update the information
                    String answer;
                    //Checks if the user inputted rock as rock beats scissors
                    if(userInput.equals("ROCK")){
                        //Updates the player that they have beaten the rng and increase countNumberOfGames
                        answer = "You Win!";
                        wins+=1;
                    }
                    //Will check if the user also had the same idea as the RNG
                    else if(userInput.equals("SCISSORS") ||userInput.equals("SCISSOR")){
                        //Updates the user that they have tied and increase tie countNumberOfGames
                        answer = "Ohh it's a tie! :O";
                        tie+=1;
                    }
                    //Otherwise they lost
                    else{
                        //Updates the user that they have lost to the RNG and increase loss countNumberOfGames
                        answer = "You lose :(";
                        loss+=1;
                    }
                    //The TextView will tell the user the situation and also update the image
                    answerForRoPaSci.setText("Scissors! " + answer);
                    rockPaperOrSciPic.setImageResource(R.drawable.scissors);
                }
                //Finally, we have reached rock as an option (It's what's left)
                else{
                    //Will store text that will be displayed later
                    String answer;
                    //Checks to see if the user has entered paper
                    if(userInput.equals("PAPER")){
                        //Since paper beats rock they win and this should be stored in the string
                        answer = "You Win!";
                        //Update the win countNumberOfGames
                        wins+=1;
                    }
                    //Check if they had the same idea as the rng "rock"
                    else if(userInput.equals("ROCK")){
                        //Save string that will tell user it's a tie
                        answer = "Ohh it's a tie! :O";
                        //Counter for tie will be increased by one
                        tie+=1;
                    }
                    //This just checks for the last case senario which is a loss
                    else{
                        //Update the user/player on their situation
                        answer = "You lose :(";
                        loss+=1;
                    }
                    //Update them on what the RNG chose and their win/loss/tie
                    answerForRoPaSci.setText("Rock! " + answer);
                    rockPaperOrSciPic.setImageResource(R.drawable.rock);

                }
                //Increase the totalNumberOfFlips countNumberOfGames
                countNumberOfGames +=1;
                //Display that totalNumberOfFlips number in the title
                titleForRoPaSci.setText("Rock, Paper, or Scissors: " + countNumberOfGames);
                //Below show the number of wins/loss/ties
                countTheWins.setText("Wins: " + wins + '\n' + "Ties: " + tie+ '\n' + "Losses: " + loss);
            }
        });
    }
}
