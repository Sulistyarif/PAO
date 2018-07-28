package com.zakiadev.e_mike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvbawah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvbawah = (TextView)findViewById(R.id.xx2);

        tvbawah.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tvbawah.setSingleLine(true);
        tvbawah.setMarqueeRepeatLimit(5);
        tvbawah.setSelected(true);

    }
}
