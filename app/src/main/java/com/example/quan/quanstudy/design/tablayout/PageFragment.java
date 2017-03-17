package com.example.quan.quanstudy.design.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/17.
 * Mr.Quan
 */

public class PageFragment extends Fragment {

    private int mPage;

    public static final String ARG_PAGE = "ARG_PAGE";

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_design_tablayout_fragment, container, false);
        TextView textView = (TextView) view;
        textView.setText("权兴权意-Fragment" + mPage);
        return view;
    }
}
