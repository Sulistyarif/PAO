package com.zakiadev.e_mike;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Kuis extends AppCompatActivity {
    String soal_jawab[][] =
            {{"hands tools","power tools","special service tools","workshop equipment","Alat Bantu yang memudahkan pekerjaan manusia, dalam pengoprasiannya menggunakan tenaga manusia merupakan pengertian dari ..."},
            {"power tools","hands tools","special service tools","workshop equipment","Peralatan yang sumber tenaganya bukan dari tenaga manusia, tetapi tenaga menggunakan listrik atau tenaga pneumatis (gas) merupakan pengertian dari ..."},
            {"workshop equipment","special service tools","power tools","hands tools","Berbagai kelengkapan yg digunakan dibengkel yg merupakan perlengkapan penting namun bukan perlengkepan utama dalam perbaikan namun sebagi perlengkapan pendukung dalam perbaikan yaitu pengrtian dari ..."},
            {"special service tools","power tools","hands tools","workshop equipment","alat yang digunakan untuk pembongkaran maupun pemasangan komponen-komponen otomotif yang tidak dapat dilakukan dengan kunci-kunci biasa dan tidak dengan cara yg normal merupakan pengertian dari ..."},
            {"obeng, tang, kunci pas, kunci allen","kunci allen, kunci pas, tang, air drill","air drill, gear holder, impact wrench, obeng","bike lift, air drill, obeng, tang","yang merupakan jenis-jenis handstools yaitu ..."},

            {"valve adjuster, gear holder, torque wrench, crimping plier","kunci allen, kunci pas, tang, air drill","obeng, tang, kunci pas, kunci allen","bike lift, air drill, nipple spaner, valve adjuster","yang merupakan jenis-jenis special service tools yaitu ..."},
            {"bike lift, recoil hose, air gun, spring balancer","valve adjuster, gear holder, torque wrench, crimping plier","obeng, tang, kunci pas, kunci allen","bike lift, air drill, nipple spaner, valve adjuster","yang merupakan jenis-jenis workshop equipment yaitu ..."},
            {"electric drill, air drill, impact wrench, power grinder","obeng, tang, kunci pas, kunci allen","valve adjuster, gear holder, torque wrench, crimping plier","bike lift, recoil hose, air gun, spring balancer","yang merupakan jenis-jenis power tools yaitu ..."},
            {"bike lift","recoil hose","air gun","kunci pas","alat yang berfungsi mengangkat Sepeda Motor pada saat service adalah ..."},
            {"meja kerja","pyping system","bike lift","recoil hose","tempat kerja bangku dan penempatan dari mesin bor duduk, gerinda dan ragum ..."},

            {"pyping system","recoil hose","bike lift","meja kerja","alat yang berfungsi untuk Menyalurkan udara bertekanan dari kompresor ke masing-masing pit kerja ..."},
            {"menahan fly wheel dan rumah kopling ganda (OAPC)","Menahan fly wheel atau rumah kopling sekunder (OCC)","menahan pergerakan roda gigi rumah kopling (OCC) dan gigi primer/OAPC","Menahan OCC saat memasang dan melepas lock nut kopling","Fungsi SST Universal Holder yaitu ..."},
            {"Menahan fly wheel atau rumah kopling sekunder (OCC)","menahan fly wheel dan rumah kopling ganda (OAPC)","menahan pergerakan roda gigi rumah kopling (OCC) dan gigi primer/OAPC","Menahan OCC saat memasang dan melepas lock nut kopling","Fungsi SST Fly Wheel Holder yaitu ..."},
            {"menahan pergerakan roda gigi rumah kopling (OCC) dan gigi primer/OAPC","menahan fly wheel dan rumah kopling ganda (OAPC)","Menahan fly wheel atau rumah kopling sekunder (OCC)","Menahan OCC saat memasang dan melepas lock nut kopling","Fungsi SST Gear Holder yaitu ..."},
            {"melepas mur pengunci pada kopling","menahan fly wheel dan rumah kopling ganda (OAPC)","Menahan fly wheel atau rumah kopling sekunder (OCC)","Menahan OCC saat memasang dan melepas lock nut kopling","Fungsi SST Lock Nut Wrench yaitu ..."},

//            {"Roda gila","Tekanan oli yang kental","Karburator","Poros engkol","Komponen mesin yang berfungsi untuk menyimpan tenaga selama motor tidak menghasilkan tenaga adalah ..."},
//            {"Camshaft","Crank shaft","Connecting rod","Piston pin","Yang berfungsi untuk membuka katup-katup masuk dan buang yang digerakkan oleh timing pengapian melalui V-belt atau rantai yaitu ..."},
//            {"Mempercepat pendinginan","Meredam getaran","Mencegah karat","Penahan panas","Fungsi sirip-sirip pada kepala silinder adalah ..."},
//            {"Kepala silinder","Batang torak","Poros engkol","Blok silinder","Pengabut (injector) pada motor diesel dipasang pada ..."},
//            {"Motor Sinkron","Motor shunt","Motor separately exited","motor self exited","Pada umumnya motor AC dibagi menjadi dua, salah satunya adalah ..."},
//
//            {"Transistor","Generator","Dinamo","Trafo","Di bawah ini alat yang tidak menerapkan prinsip induksi elektromagnetik ..."},
//            {"Generator","Akumulator","Transistor","Resistor","Alat yang dapat mengubah energi mekanik menjadi energi listrik disebut ..."},
//            {"Altenator","Dinamo","Akumulator","Resistor","Generator yang menghasilkan arus AC biasa disebut dengan ..."},
//            {"Generator 3-phase","Generator shunt","Generator compound","Generator penguat terpisah","Generator AC ditinjau dari sumbernya dibagi menjadi dua, salah satunya adalah ..."},
//            {"Searah","Kuat","Bolak-balik","Lemah","Dinamo yang terpasang pada roda sepeda akan menghasilkan arus ..."}

            };

    private TextView hasil_jawab;
    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioButton d;
    private TextView soal;

    int Pertanyaan[] ={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
    String hasil_acak_text = "";
    private double random;
    private int hasil_acak;
    private TextView hasil_acak_text_tampil;

    int soal_awal = 0;
    private double random1;
    private int hasil_acak1;
    private int nilai = 0;
    private Button kerja_soal;
    private LinearLayout soal_ganti;
    private TableLayout hasil_nilai;
    private TextView[] jawaban_nilai = new TextView[15];
    private TableRow[] warna_hasil = new TableRow[15];

    ImageView ivBack, ivHome;
    TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agung_kuis_activity);

        settingActionBar();

        hasil_jawab = (TextView) findViewById(R.id.hasil_radio);
        a = (RadioButton) findViewById(R.id.a);
        b = (RadioButton) findViewById(R.id.b);
        c = (RadioButton) findViewById(R.id.c);
        d = (RadioButton) findViewById(R.id.d);

        soal = (TextView) findViewById(R.id.soal);
        hasil_acak_text_tampil = (TextView) findViewById(R.id.hasil_acak);

        kerja_soal = (Button) findViewById(R.id.kerja_soal);
        soal_ganti = (LinearLayout) findViewById(R.id.soal_ganti);
        hasil_nilai = (TableLayout) findViewById(R.id.hasil_nilai);

        jawaban_nilai[0] = (TextView)findViewById(R.id.jawab1);
        jawaban_nilai[1] = (TextView)findViewById(R.id.jawab2);
        jawaban_nilai[2] = (TextView)findViewById(R.id.jawab3);
        jawaban_nilai[3] = (TextView)findViewById(R.id.jawab4);
        jawaban_nilai[4] = (TextView)findViewById(R.id.jawab5);
        jawaban_nilai[5] = (TextView)findViewById(R.id.jawab6);
        jawaban_nilai[6] = (TextView)findViewById(R.id.jawab7);
        jawaban_nilai[7] = (TextView)findViewById(R.id.jawab8);
        jawaban_nilai[8] = (TextView)findViewById(R.id.jawab9);
        jawaban_nilai[9] = (TextView)findViewById(R.id.jawab10);
        jawaban_nilai[10] = (TextView)findViewById(R.id.jawab11);
        jawaban_nilai[11] = (TextView)findViewById(R.id.jawab12);
        jawaban_nilai[12] = (TextView)findViewById(R.id.jawab13);
        jawaban_nilai[13] = (TextView)findViewById(R.id.jawab14);
        jawaban_nilai[14] = (TextView)findViewById(R.id.jawab15);


        warna_hasil[0]=(TableRow)findViewById(R.id.warna_jawab1);
        warna_hasil[1]=(TableRow)findViewById(R.id.warna_jawab2);
        warna_hasil[2]=(TableRow)findViewById(R.id.warna_jawab3);
        warna_hasil[3]=(TableRow)findViewById(R.id.warna_jawab4);
        warna_hasil[4]=(TableRow)findViewById(R.id.warna_jawab5);
        warna_hasil[5]=(TableRow)findViewById(R.id.warna_jawab6);
        warna_hasil[6]=(TableRow)findViewById(R.id.warna_jawab7);
        warna_hasil[7]=(TableRow)findViewById(R.id.warna_jawab8);
        warna_hasil[8]=(TableRow)findViewById(R.id.warna_jawab9);
        warna_hasil[9]=(TableRow)findViewById(R.id.warna_jawab10);
        warna_hasil[10]=(TableRow)findViewById(R.id.warna_jawab11);
        warna_hasil[11]=(TableRow)findViewById(R.id.warna_jawab12);
        warna_hasil[12]=(TableRow)findViewById(R.id.warna_jawab13);
        warna_hasil[13]=(TableRow)findViewById(R.id.warna_jawab14);
        warna_hasil[14]=(TableRow)findViewById(R.id.warna_jawab15);


        for(int a=0; a<Pertanyaan.length; a++){
            random = Math.random()*15;
            hasil_acak = (int) random;
            while(hasil_acak==Pertanyaan[1] ||
                    hasil_acak==Pertanyaan[2] ||
                    hasil_acak==Pertanyaan[3] ||
                    hasil_acak==Pertanyaan[4] ||
                    hasil_acak==Pertanyaan[5] ||
                    hasil_acak==Pertanyaan[6] ||
                    hasil_acak==Pertanyaan[7] ||
                    hasil_acak==Pertanyaan[8] ||
                    hasil_acak==Pertanyaan[9] ||
                    hasil_acak==Pertanyaan[10] ||
                    hasil_acak==Pertanyaan[11] ||
                    hasil_acak==Pertanyaan[12] ||
                    hasil_acak==Pertanyaan[13] ||
                    hasil_acak==Pertanyaan[14] ||
                    hasil_acak==Pertanyaan[0]){

                random = Math.random()*15;
                hasil_acak = (int) random;
            }
            Pertanyaan[a] = hasil_acak;
            Log.d("test : ",hasil_acak+"");
            hasil_acak_text = hasil_acak_text+" , "+Pertanyaan[a];
        }
        hasil_acak_text_tampil.setText(hasil_acak_text);
        Log.d("test data",""+Pertanyaan[0]);
        kuis_tes(soal_awal);
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
                Intent i = new Intent(Kuis.this, MenuUtamaActivity.class);
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

    public void kuis_tes(int indek){
        int indek_soal = indek;
        Log.d("hasil soal"+indek_soal,soal_jawab[Pertanyaan[indek_soal]][4]);
        soal.setText(soal_jawab[Pertanyaan[indek_soal]][4]);

        int pilih_abcd[]={50,50,50,50};

        for(int a=0; a<=3; a++){
            random1 = Math.random()*4;
            hasil_acak1 = (int) random1;
            while(hasil_acak1==pilih_abcd[0] || hasil_acak1==pilih_abcd[1] || hasil_acak1==pilih_abcd[2] || hasil_acak1==pilih_abcd[3]){
                random1 = Math.random()*4;
                hasil_acak1 = (int) random1;
            }
            pilih_abcd[a] = hasil_acak1;
        }
        a.setChecked(false);
        b.setChecked(false);
        c.setChecked(false);
        d.setChecked(false);

        a.setText(soal_jawab[Pertanyaan[indek_soal]][pilih_abcd[0]]);
        b.setText(soal_jawab[Pertanyaan[indek_soal]][pilih_abcd[1]]);
        c.setText(soal_jawab[Pertanyaan[indek_soal]][pilih_abcd[2]]);
        d.setText(soal_jawab[Pertanyaan[indek_soal]][pilih_abcd[3]]);
        hasil_acak_text_tampil.setText((indek_soal+1)+" / 15");
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.a:
                if (checked)
                    hasil_jawab.setText(a.getText().toString().trim());
                break;
            case R.id.b:
                if (checked)
                    hasil_jawab.setText(b.getText().toString().trim());
                break;
            case R.id.c:
                if (checked)
                    hasil_jawab.setText(c.getText().toString().trim());
                break;
            case R.id.d:
                if (checked)
                    hasil_jawab.setText(d.getText().toString().trim());
                break;

        }
    }

    public void next_soal(View view){
        if(soal_awal<15) {
            if(hasil_jawab.getText().toString().trim().equalsIgnoreCase(soal_jawab[Pertanyaan[soal_awal]][0])){
                Toast.makeText(getBaseContext(),"Jawaban benar", Toast.LENGTH_SHORT).show();
                jawaban_nilai[soal_awal].setText("Benar");
                warna_hasil[soal_awal].setBackgroundResource(R.color.jawaban_benar);
                nilai++;
            }else{
                Toast.makeText(getBaseContext(),"Jawaban salah", Toast.LENGTH_SHORT).show();
                jawaban_nilai[soal_awal].setText("Salah");
                warna_hasil[soal_awal].setBackgroundResource(R.color.jawaban_salah);
                nilai=nilai;
            }
            if(soal_awal==24){
                hasil_acak_text_tampil.setText("Benar : "+nilai);
                soal_ganti.setVisibility(View.GONE);
                kerja_soal.setText("Cek hasil");
            }
            soal_awal++;
            if(soal_awal<15) {
                kuis_tes(soal_awal);
            }
        }else {
            kerja_soal.setText("Cek hasil");
            soal_ganti.setVisibility(View.GONE);
            hasil_nilai.setVisibility(View.VISIBLE);
        }
    }
}