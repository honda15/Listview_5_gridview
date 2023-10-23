package com.example.listview_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Map<String, Object>> myList;
    private final LayoutInflater layoutInflater;


    public MyAdapter(Context context, List<Map<String,Object>> data) {
        mContext = context;
        myList = data;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);  // Map形式的資料
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView;
        if (convertView==null){
            myView= layoutInflater.inflate(R.layout.item_layout,null);
            ImageView imageViewItemPic =  myView.findViewById(R.id.imageView_itemPic);
            TextView textViewItemName = myView.findViewById(R.id.textView_itenName);
            Map<String,Object> data = myList.get(position);
            imageViewItemPic.setImageResource((Integer) data.get("picture"));
            textViewItemName.setText(data.get("name").toString());
        }else {
            myView=convertView;
        }
        return myView;
    }
}
