package view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.quan.quanlibrary.R;
import com.example.quan.util.Utils;

/**
 * 4.0版本 Acitivity右上角更多组件
 *
 * Created by lpy on 2017/4/10.
 *
 * 使用方法：
 * 1. 在布局最下面 include : base_title_more_layout
 * 2. 调用BaseActivity initTitleMore()方法，初始化more
 * 3. 调用BaseActivity addTitleMoreItem()方法，添加 Item
 */

public class MoreWidget extends RelativeLayout implements AdapterView.OnItemClickListener {

    private Context mContext;
    private View mark_layout;
    private ListView item_list;
    private MoreWidgetAdapter adapter;

    public MoreWidget(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public MoreWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.more_widget_layout, this, true);
        mark_layout = findViewById(R.id.mark_layout);
        mark_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });
        item_list = (ListView) findViewById(R.id.item_list);
        adapter = new MoreWidgetAdapter(mContext);
        item_list.setAdapter(adapter);
        item_list.setOnItemClickListener(this);
        setVisibility(GONE);
    }

    public void removeAllItems(){
        adapter.clear();
    }

    public void addItem(int iconId, String content, ClickCallback clickCallback) {
        adapter.add(new MoreWidgetItem(iconId, content, clickCallback));
        adapter.notifyDataSetChanged();
    }

    public void addItem(String iconUrl, String content, ClickCallback clickCallback){
        adapter.add(new MoreWidgetItem(iconUrl, content, clickCallback));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (Utils.isFastClick()) {
            return;
        }
        MoreWidgetItem item = adapter.getItem(position);
        if (item != null && item.clickCallback != null) {
            hide();
            item.clickCallback.callback();
        }
    }

    private boolean isShow = false;

    public void show() {
        isShow = true;
        setVisibility(VISIBLE);
    }

    public void hide() {
        isShow = false;
        setVisibility(GONE);
    }

    public boolean isShow() {
        return isShow;
    }

    public interface ClickCallback {
        void callback();
    }

    class MoreWidgetItem {
        public int iconId;
        public String iconUrl;
        public String content;
        public ClickCallback clickCallback;

        public MoreWidgetItem(String iconUrl, String content, ClickCallback clickCallback) {
            this.iconId = -1;
            this.iconUrl = iconUrl;
            this.content = content;
            this.clickCallback = clickCallback;
        }

        public MoreWidgetItem(int iconId, String content, ClickCallback clickCallback) {
            this.iconId = iconId;
            this.content = content;
            this.clickCallback = clickCallback;
        }
    }


    class MoreWidgetAdapter extends ArrayAdapter<MoreWidgetItem> {

        private Context context;

        public MoreWidgetAdapter(Context context) {
            super(context, 0);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(context, R.layout.more_widget_item_layout, null);
            ImageView image = (ImageView) convertView.findViewById(R.id.item_iv);
            TextView text = (TextView) convertView.findViewById(R.id.text_tv);
            View upline = convertView.findViewById(R.id.line_up);
            View downline = convertView.findViewById(R.id.line_down);
            upline.setVisibility(View.GONE);
            downline.setVisibility(View.GONE);

            if (position < getCount()) {
                if (position == 0) {
                    upline.setVisibility(View.VISIBLE);
                }
                if (position == getCount() - 1) {
                    downline.setVisibility(View.VISIBLE);
                }


                MoreWidgetItem item = getItem(position);
                if (item.iconId > 0) {
                    image.setBackgroundResource(item.iconId);
                } else if(!TextUtils.isEmpty(item.iconUrl)){
//                    Sdk.image().displayImage(item.iconUrl, image);
                    //Quan TODO: 2017/5/27 url载因为涉及到Sdk.image()，这个可以单写一篇博客，本次不做，后期补上。
                }

                if (!TextUtils.isEmpty(item.content)) {
                    text.setText(item.content);
                }
            }
            return convertView;
        }
    }

}
