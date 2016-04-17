package com.storerush.app;

import android.graphics.drawable.Drawable;

/**
 * Created by PHS on 2016-04-16.
 */
public class ProductListItem {
    public Drawable image;
    public String name;
    public int normal_price;
    public int sale_price;
    public int end_time;
    public int quantity;

    public Drawable getImage(){return image; }
    public String getName(){return name;}
    public int getNormal_price(){return normal_price;}
    public int getSale_price(){return sale_price;}
    public int getEnd_time(){return end_time;}
    public int getQuantity(){return quantity;}

    public ProductListItem(){

    }

    public ProductListItem (Drawable image, String name, int normal_price, int sale_price, int end_time, int quantity){
        this.image=image;
        this.name=name;
        this.normal_price=normal_price;
        this.sale_price=sale_price;
        this.end_time=end_time;
        this.quantity=quantity;
    }
}
