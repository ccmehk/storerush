package com.storerush.app;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by PHS on 2016-04-16.
 */
public class ProductListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        ListView listview ;
        ProductListAdaptor adapter;

        // Adapter 생성
        adapter = new ProductListAdaptor() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.kimbab),
                "kimbab", 1000,500,2,5) ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.kimbab),
                "Taejun", 100000,50,12,3) ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.kimbab),
                "Fuck",500000,4000,14,3) ;
    }
}
