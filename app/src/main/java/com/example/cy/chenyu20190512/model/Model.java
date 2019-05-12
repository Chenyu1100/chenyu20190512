package com.example.cy.chenyu20190512.model;

import com.example.cy.chenyu20190512.okhttp.OkHttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Model implements IModel{
    @Override
    public void getzhuce(String url, String phone, String pwd, final RegCallback regCallback) {
        OkHttp.doPost(url, phone, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
              regCallback.onSuccess(response.body().string());
            }
        });
    }
    @Override
    public void getdenglu(String url, String phone, String pwd, final DeCallback deCallback) {
          OkHttp.doPost(url, phone, pwd, new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
              }
              @Override
              public void onResponse(Call call, Response response) throws IOException {
                  deCallback.onSuccess(response.body().string());
              }
          });
    }
    @Override
    public void getshow(String url, final showCallback showCallback) {
        OkHttp.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
              showCallback.onSuccess(response.body().string());
            }
        });
    }
}
