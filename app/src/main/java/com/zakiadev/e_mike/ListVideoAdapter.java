package com.zakiadev.e_mike;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ListVideoAdapter extends BaseAdapter {

    TextView tvJudulVideo, tvDeskripsiVideo;
    ImageView ivIconYutub;
    String[] listVideo;
    String[] linkIconYutub;
    String[] deskripsiVideo;
    Activity activity;
    LayoutInflater inflater = null;

    public ListVideoAdapter(String[] listVideo, String[] deskripsiVideo, String[] linkYutub, Activity activity) {
        super();
        this.listVideo= listVideo;
        this.deskripsiVideo = deskripsiVideo;
        this.linkIconYutub = linkYutub;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listVideo.length;
    }

    @Override
    public Object getItem(int i) {
        return listVideo[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (v == null){
            v = inflater.inflate(R.layout.custom_listview_item_menu_video, null);
        }

        tvJudulVideo = (TextView)v.findViewById(R.id.tvJudulVideo);
        tvDeskripsiVideo = (TextView)v.findViewById(R.id.tvDetail);
        ivIconYutub = (ImageView)v.findViewById(R.id.ivIconVideo);

        tvJudulVideo.setText(listVideo[i]);
        tvDeskripsiVideo.setText(deskripsiVideo[i]);
        Picasso.get().load(linkIconYutub[i]).resize(150,100).into(ivIconYutub);

        tvJudulVideo.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tvJudulVideo.setSingleLine(true);
        tvJudulVideo.setMarqueeRepeatLimit(5);
        tvJudulVideo.setSelected(true);

        return v;
    }
}