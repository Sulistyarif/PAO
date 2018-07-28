package com.zakiadev.e_mike;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

public class GlossariumActivity extends AppCompatActivity {

    ExpandableListView listView;
    CustomExpandableListviewAdapter adapter;
    String[] listParent;
    String[] listChild;
    ImageView ivBack, ivHome;

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

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GlossariumActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }

    private void init() {
        listParent = getResources().getStringArray(R.array.parent_glossarium);
        listChild = getResources().getStringArray(R.array.child_glossarium);

        listView = (ExpandableListView)findViewById(R.id.exLVGlossa);
        adapter = new CustomExpandableListviewAdapter(GlossariumActivity.this,listParent,listChild);

    }
}
