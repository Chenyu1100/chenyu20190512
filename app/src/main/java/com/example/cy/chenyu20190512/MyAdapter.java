package com.example.cy.chenyu20190512;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cy.chenyu20190512.bean.User;

import java.util.List;

class MyAdapter extends BaseAdapter {
    private Context context;
    private List<User.ResultBean> list;

    public MyAdapter(Context context, List<User.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                ViewHolder holder;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.buju, null);
                    holder = new ViewHolder();
                    holder.name = convertView.findViewById(R.id.names);
                    holder.tp = convertView.findViewById(R.id.tp);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.name.setText(list.get(position).getCommodityName());
                Glide.with(context).load(list.get(position).getMasterPic()).into(holder.tp);
                break;
            case 1:
                ViewHolder1 holder1;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.buju1, null);
                    holder1 = new ViewHolder1();
                    holder1.bt = convertView.findViewById(R.id.bt);
                    holder1.ta = convertView.findViewById(R.id.ta);
                    convertView.setTag(holder1);
                } else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                holder1.bt.setText(list.get(position).getCommodityName());
                Glide.with(context).load(list.get(position).getMasterPic()).into(holder1.ta);
                break;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    class ViewHolder{
        TextView name;
        ImageView tp;
    }
    class ViewHolder1{
        TextView bt;
        ImageView ta;
    }
}
