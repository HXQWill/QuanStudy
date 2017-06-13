package com.example.quan.quanstudy.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.quan.quanstudy.R;
import com.example.quan.util.Utils;

/**
 * Created by xingquan.he on 2017/3/16.
 * Mr.Quan
 */

public class FloatingActionBarActivity extends AppCompatActivity {

    private FloatingActionButton mFabBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_floatingactionbar);
        mFabBtn = (FloatingActionButton) findViewById(R.id.btn_fab_design);
        mFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.isFastClick();
                Snackbar.make(v,"权兴权意，品质为真",Snackbar.LENGTH_SHORT)
                        .setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Utils.isFastClick();
                                Toast.makeText(FloatingActionBarActivity.this,"Cancel-onClick.",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}
