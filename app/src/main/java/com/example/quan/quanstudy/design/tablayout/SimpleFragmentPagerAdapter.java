package com.example.quan.quanstudy.design.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/17.
 * Mr.Quan
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String mTabTitles[] = new String[]{"TAB1", "TAB2", "TAB3"};
    private Context mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    public View getTabView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_design_tablayout_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.title_tv_design_tablayout_tab);
        tv.setText(mTabTitles[position]);
        //ImageView img = (ImageView) v.findViewById(R.id.img_iv_design_tablayout_tab);
        //img.setImageResource(imageResId[position]);
        return v;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}
