package com.example.listview_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] foodName;
    private TypedArray foodpic;
    private List<Map<String, Object>> listData;
    private MyAdapter adapter;
    private GridView gridViewData;
    private ImageView imageViewPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodName = getResources().getStringArray(R.array.food_name);
        foodpic = getResources().obtainTypedArray(R.array.food_picture);

        listData = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < foodName.length; i++) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("name", foodName[i]);
            data.put("picture", foodpic.getResourceId(i, 0));
            listData.add(data);
        }
        adapter = new MyAdapter(MainActivity.this,listData);

        gridViewData = (GridView) findViewById(R.id.GridView_id);
        gridViewData.setAdapter(adapter);
        
        imageViewPic = (ImageView) findViewById(R.id.imageView_pic);
        gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageViewPic.setImageResource(foodpic.getResourceId(position,0));
            }
        });
    }
}