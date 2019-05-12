package com.example.cy.chenyu20190512;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cy.chenyu20190512.bean.DengBean;
import com.example.cy.chenyu20190512.presenter.Presenter;
import com.google.gson.Gson;

public class Deng extends AppCompatActivity{
    private EditText name;
    private EditText pwd;
    private Button but2;
    public Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng);
        name = (EditText) findViewById(R.id.name2);
        pwd = (EditText) findViewById(R.id.pwd2);
        but2 = (Button) findViewById(R.id.but2);
        presenter=new Presenter(this);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = name.getText().toString().trim();
                String string1 = pwd.getText().toString().trim();
                if (TextUtils.isEmpty(string)||TextUtils.isEmpty(string1)){
                    Toast.makeText(Deng.this,"账号密码不能为空",Toast.LENGTH_LONG).show();
                }else {
                    presenter.setdeng(string,string1);
                }
            }
        });

    }

    public void getdengshow(final String data) {
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
              Gson gson =new Gson();
              DengBean dengBean = gson.fromJson(data, DengBean.class);
              String status = dengBean.getStatus();
              if (status.equals("0000")){
                  Toast.makeText(Deng.this,"登录成功",Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(Deng.this, Zs.class);
                  startActivity(intent);
                  finish();
              }else {
                  Toast.makeText(Deng.this,"账号密码错误",Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
}
