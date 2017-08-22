package com.example.android.rhilltour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Creature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature);
        ArrayList<preview> creatures = new ArrayList<preview>();
        creatures.add(new preview("Name: Staplet",R.drawable.staplet,"Appearance: The Staple can range from 1 meter tall to 70 meters. It has 2 legs that are able to split apart when needed to move and a thin tail that can be used while hunting. Their bodies are long but their neck is even longer. On top of that, they have bright red eyes and has a touch that can split into two. The body is a pale colour that has streaks of black and grey lines.","Abilities:  They are able to grow or shrink depending on their surroundings. To hunt and capture large prey, they increase their size and to walk on water or tavel fast they shrink.  Their tails have the ability to become stronger than endophomite, a very strong substance, and used to peirce prey. It is said that looking into the eyes of a Staplet will cause a hypnotic effect."));
        creatures.add(new preview("Name: The Watcher",R.drawable.thewatcher,"Appearance: Born from the void, they are ghost-like creatures that can have as many arms as they want. Their  key features are their glowing green eyes and grey bodies.","Abilities: Not much is known about these creatures. Rumors has it they are able to create as many arms as they can. There aren't many that have lived after seeing the watchers."));
        creatures.add(new preview("Name: SeaCloth",R.drawable.seacolth,"Appearance: Contrasting the blue liquid it lives in, the white SeaCloth has 4 spikes on it's back, a tail used to move, and a large head. The nose is quite big which allows them to hunt preys and protect themselves. Strangely, the red lines, the viens all point to the center of their entire body. Their eyes have a hint of pink with a black outline and a small redness inside, giving the look of fear and insanity.","Abilities: Fortunatelly, the only ability the SeaCloth has comes from their oversized nose. They are able to create two substances, one that is highly poisionous and another that paralyzes those that touch it. Unfortunately, the SeaCloth is able to mix up the substatnces, spit out 20 per second and the subtances look identical (the red pins)."));
        previewAdapter previewCreature = new previewAdapter(this,creatures);
        ListView listCreature = (ListView) findViewById(R.id.list_animal);
        listCreature.setAdapter(previewCreature);
    }
}
