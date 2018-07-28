package com.zakiadev.e_mike;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialogQuizResult extends Dialog implements View.OnClickListener{

    Activity activity;
    Button btSelesai;
    TextView tvResult;
    int skor;

    public CustomDialogQuizResult(Activity activity, int skor) {
        super(activity);
        this.activity = activity;
        this.skor = skor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_result_quiz);
        tvResult = (TextView)findViewById(R.id.tvQuizResult);
        btSelesai = (Button)findViewById(R.id.btSelesai);

        tvResult.setText("Jawaban yang benar : " + skor);
        btSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
