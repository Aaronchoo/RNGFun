package com.example.android.rhilltour;

/**
 * Created by ChooA on 8/20/2017.
 */
/*
    Create a class that will be used to create an array list to hold the image and preview of the info
 */
public class preview {

    //String that holds the preview
    private String mIntro;
    //String that holds the extra details #1
    private String mExtraOne="";
    //String that holds the extra detail #2
    private String mExtraTwo="";
    //HOlds the picture
    private int mResourceId;

    //Get words and image id
    public preview(String prepWord, int Resource) {
        mIntro = prepWord;
        mResourceId = Resource;
    }

    //Second case is if they're passing in more details
    public preview(String prepWord, int Resource, String detailOne, String detailTwo) {
        mIntro = prepWord;
        mResourceId = Resource;
        mExtraOne = detailOne;
        mExtraTwo = detailTwo;
    }

    //Returns the intro/preview
    public String getIntro() {
        return mIntro;
    }

    public String getExtraOne() {
        return mExtraOne;
    }

    public String getExtraTwo() {
        return mExtraTwo;
    }

    //Returns the image id
    public int getresourceId() {
        return mResourceId;
    }
}
