package com.zakiadev.e_mike;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class MateriActivity extends AppCompatActivity {

    WebView wvMateri;
    int idBab;
    String urlRecall = "";
    ImageView ivBack, ivHome;
    TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_activity);

        settingActionBar();

        init();

        if (idBab==99){
            wvMateri.loadUrl(urlRecall);
        }else {
            switch (idBab){
                case 10:{
                    wvMateri.loadUrl("file:///android_asset/materi1_0.html");
                    break;
                }
                case 11:{
                    wvMateri.loadUrl("file:///android_asset/materi1_1.html");
                    break;
                }
                case 12:{
                    wvMateri.loadUrl("file:///android_asset/materi1_2.html");
                    break;
                }
                case 20:{
                    wvMateri.loadUrl("file:///android_asset/materi2_0.html");
                    break;
                }
                case 21:{
                    wvMateri.loadUrl("file:///android_asset/materi2_1.html");
                    break;
                }
                case 22:{
                    wvMateri.loadUrl("file:///android_asset/materi2_2.html");
                    break;
                }
                case 23:{
                    wvMateri.loadUrl("file:///android_asset/materi2_3.html");
                    break;
                }
                case 30:{
                    wvMateri.loadUrl("file:///android_asset/materi3_0.html");
                    break;
                }
                case 31:{
                    wvMateri.loadUrl("file:///android_asset/materi3_1.html");
                    break;
                }
                case 40:{
                    wvMateri.loadUrl("file:///android_asset/materi4_0.html");
                    break;
                }
                case 41:{
                    wvMateri.loadUrl("file:///android_asset/materi4_1.html");
                    break;
                }
                case 42:{
                    wvMateri.loadUrl("file:///android_asset/materi4_2.html");
                    break;
                }
            }
        }


        wvMateri.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Intent intent = new Intent(MateriActivity.this, MateriActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
                return true;


            }
        });


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
                clickSound();
                finish();
            }
        });

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MateriActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                clickSound();
                startActivity(i);
            }
        });
        tvHeader.setText("Materi");
    }

    private void clickSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
    }

    private void init() {
        wvMateri = (WebView)findViewById(R.id.wvMateri);

        wvMateri.getSettings().setJavaScriptEnabled(true);
        wvMateri.getSettings().setSupportZoom(false);
        wvMateri.getSettings().setDisplayZoomControls(false);
        wvMateri.getSettings().setBuiltInZoomControls(false);

        idBab = getIntent().getIntExtra("idBab",99);
        urlRecall = getIntent().getStringExtra("url");

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        clickSound();
        finish();
    }
}
