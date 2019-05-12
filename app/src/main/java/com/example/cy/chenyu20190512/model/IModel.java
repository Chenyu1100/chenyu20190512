package com.example.cy.chenyu20190512.model;

public interface IModel {
    void getzhuce(String url,String phone,String pwd,RegCallback regCallback);
    interface RegCallback {
        void onSuccess(String data);
    }
    void getdenglu(String url,String phone,String pwd,DeCallback deCallback);
    interface DeCallback{
        void onSuccess(String data);
    }
    void getshow(String url,showCallback showCallback);
    interface showCallback{
        void onSuccess(String data);
    }
}
