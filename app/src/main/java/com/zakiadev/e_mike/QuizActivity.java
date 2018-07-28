package com.zakiadev.e_mike;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class QuizActivity extends AppCompatActivity {

    ListView lvQuiz;
    CustomListViewQuizAdapter adapter;

    String[] pertanyaan;
    String[] jawab1;
    String[] jawab2;
    String[] jawab3;
    String[] jawab4;
    String[] jawab5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        init();

        lvQuiz.setAdapter(adapter);

    }

    private void init() {
        lvQuiz = (ListView)findViewById(R.id.lvQuiz);

        pertanyaan = getResources().getStringArray(R.array.quiz_soal);
        jawab1 = getResources().getStringArray(R.array.jwb1);
        jawab2 = getResources().getStringArray(R.array.jwb2);
        jawab3 = getResources().getStringArray(R.array.jwb3);
        jawab4 = getResources().getStringArray(R.array.jwb4);
        jawab5 = getResources().getStringArray(R.array.jwb5);

        adapter = new CustomListViewQuizAdapter(pertanyaan, jawab1, jawab2, jawab3, jawab4, jawab5, QuizActivity.this);
    }
}
