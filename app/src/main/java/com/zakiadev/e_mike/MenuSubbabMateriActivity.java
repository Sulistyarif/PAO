package com.zakiadev.e_mike;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuSubbabMateriActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvMenuSubbab;
    String[] listMenu;
    int isComeBack;
    ListSubbabAdapter adapter;
    ImageView ivBack, ivHome;
    TextView tvHeader;
    Button btTestHide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subbab_menu_activity);

        isComeBack = getIntent().getIntExtra("comeBack",99);

        if (isComeBack == 99){
            listMenu = getResources().getStringArray(R.array.subbab_materi);
        }else if (isComeBack == 1){
            listMenu = getResources().getStringArray(R.array.subbab_materi1);
        }else if (isComeBack == 2){
            listMenu = getResources().getStringArray(R.array.subbab_materi2);
        }else if (isComeBack == 3){
            listMenu = getResources().getStringArray(R.array.subbab_materi3);
        }else if (isComeBack == 4){
            listMenu = getResources().getStringArray(R.array.subbab_materi4);
        }

        settingActionBar();

        init();

        lvMenuSubbab.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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
                Intent i = new Intent(MenuSubbabMateriActivity.this, MenuUtamaActivity.class);
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
        lvMenuSubbab = (ListView)findViewById(R.id.lvsubbab);

        lvMenuSubbab.setOnItemClickListener(this);

        adapter = new ListSubbabAdapter(listMenu,MenuSubbabMateriActivity.this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (isComeBack == 99 && i == 0){
            clickSound();
            kePetaKonsep();
        }else if (isComeBack == 99){
            clickSound();
            keMenuLain(i);
        }else {
            clickSound();
            keMateri(isComeBack, i);
        }
    }

    private void kePetaKonsep() {
        Intent intent = new Intent(MenuSubbabMateriActivity.this, PetaKonsepActivity.class);
        startActivity(intent);
    }

    private void keMateri(int isComeBack, int i) {
        if (isComeBack == 1 && i == 0){
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 10);
            startActivity(intent);
        }else if (isComeBack == 1 && i == 1){
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 11);
            startActivity(intent);
        }else if (isComeBack == 1 && i == 2) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 12);
            startActivity(intent);
        }else if (isComeBack == 2 && i == 0) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 20);
            startActivity(intent);
        }else if (isComeBack == 2 && i == 1) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 21);
            startActivity(intent);
        }else if (isComeBack == 2 && i == 2) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 22);
            startActivity(intent);
        }else if (isComeBack == 2 && i == 3) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 23);
            startActivity(intent);
        }else if (isComeBack == 3 && i == 0) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 30);
            startActivity(intent);
        }else if (isComeBack == 3 && i == 1) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 31);
            startActivity(intent);
        }else if (isComeBack == 4 && i == 0) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 40);
            startActivity(intent);
        }else if (isComeBack == 4 && i == 1) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 41);
            startActivity(intent);
        }else if (isComeBack == 4 && i == 2) {
            Intent intent = new Intent(MenuSubbabMateriActivity.this, MateriActivity.class);
            intent.putExtra("idBab", 42);
            startActivity(intent);
        }
    }

    private void keMenuLain(int noMenu) {
        Intent intent = new Intent(MenuSubbabMateriActivity.this, MenuSubbabMateriActivity.class);
        intent.putExtra("comeBack",noMenu--);
        startActivity(intent);
    }
}
