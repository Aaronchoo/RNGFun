package com.example.android.rhilltour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroductionFantasy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_fantasy);

        Button creature = (Button) findViewById(R.id.creatureSeeker);
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCreatures = new Intent(IntroductionFantasy.this,Creature.class);
                startActivity(openCreatures);
            }
        });
        Button world = (Button) findViewById(R.id.worldSeeker);
        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openWorld = new Intent(IntroductionFantasy.this,World.class);
                startActivity(openWorld);
            }
        });
    }
}
