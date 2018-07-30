package com.zakiadev.e_mike;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuSubbabMateriActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvMenuSubbab;
    String[] listMenu;
    ListSubbabAdapter adapter;
    ImageView ivBack, ivHome;
    TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subbab_menu_activity);

        settingActionBar();

        init();

        lvMenuSubbab.setAdapter(adapter);

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
                Intent i = new Intent(MenuSubbabMateriActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        tvHeader.setText("Materi");
    }

    private void init() {
        lvMenuSubbab = (ListView)findViewById(R.id.lvsubbab);
        lvMenuSubbab.setOnItemClickListener(this);

        listMenu = getResources().getStringArray(R.array.subbab_materi);

        adapter = new ListSubbabAdapter(listMenu,MenuSubbabMateriActivity.this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
        intent.putExtra("idBab",i);
        startActivity(intent);
    }
}
