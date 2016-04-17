package com.storerush.app;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MemberPage extends AppCompatActivity {
    private static String LOG_TAG = "MemberPage";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int imageId[] = {R.drawable.store01, R.drawable.store02, R.drawable.store03, R.drawable.store04};

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
        setContentView(R.layout.activity_member_page);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.actionbar);
        bar.setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


//        String myDataset[] = {"sadsadad","asdadasda","asdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasdaasdadasda"};
        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
          @Override
          public void onItemClick(int position, View v) {
              Log.i(LOG_TAG, " Clicked on Item " + position);
              Intent i = new Intent(v.getContext(), ProductPage.class);
              i.putExtra("itemPos", position);
              startActivity(i);
          }
        });
    }

    private ArrayList<StoreObject> getDataSet() {
        ArrayList results = new ArrayList<StoreObject>();
        for (int i = 0; i < MainActivity.datastores.size(); i++) {
            results.add(MainActivity.datastores.get(i));
        }

        return results;
    }

}
