package com.zakiadev.e_mike;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    String[] daftarMenu, deskripsiMenu;
    TextView tvMenu, tvDeskripsi;


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        daftarMenu = context.getResources().getStringArray(R.array.daftar_menu);
        deskripsiMenu = context.getResources().getStringArray(R.array.deskripsi_menu);

        View view = layoutInflater.inflate(R.layout.view_pager_item, null);
        tvMenu = view.findViewById(R.id.tvVPMenu);
        tvDeskripsi = view.findViewById(R.id.tvVPDeskripsiMenu);

        tvMenu.setText(daftarMenu[position]);
        tvDeskripsi.setText(deskripsiMenu[position]);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
