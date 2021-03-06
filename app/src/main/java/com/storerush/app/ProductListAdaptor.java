package com.storerush.app;

/**
 * Created by PHS on 2016-04-16.
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductListAdaptor extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ProductListItem> listViewItemList = new ArrayList<ProductListItem>() ;

    // ListViewAdapter의 생성자
    public ProductListAdaptor() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.product_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.product_imamge) ;
        TextView nameTextView = (TextView) convertView.findViewById(R.id.product_name) ;
        TextView no_priceTextView = (TextView) convertView.findViewById(R.id.normal_price) ;
        TextView sa_priceTextView = (TextView) convertView.findViewById(R.id.saled_price) ;
        TextView expriyTextView = (TextView) convertView.findViewById(R.id.expiry_date) ;
        TextView quantityTextView = (TextView) convertView.findViewById(R.id.quantity) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ProductListItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getImage());
        nameTextView.setText(listViewItem.getName());
        no_priceTextView.setText(String.valueOf(listViewItem.getNormal_price()));
        sa_priceTextView.setText(String.valueOf(listViewItem.getSale_price()));
        expriyTextView.setText(String.valueOf(listViewItem.getEnd_time()));
        quantityTextView.setText(String.valueOf(listViewItem.getQuantity()));


        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable image, String name, int no_price, int sa_price, int end_time, int quantitiy) {
        ProductListItem item = new ProductListItem(image,name,no_price,sa_price,end_time,quantitiy);
        listViewItemList.add(item);
    }
    public void addItem(ProductListItem item) {
        listViewItemList.add(item);
    }

    public void removeAllItem(){
        listViewItemList.clear();
    }
}
