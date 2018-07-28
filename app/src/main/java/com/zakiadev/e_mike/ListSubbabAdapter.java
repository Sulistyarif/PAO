package com.zakiadev.e_mike;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListSubbabAdapter extends BaseAdapter {

    TextView tvSubbab;
    ImageView ivSubbab;
    String[] listSubbab;
    Activity activity;
    LayoutInflater inflater = null;

    public ListSubbabAdapter(String[] listSubbab, Activity activity) {
        super();
        this.listSubbab = listSubbab;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listSubbab.length;
    }

    @Override
    public Object getItem(int i) {
        return listSubbab[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (v == null){
            v = inflater.inflate(R.layout.custom_listview_item, null);
        }

        tvSubbab = (TextView)v.findViewById(R.id.tvSubbab);
        ivSubbab = (ImageView)v.findViewById(R.id.ivSubBab);

        tvSubbab.setText(listSubbab[i]);
        ivSubbab.setImageDrawable(activity.getResources().getDrawable(R.drawable.icon_read));

        tvSubbab.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tvSubbab.setSingleLine(true);
        tvSubbab.setMarqueeRepeatLimit(5);
        tvSubbab.setSelected(true);

        return v;
    }
}