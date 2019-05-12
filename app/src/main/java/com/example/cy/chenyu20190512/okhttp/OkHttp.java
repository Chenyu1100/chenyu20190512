package com.example.cy.chenyu20190512.okhttp;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttp {
    public static void doPost(String url, String phone, String pwd, Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody build = new FormBody.Builder()
                .add("phone", phone)
                .add("pwd", pwd).build();
        Request request=new Request.Builder().url(url).post(build).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public static void doGet(String url,Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url)
                .method("GET",null).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
