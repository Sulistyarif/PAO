package com.zakiadev.e_mike;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TentangMahasiswa extends Fragment {

    CircleImageView ivFb, ivTwitter, ivWA, ivInsta;
    Button aboutDev;
    String fbURL = "https://www.facebook.com/Radenmazvetteldiningratan";
    String fbPageID = "Radenmazvetteldiningratan";
    String instaURL = "https://www.instagram.com/mfadholi_/";

    public TentangMahasiswa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tentang_mahasiswa, container, false);

        ivFb = (CircleImageView)rootView.findViewById(R.id.ivFb);
        ivTwitter = (CircleImageView)rootView.findViewById(R.id.ivTwitter);
        ivWA = (CircleImageView)rootView.findViewById(R.id.ivWa);
        ivInsta = (CircleImageView)rootView.findViewById(R.id.ivInsta);

        ivFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFaceBookPageURL(getActivity());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });

        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTwitter(getActivity());
            }
        });

        ivWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkWa = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6285701058308/?text=Halo+mas"));
                startActivity(linkWa);
            }
        });

        ivInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInsta();
            }
        });

        return rootView;
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

    private void startTwitter(FragmentActivity activity) {
        Intent intent = null;
        try{
            activity.getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=jngkrk_genggong"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            return intent;
        } catch (PackageManager.NameNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/jngkrk_genggong"));
        }
        startActivity(intent);
    }

    private String getFaceBookPageURL(FragmentActivity activity) {
        PackageManager packageManager = activity.getPackageManager();
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
