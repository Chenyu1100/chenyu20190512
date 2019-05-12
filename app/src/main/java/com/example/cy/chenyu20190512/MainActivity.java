package com.example.cy.chenyu20190512;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cy.chenyu20190512.bean.ZhuceBean;
import com.example.cy.chenyu20190512.presenter.Presenter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity{

    private TextView aaa;
    private EditText name;
    private EditText pwd;
    private Button but;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aaa = (TextView) findViewById(R.id.aaa);
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        but = (Button) findViewById(R.id.but);
        presenter=new Presenter(this);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = name.getText().toString();
                String string1 = pwd.getText().toString();
                if (TextUtils.isEmpty(string)||TextUtils.isEmpty(string1)){
                    Toast.makeText(MainActivity.this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                  presenter.setzhuce(string,string1);
                }
            }
        });
    }

    public void getzhucheshow(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                ZhuceBean zhuceBean = gson.fromJson(data, ZhuceBean.class);
                String status = zhuceBean.getStatus();
                if (status.equals("0000")){
                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,Deng.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
