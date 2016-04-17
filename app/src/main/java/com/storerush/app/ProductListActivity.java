package com.storerush.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by PHS on 2016-04-16.
 */
public class ProductListActivity extends AppCompatActivity {
    ListView listview ;
    ProductListAdaptor adapter;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.actionbar);
        bar.setDisplayHomeAsUpEnabled(true);

        // Adapter 생성
        adapter = new ProductListAdaptor() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        for (int i = 0; i < MainActivity.datastores.get(0).productList.size(); i++) {
            adapter.addItem(MainActivity.datastores.get(0).productList.get(i)) ;
        }

        Button addBtn = (Button)findViewById(R.id.update);

        addBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AddProduct.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new ProductListAdaptor() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        for (int i = 0; i < MainActivity.datastores.get(0).productList.size(); i++) {
            adapter.addItem(MainActivity.datastores.get(0).productList.get(i)) ;
        }

        Log.d("ProductListActivity", "run in resume");
    }
}
