package com.example.cy.chenyu20190512.presenter;

import com.example.cy.chenyu20190512.Deng;
import com.example.cy.chenyu20190512.MainActivity;
import com.example.cy.chenyu20190512.Zs;
import com.example.cy.chenyu20190512.model.IModel;
import com.example.cy.chenyu20190512.model.Model;

public class Presenter implements IPresenter{
    private String Urldata="http://172.17.8.100/small/user/v1/register";
    private String Urldata1="http://172.17.8.100/small/user/v1/login";
    private String Urldata3="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=卫衣&page=1&count=10";
    private final Model model;
    private Zs zs;
    private MainActivity mainActivity;
    private Deng deng;
    public Presenter(MainActivity mainActivity){
        this.mainActivity=mainActivity;
        model=new Model();
    }
    public Presenter(Deng deng){
        this.deng=deng;
        model=new Model();
    }
    public Presenter(Zs zs){
        this.zs=zs;
        model=new Model();
    }
    @Override
    public void setzhuce(String phone, String pwd) {
      model.getzhuce(Urldata, phone, pwd, new IModel.RegCallback() {
          @Override
          public void onSuccess(String data) {
              mainActivity.getzhucheshow(data);
          }
      });
    }

    @Override
    public void setdeng(String phone, String pwd) {
       model.getdenglu(Urldata1, phone, pwd, new IModel.DeCallback() {
           @Override
           public void onSuccess(String data) {
               deng.getdengshow(data);
           }
       });
    }

    @Override
    public void setshow() {
   model.getshow(Urldata3, new IModel.showCallback() {
       @Override
       public void onSuccess(String data) {
           zs.getshow(data);
       }
   });
    }
}
