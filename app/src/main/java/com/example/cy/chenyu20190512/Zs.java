package com.example.cy.chenyu20190512;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cy.chenyu20190512.bean.User;
import com.example.cy.chenyu20190512.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class Zs extends AppCompatActivity {
    private ListView listView;
    private Presenter presenter=new Presenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zs);
        listView=findViewById(R.id.listview);
        presenter.setshow();
    }

    public void getshow(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                User user = gson.fromJson(data, User.class);
                List<User.ResultBean> list = user.getResult();
                MyAdapter myAdapter = new MyAdapter(Zs.this,list);
                listView.setAdapter(myAdapter);
            }
        });
    }
}
