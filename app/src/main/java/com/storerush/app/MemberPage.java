package com.storerush.app;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MemberPage extends AppCompatActivity {
    private static String LOG_TAG = "MemberPage";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int imageId[] = {R.drawable.store01, R.drawable.store02, R.drawable.store03, R.drawable.store04};
    private String name[] = {"7-eleven", "Panash", "GS25", "Subway"};
    private String loc[] = {"Hillier Commercial Building, 89-98 Wing Lok St (2541-3211)", "abc", "abc", "abc"};
    private String dis[] = {"0.8km", "abc", "abc", "abc"};
    private String desc[] = {"fresh-made daily sandwiches, hot and prepared food, dairy products, etc", "abc", "abc", "abc"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_page);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(R.layout.actionbar);

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

              startActivity(i);
          }
        });
    }

    private ArrayList<StoreObject> getDataSet() {
        ArrayList results = new ArrayList<StoreObject>();
        for (int i = 0; i < name.length; i++) {
            results.add(new StoreObject(imageId[i], name[i], loc[i], dis[i], desc[i]));
        }

        return results;
    }

}
