package com.zakiadev.e_mike;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity2 extends AppCompatActivity {

    TextView tvPertanyaan;
    int jumPertanyaan, skor;
    boolean isNull;
    LinearLayout llParent;
    RadioButton rbSelected;
    ImageView ivBack, ivHome, ivAnswer;

    String[] pertanyaan;
    String[] jawab1;
    String[] jawab2;
    String[] jawab3;
    String[] jawab4;
    String[] jawab5;
    String[] kunci;

    List<RadioGroup> listRg = new ArrayList<RadioGroup>();

    CustomDialogQuizResult dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_2);

        settingActionBar();

        init();

    }

    private void settingActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        getSupportActionBar().setCustomView(R.layout.custom_toolbar_home_quiz);
        View view = getSupportActionBar().getCustomView();

        ivBack = view.findViewById(R.id.ibBack);
        ivHome = view.findViewById(R.id.ibHome);
        ivAnswer = view.findViewById(R.id.ivCentang);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuizActivity2.this, MenuUtamaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

        ivAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dicek apakah ada soal yang belum terjawab
                if (isAnyNull()){
                    Toast.makeText(QuizActivity2.this, "Semua soal harus terjawab", Toast.LENGTH_SHORT).show();
                }else {
                    skor = 0;
                    isNull = true;
                    for (int i = 0; i < listRg.size(); i++){
                        int idSelected = listRg.get(i).getCheckedRadioButtonId();
                        rbSelected = (RadioButton)findViewById(idSelected);

                        int noSoal = i + 1;
                        if (rbSelected.getText().equals(kunci[i])){
                            skor++;
                        }
                    }

                    dialog = new CustomDialogQuizResult(QuizActivity2.this, skor);
                    dialog.show();
                }
            }
        });
    }

    private boolean isAnyNull() {
        boolean isAdaNomorKosong = false;
        for (int i = 0; i < listRg.size(); i++){
            if (listRg.get(i).getCheckedRadioButtonId() == -1){
                isAdaNomorKosong = true;
                break;
            }
        }
        return isAdaNomorKosong;
    }

    private void init() {

        llParent = (LinearLayout)findViewById(R.id.llQuiz);

        pertanyaan = getResources().getStringArray(R.array.quiz_soal);
        jawab1 = getResources().getStringArray(R.array.jwb1);
        jawab2 = getResources().getStringArray(R.array.jwb2);
        jawab3 = getResources().getStringArray(R.array.jwb3);
        jawab4 = getResources().getStringArray(R.array.jwb4);
        jawab5 = getResources().getStringArray(R.array.jwb5);
        kunci = getResources().getStringArray(R.array.kunci_quiz);

        jumPertanyaan = pertanyaan.length;

        buatPertanyaan(jumPertanyaan);
    }

    private void buatPertanyaan(int jumPertanyaan) {
        for (int i = 0; i < jumPertanyaan; i++){
            tvPertanyaan = new TextView(QuizActivity2.this);
            tvPertanyaan.setText(pertanyaan[i]);
            llParent.addView(tvPertanyaan);

            final RadioButton[] rb = new RadioButton[5];
            RadioGroup rg = new RadioGroup(this);
            rg.setOrientation(RadioGroup.VERTICAL);

            rb[0] = new RadioButton(this);
            rb[0].setText(jawab1[i]);
            rg.addView(rb[0]);

            rb[1] = new RadioButton(this);
            rb[1].setText(jawab2[i]);
            rg.addView(rb[1]);

            rb[2] = new RadioButton(this);
            rb[2].setText(jawab3[i]);
            rg.addView(rb[2]);

            rb[3] = new RadioButton(this);
            rb[3].setText(jawab4[i]);
            rg.addView(rb[3]);

            rb[4] = new RadioButton(this);
            rb[4].setText(jawab5[i]);
            rg.addView(rb[4]);

            listRg.add(rg);
            llParent.addView(rg);
        }
    }
}