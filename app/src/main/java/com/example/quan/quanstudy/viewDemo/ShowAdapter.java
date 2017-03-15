package com.example.quan.quanstudy.viewDemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quan.quanstudy.R;

import java.util.List;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 * ShowListView ShowAdapter
 */

public class ShowAdapter extends ArrayAdapter<String> {
     public ShowAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.show_listview_item, null);
        } else {
            view = convertView;
        }
        TextView textView = (TextView) view.findViewById(R.id.text_tv_item);
        textView.setText(getItem(position));
        return view;
    }
}
