package com.example.android.rhilltour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an array list of preview
        ArrayList<preview> previewTopics= new ArrayList<preview>();
        //Saving/adding new previews that require the preview words and a picture that goes with it
        previewTopics.add(new preview("Welcome to mystery and wonderful fantasy world of Hypella. Come learn about the world, the creatures, the story,and much more!",R.drawable.maincharacter));
        previewTopics.add(new preview("Enjoy the adventure and story by understanding the setting!",R.drawable.worldmap));
        previewTopics.add(new preview("Look out for these wonderful creatures!",R.drawable.staplet));
        previewAdapter previewAdapt = new previewAdapter(this, previewTopics);
        ListView listPreview = (ListView) findViewById(R.id.list_objects);
        listPreview.setAdapter(previewAdapt);

        //Have an listener to act when buttons are clicked
        listPreview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //If it's the first position, open the introduction inventory
                    Intent openIntro = new Intent(MainActivity.this,IntroductionFantasy.class);
                    startActivity(openIntro);
                }
                else if(i==1){
                    Intent openWorld = new Intent(MainActivity.this,World.class);
                    startActivity(openWorld);
                }
                else{
                    Intent openCreatures = new Intent(MainActivity.this,Creature.class);
                    startActivity(openCreatures);
                }
            }
        });
    }
}
