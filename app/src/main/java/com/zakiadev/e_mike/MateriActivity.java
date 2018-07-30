package com.zakiadev.e_mike;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class MateriActivity extends AppCompatActivity {

    WebView wvMateri;
    int idBab;
    ImageView ivBack, ivHome;
    TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_activity);

        settingActionBar();

        init();

        switch (idBab){
            case 0:{
                wvMateri.loadUrl("file:///android_asset/materi.html");
                break;
            }
        }


    }

    private void settingActionBar() {
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
                Intent i = new Intent(MateriActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        tvHeader.setText("Materi");
    }

    private void init() {
        wvMateri = (WebView)findViewById(R.id.wvMateri);

        wvMateri.getSettings().setJavaScriptEnabled(true);
        wvMateri.getSettings().setSupportZoom(false);
        wvMateri.getSettings().setDisplayZoomControls(false);
        wvMateri.getSettings().setBuiltInZoomControls(false);

        idBab = getIntent().getIntExtra("idBab",0);

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        finish();
    }
}
