package com.issamelasri.moneymanager.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.issamelasri.moneymanager.R;
import com.issamelasri.moneymanager.ui.pojo.PostModel;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PostModel> data;
    private int resources;

    public MyAdapter(Context c, int resources, ArrayList<PostModel> data) {
        this.context = c;
        this.data = data;
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public PostModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void addItem(PostModel postModel) {
        this.data.add(postModel);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resources, null, false);
        }
        TextView tv_date = view.findViewById(R.id.costum_date);
        TextView tv_amount = view.findViewById(R.id.tv_amount);
        TextView tv_type = view.findViewById(R.id.type_of);
        PostModel postModel = getItem(position);
        tv_date.setText(postModel.getDate());
        tv_amount.setText(postModel.getAmount() + "");
        tv_type.setText(postModel.getType());
        return view;
    }
}
