package com.storerush.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * Created by PHS on 2016-04-17.
 */
public class AddProduct extends AppCompatActivity {
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
        setContentView(R.layout.activity_add_product);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.actionbar);
        bar.setDisplayHomeAsUpEnabled(true);


        final EditText productNameET = (EditText)findViewById(R.id.product_name_input);
        final EditText originalPriceET = (EditText)findViewById(R.id.originalPrice_input);
        final EditText priceET = (EditText)findViewById(R.id.price_input);
        final EditText expiredDateEt = (EditText)findViewById(R.id.expiredDate_input);
        final NumberPicker np = (NumberPicker) findViewById(R.id.quantity_input);
        np.setMinValue(1);
        np.setMaxValue(20);
        np.setWrapSelectorWheel(false);
        np.setValue(1);

        Button addBtn = (Button)findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                ProductListItem item = new ProductListItem(getResources().getDrawable(R.drawable.kimbab),
                        productNameET.getText().toString(),
                        Integer.parseInt(originalPriceET.getText().toString()),
                        Integer.parseInt(priceET.getText().toString()),
                        Integer.parseInt(expiredDateEt.getText().toString()),
                        np.getValue()
                );

                MainActivity.datastores.get(0).productList.add(item);

                finish();
            }
        });




    }
}
