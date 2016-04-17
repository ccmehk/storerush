package com.storerush.app;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/16/2016.
 */
public class StoreObject {
    private int mImage;
    private String mName;
    private String mLoc;
    private String mDis;
    private String mDesc;
    public ArrayList<ProductListItem> productList;


    StoreObject (int img, String name, String loc, String dis, String desc){
        mImage = img;
        mName = name;
        mLoc = loc;
        mDis = dis;
        mDesc = desc;
    }

    StoreObject (int img, String name, String loc, String dis, String desc, ArrayList<ProductListItem> productList){
        mImage = img;
        mName = name;
        mLoc = loc;
        mDis = dis;
        mDesc = desc;
        this.productList = productList;

    }

    public int getmImage(){
        return mImage;
    }
    public void setmImage(int img){
        this.mImage = img;
    }

    public String getmName(){
        return mName;
    }
    public void setmName(String name){
        this.mName = name;
    }

    public String getmLoc(){
        return mLoc;
    }
    public void setmLoc(String loc){
        this.mLoc = loc;
    }

    public String getmDis(){
        return mDis;
    }
    public void setmDis(String dis){
        this.mDis = dis;
    }

    public String getmDesc(){
        return mDesc;
    }
    public void setmDesc(String desc){
        this.mDesc = desc;
    }
}
