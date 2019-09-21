package com.zakiadev.e_mike;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BantuanActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ImageView ivBack, ivHome;
    TextView tvHeader;
    ImageView btKiri,btKanan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bantuan_activity);

        customActionBar();
        initWidget();
        configWidget();

    }

    private void customActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        getSupportActionBar().setCustomView(R.layout.custom_toolbar_home);
        View view = getSupportActionBar().getCustomView();

        ivBack = view.findViewById(R.id.ibBack);
        ivHome = view.findViewById(R.id.ibHome);
        tvHeader = view.findViewById(R.id.tvHeaderApp);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BantuanActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        tvHeader.setText("Bantuan");
    }

    private void configWidget() {
        btKanan = findViewById(R.id.ivNext);
        btKiri = findViewById(R.id.ivPrev);
        viewPagerAdapter = new ViewPagerAdapter(BantuanActivity.this);
        viewPager.setAdapter(viewPagerAdapter);

        btKanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

        btKiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousPage();
            }
        });
    }

    private void previousPage() {
        int currentPage = viewPager.getCurrentItem();
        int totalPages = viewPager.getAdapter().getCount();

        int previousPage = currentPage-1;
        if (previousPage < 0) {
            // We can't go back anymore.
            // Loop to the last page. If you don't want looping just
            // return here.
            previousPage = totalPages - 1;
        }

        viewPager.setCurrentItem(previousPage, true);

    }

    private void nextPage() {
        int currentPage = viewPager.getCurrentItem();
        int totalPages = viewPager.getAdapter().getCount();

        int nextPage = currentPage+1;
        if (nextPage >= totalPages) {
            // We can't go forward anymore.
            // Loop to the first page. If you don't want looping just
            // return here.
            nextPage = 0;
        }

        viewPager.setCurrentItem(nextPage, true);

    }

    private void initWidget() {
        viewPager = findViewById(R.id.vpBantuan);
    }
}
