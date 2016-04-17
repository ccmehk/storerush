package com.storerush.app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    public static List<StoreObject> datastores= new ArrayList<StoreObject>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //add test data
        ArrayList<ProductListItem> dataproducts = new ArrayList<ProductListItem>();
        ProductListItem p1 = new ProductListItem(ContextCompat.getDrawable(this, R.drawable.kimbab),
                "Kimbab", 1000,500,2,5);
        ProductListItem p2 = new ProductListItem(ContextCompat.getDrawable(this, R.drawable.kimbab),
                "Taejun", 100000,50,12,3);
        ProductListItem p3 = new ProductListItem(ContextCompat.getDrawable(this, R.drawable.kimbab),
                "KimKimbi",500000,4000,14,3);
        dataproducts.add(p1);
        dataproducts.add(p2);
        dataproducts.add(p3);
        ArrayList<ProductListItem> emptyProductList = new ArrayList<ProductListItem>();
        StoreObject s1= new StoreObject(R.drawable.store01, "7-eleven", "Hillier Commercial Building, 89-98 Wing Lok St (2541-3211)", "0.8km", "fresh-made daily sandwiches, hot and prepared food", dataproducts);
        StoreObject s2= new StoreObject(R.drawable.store02, "Panash", "Shop 305, 3/F, iSquare 63 Nathan Road, Tsim Sha Tsui", "1.2km", "resh-made pastries, muffins, sandwiches, cakes, etc", emptyProductList);
        StoreObject s3= new StoreObject(R.drawable.store03, "GS25", "abc", "abc", "abc", emptyProductList);
        StoreObject s4= new StoreObject(R.drawable.store04, "Subway", "abc", "abc", "abc", emptyProductList);

        datastores.add(s1);
        datastores.add(s2);
        datastores.add(s3);
        datastores.add(s4);


        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.actionbar);
//        bar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button storeBtn = (Button)findViewById(R.id.storeBtn);
        Button memberBtn = (Button)findViewById(R.id.memberBtn);

        storeBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), StorePage.class);
                startActivity(i);
            }
        });

        memberBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MemberPage.class);
                startActivity(i);
            }
        });
    }

}
