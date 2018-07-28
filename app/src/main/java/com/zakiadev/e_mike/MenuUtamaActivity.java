package com.zakiadev.e_mike;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MenuUtamaActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llmenu1, llmenu2, llmenu3, llmenu4, llmenu5, llmenu6;
    CustomDialogConfirmExit dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama_activity);
        initWidget();
//        requestPermissionDexter();
    }

    private void requestPermissionDexter() {
        Dexter.withActivity(MenuUtamaActivity.this)
                .withPermission(Manifest.permission.INTERNET)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                }).check();
    }

    private void initWidget() {
        llmenu1 = (LinearLayout)findViewById(R.id.llmenu1);
        llmenu2 = (LinearLayout)findViewById(R.id.llmenu2);
        llmenu3 = (LinearLayout)findViewById(R.id.llmenu3);
        llmenu4 = (LinearLayout)findViewById(R.id.llmenu4);
        llmenu5 = (LinearLayout)findViewById(R.id.llmenu5);
        llmenu6 = (LinearLayout)findViewById(R.id.llmenu6);


        llmenu1.setOnClickListener(this);
        llmenu2.setOnClickListener(this);
        llmenu3.setOnClickListener(this);
        llmenu4.setOnClickListener(this);
        llmenu5.setOnClickListener(this);
        llmenu6.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        dialog = new CustomDialogConfirmExit(MenuUtamaActivity.this);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.llmenu1:{
                startActivity(new Intent(MenuUtamaActivity.this, KIKDActivity.class));
                break;
            }
            case R.id.llmenu2:{
                startActivity(new Intent(MenuUtamaActivity.this, MenuSubbabMateriActivity.class));
                break;
            }
            case R.id.llmenu3:{
                startActivity(new Intent(MenuUtamaActivity.this, ListVideoActivity.class));
                break;
            }
            case R.id.llmenu4:{
                startActivity(new Intent(MenuUtamaActivity.this, QuizActivity2.class));
                break;
            }
            case R.id.llmenu5:{
                startActivity(new Intent(MenuUtamaActivity.this, GlossariumActivity.class));
                break;
            }
            case R.id.llmenu6:{
                startActivity(new Intent(MenuUtamaActivity.this, TentangSayaActivity.class));
                break;
            }
        }
    }
}
