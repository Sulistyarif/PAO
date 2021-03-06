package com.zakiadev.e_mike;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

public class GlossariumActivity extends AppCompatActivity {

    ExpandableListView listView;
    CustomExpandableListviewAdapter adapter;
    String[] listParent;
    String[] listChild;
    ImageView ivBack, ivHome;
    TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glossarium_activity);

        settingActionBar();

        init();

        listView.setAdapter(adapter);
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
                Intent i = new Intent(GlossariumActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                clickSound();
                startActivity(i);
            }
        });
        tvHeader.setText("Glossarium");
    }

    private void clickSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
    }

    private void init() {
        listParent = getResources().getStringArray(R.array.parent_glossarium);
        listChild = getResources().getStringArray(R.array.child_glossarium);

        listView = (ExpandableListView)findViewById(R.id.exLVGlossa);
        adapter = new CustomExpandableListviewAdapter(GlossariumActivity.this,listParent,listChild);

    }
}
