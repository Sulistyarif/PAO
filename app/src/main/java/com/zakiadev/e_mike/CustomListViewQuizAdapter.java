package com.zakiadev.e_mike;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class CustomListViewQuizAdapter extends BaseAdapter {

    String[] pertanyaan;
    String[] jawab1;
    String[] jawab2;
    String[] jawab3;
    String[] jawab4;
    String[] jawab5;
    Activity activity;
    LayoutInflater inflater = null;

    TextView tvPertanyaan;
    RadioButton rbJawab1, rbJawab2, rbJawab3, rbJawab4, rbJawab5;

    public CustomListViewQuizAdapter(String[] pertanyaan, String[] jawab1, String[] jawab2, String[] jawab3, String[] jawab4, String[] jawab5, Activity activity) {
        this.pertanyaan = pertanyaan;
        this.jawab1 = jawab1;
        this.jawab2 = jawab2;
        this.jawab3 = jawab3;
        this.jawab4 = jawab4;
        this.jawab5 = jawab5;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return pertanyaan.length;
    }

    @Override
    public Object getItem(int i) {
        return pertanyaan[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.custom_listview_quiz, null);
        }

        tvPertanyaan = (TextView)v.findViewById(R.id.tvPertanyaanQuiz);
        rbJawab1 = (RadioButton)v.findViewById(R.id.rbQuiz1);
        rbJawab2 = (RadioButton)v.findViewById(R.id.rbQuiz2);
        rbJawab3 = (RadioButton)v.findViewById(R.id.rbQuiz3);
        rbJawab4 = (RadioButton)v.findViewById(R.id.rbQuiz4);
        rbJawab5 = (RadioButton)v.findViewById(R.id.rbQuiz5);

        tvPertanyaan.setText(pertanyaan[i]);
        rbJawab1.setText(jawab1[i]);
        rbJawab2.setText(jawab2[i]);
        rbJawab3.setText(jawab3[i]);
        rbJawab4.setText(jawab4[i]);
        rbJawab5.setText(jawab5[i]);

        return v;
    }
}
