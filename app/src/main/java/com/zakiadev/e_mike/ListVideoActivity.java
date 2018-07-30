package com.zakiadev.e_mike;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ListVideoActivity extends AppCompatActivity {

    ListView lvVideo;
    TextView tvHead;
    String[] listJudulVideo;
    String[] linkIconVideoYutub;
    String[] deskripsiVideo;
    String[] listLinkVideo;
    ListVideoAdapter listVideoAdapter;
    ImageView ibBack, ibHome;
    TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subbab_menu_activity);

        settingActionBar();

        init();

        lvVideo.setAdapter(listVideoAdapter);
        tvHead.setText("Pilih Video yang Akan Anda Putar");

        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(listLinkVideo[i])));
            }
        });

    }

    private void settingActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        getSupportActionBar().setCustomView(R.layout.custom_toolbar_home);
        View view = getSupportActionBar().getCustomView();

        ibBack = view.findViewById(R.id.ibBack);
        ibHome = view.findViewById(R.id.ibHome);
        tvHeader = view.findViewById(R.id.tvHeaderApp);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListVideoActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        tvHeader.setText("Video");
    }

    private void init() {
        lvVideo = (ListView)findViewById(R.id.lvsubbab);
        tvHead = (TextView)findViewById(R.id.tvHeadSubbab);

        listJudulVideo = getResources().getStringArray(R.array.judul_video);
        deskripsiVideo = getResources().getStringArray(R.array.deskripsi_video);
        linkIconVideoYutub = getResources().getStringArray(R.array.link_icon_video);
        listLinkVideo = getResources().getStringArray(R.array.link_video);

//        yang membedakan Activity ini dengan Activity menu subbab ada di VideoAdapternya..
        listVideoAdapter = new ListVideoAdapter(listJudulVideo, deskripsiVideo,linkIconVideoYutub,ListVideoActivity.this);
    }
}
