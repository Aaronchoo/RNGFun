package com.example.android.rhilltour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ChooA on 8/20/2017.
 */

public class previewAdapter extends ArrayAdapter<preview> {

    public previewAdapter(Activity context, ArrayList<preview> preview){
        super(context,0,preview);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.preview_set_up,parent,false);
        }

        final preview currentPreview = getItem(position);
        //Assign the preview image
        ImageView showLook = (ImageView) listItemView.findViewById(R.id.image_pre);
        showLook.setImageResource(currentPreview.getresourceId());
        //Assign the text
        TextView words = (TextView) listItemView.findViewById(R.id.pre_intro);
        words.setText(currentPreview.getIntro());

        return listItemView;



    }
}
