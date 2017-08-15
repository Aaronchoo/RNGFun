package com.example.android.rngfun;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by ChooA on 8/15/2017.
 */

public class ListDetailsAdapter extends ArrayAdapter<ListDetails> {

    public ListDetailsAdapter(Context context, ArrayList<ListDetails> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.names_layout,parent,false);
        }

        final ListDetails currentDetail = getItem(position);

        TextView name = (TextView) listView.findViewById(R.id.name_part);
        name.setText(currentDetail.getName());

        TextView detail = (TextView) listView.findViewById(R.id.detail_part);
        detail.setText(currentDetail.getDetails());

        return  listView;

     }
}
