package com.zakiadev.e_mike;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialogConfirmExit extends Dialog{

    Activity activity;
    Button btYa, btTidak;

    public CustomDialogConfirmExit(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirm_on_exit);

        btYa = (Button)findViewById(R.id.btYa);
        btTidak = (Button)findViewById(R.id.btTidak);

        btYa.setText("Ya");
        btTidak.setText("Tidak");

        btYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        btTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
