package com.gyj.recyclerview_demo2.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gyj.recyclerview_demo2.R;
import com.gyj.recyclerview_demo2.adapter.MyRecyclerViewAdapter;
import com.gyj.recyclerview_demo2.bean.Book;

import java.util.ArrayList;
import java.util.HashMap;

/**
* @class describe
* @anthor 郭彦君
* @time 2017/5/12 
*/
public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private ArrayList<Book> list = new ArrayList<>();
    private TextView quanbux;
    private TextView checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        checkbox = (TextView) findViewById(R.id.checkbox);
        quanbux = (TextView) findViewById(R.id.quanbux);
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("商品" + i);
            list.add(book);
        }
        adapter = new MyRecyclerViewAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
                for (int i = 0, p = list.size(); i < p; i++) {
                    map.put(i, true);
                }
                adapter.setMap(map);
            }
        });
        quanbux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
                for (int i = 0, p = list.size(); i < p; i++) {
                    map.put(i, false);
                }
                adapter.setMap(map);
            }
        });

    }


}
