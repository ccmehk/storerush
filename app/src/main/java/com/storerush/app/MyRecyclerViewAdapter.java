package com.storerush.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/16/2016.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<StoreObject> mDataset;
    private static MyClickListener myClickListener;

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        ImageView mImage;
        TextView mName;
        TextView mLoc;
        TextView mDis;
        TextView mDesc;

        public ViewHolder(View v) {
            super(v);
            mImage = (ImageView) v.findViewById(R.id.imgView);
            mName = (TextView) v.findViewById(R.id.name);
            mLoc = (TextView) v.findViewById(R.id.location);
            mDis = (TextView) v.findViewById(R.id.distance);
            mDesc = (TextView) v.findViewById(R.id.description);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<StoreObject> myDataset) {
        this.mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImage.setImageResource(mDataset.get(position).getmImage());
        holder.mName.setText(mDataset.get(position).getmName());
        holder.mLoc.setText(mDataset.get(position).getmLoc());
        holder.mDis.setText(mDataset.get(position).getmDis());
        holder.mDesc.setText(mDataset.get(position).getmDesc());

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
