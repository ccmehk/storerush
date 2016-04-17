package com.storerush.app;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ProductPage extends AppCompatActivity implements View.OnClickListener{
    ListView listview;
    ProductListPurchaseAdaptor adapter;
    int itemPos;

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
        setContentView(R.layout.activity_product_page);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.actionbar);
        bar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        itemPos = bundle.getInt("itemPos");
        Log.d("ProductPage", String.valueOf(itemPos));
    }

    protected void onResume() {
        super.onResume();

        adapter = new ProductListPurchaseAdaptor() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        for (int i = 0; i < MainActivity.datastores.get(itemPos).productList.size(); i++) {
            adapter.addItem(MainActivity.datastores.get(itemPos).productList.get(i)) ;
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());

                String productName= MainActivity.datastores.get(itemPos).productList.get(position).getName();
                int salePrice= MainActivity.datastores.get(itemPos).productList.get(position).getSale_price();

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(String.format(getResources().getString(R.string.dialog_message), productName, salePrice))
                        .setTitle(R.string.dialog_title)
                        .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });;

                // 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();
                dialog.show();

                Toast.makeText(getBaseContext(),Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });

        Log.d("ProductListActivity", "run in resume");

    }

    @Override
    public void onClick(View v) {
        Log.d("ProductPage", "click");
    }
}
