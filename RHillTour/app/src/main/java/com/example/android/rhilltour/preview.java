package com.example.android.rhilltour;

/**
 * Created by ChooA on 8/20/2017.
 */
/*
    Create a class that will be used to create an array list to hold the image and preview of the info
 */
public class preview  {

    //String that holds the preview
    private String mIntro;
    //HOlds the picture
    private int mResourceId;

    //Get words and image id
    public preview(String prepWord, int Resource){
        mIntro=prepWord;
        mResourceId=Resource;
    }

    //Returns the intro/preview
    public String getIntro(){
        return mIntro;
    }

    //Returns the image id
    public int getresourceId(){
        return mResourceId;
    }
}
