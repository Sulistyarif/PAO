package com.zakiadev.e_mike;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class TentangSayaActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivBack, ivHome;
    CircleImageView ivFb, ivTwitter, ivWA, ivInsta;
    Button aboutDev;
    String fbURL = "https://www.facebook.com/kfsetyabudi";
    String fbPageID = "kfsetyabudi";
    String instaURL = "https://www.instagram.com/vebriano_/";
    TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tentang_activity);

        settingActionBar();

        init();

    }

    private void init() {
        ivFb = (CircleImageView)findViewById(R.id.ivFb);
        ivTwitter = (CircleImageView)findViewById(R.id.ivTwitter);
        ivWA = (CircleImageView)findViewById(R.id.ivWa);
        ivInsta = (CircleImageView)findViewById(R.id.ivInsta);
        aboutDev = (Button)findViewById(R.id.btDev);

        ivFb.setOnClickListener(this);
        ivTwitter.setOnClickListener(this);
        ivWA.setOnClickListener(this);
        ivInsta.setOnClickListener(this);
        aboutDev.setOnClickListener(this);
    }

    private void settingActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        getSupportActionBar().setCustomView(R.layout.custom_toolbar_home);
        View view = getSupportActionBar().getCustomView();

        ivBack = view.findViewById(R.id.ibBack);
        ivHome = view.findViewById(R.id.ibHome);
        tvHeader = view.findViewById(R.id.tvHeaderApp);

        ivBack.setOnClickListener(this);
        ivHome.setOnClickListener(this);
        tvHeader.setText("Tentang Saya");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:{
                clickSound();
                finish();
                break;
            }
            case R.id.ibHome:{
                Intent i = new Intent(TentangSayaActivity.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                clickSound();
                startActivity(i);
                break;
            }
            case R.id.ivFb:{
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFaceBookPageURL(this);
                facebookIntent.setData(Uri.parse(facebookUrl));
                clickSound();
                startActivity(facebookIntent);
                break;
            }
            case R.id.ivTwitter:{
                startTwitter(this);
                clickSound();
                break;
            }
            case R.id.ivWa:{
                Intent linkWa = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6285701150020/?text=Assalamualaikum+mas"));
                clickSound();
                startActivity(linkWa);
                break;
            }
            case R.id.ivInsta:{
                startInsta();
                clickSound();
                break;
            }
            case R.id.btDev:{
                Intent intent = new Intent(TentangSayaActivity.this, AboutDevActivity.class);
                clickSound();
                startActivity(intent);
                break;
            }
        }
    }

    private void clickSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
    }

    private void startInsta() {
        Intent intent;
        try{
            Uri uri = Uri.parse(instaURL);
            intent = new Intent(Intent.ACTION_VIEW, uri);

            intent.setPackage("com.instagram.android");
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instaURL));
            startActivity(intent);
        }
    }

    private void startTwitter(TentangSayaActivity tentangSayaActivity) {
        Intent intent = null;
        try{
            tentangSayaActivity.getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=vebriano_"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            return intent;
        } catch (PackageManager.NameNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/vebriano_"));
        }
        startActivity(intent);
    }

    private String getFaceBookPageURL(TentangSayaActivity tentangSayaActivity) {
        PackageManager packageManager = tentangSayaActivity.getPackageManager();
        try{
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850){
                return "fb://facewebmodal/f?href=" + fbURL;
            }else {
                return "fb://page/" + fbPageID;
            }
        }catch (PackageManager.NameNotFoundException e){
            return fbURL;
        }
    }
}
