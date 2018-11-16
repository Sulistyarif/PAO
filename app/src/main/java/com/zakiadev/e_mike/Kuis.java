package com.zakiadev.e_mike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Kuis extends AppCompatActivity {
    String soal_jawab[][] =
            {{"Perubahan energi satu ke bentuk energi lain","Perubahan energi mekanik menjadi listrik"," energi matahari menjadi otot","Perubahan energi otot menjadi gerak","Yang di maksud dengan konversi energi adalah ..."},
            {"Motor pembakaran luar","Motor pembakaran dalam","Motor bakar","Motor diesel","Mesin yang memanfaatkan fluida kerja/gas panas hasil pembakaran, di mana antara medium yang memanfaatkan fluida kerjanya tidak dipisahkan oleh dinding pemisah adalah ..."},
            {"Motor 2 tak","Motor wankel","Motor bensin","Motor diesel","Motor yang memerlukan dua langkah torak dengan satu putaran poros engkol untuk menghasilkan tenaga disebut ..."},
            {"Motor 4 tak","Motor wankel","Motor bensin","Motor 2 tak","Motor yang memerlukan empat langkah piston dengan dua putran poros engkol untuk menghasilkan tenaga disebut ..."},
            {"Langkah buang","Langkah hisap","Langkah kompresi","Langkah usaha","Pada motor 4 tak, 4 silinder dengan FO: 1-3-4-2, saat silinder satu sedang langkah kompresi maka silinder tiga sedang langkah ..."},

            {"Kedua katup tertutup","Katup masuk terbuka","Katup buang terbuka","Poros engkol berputar 540 derajat","Yang termasuk langkah kompresi motor 4 tak adalah ..."},
            {"180","0","360","540","Pada motor 4 tak, akhir langkah kompresi poros engkol berputar sebanyak ... derajat"},
            {"Pena torak","Cincin torak","Batang torak","Bantalan torak","Komponen yang berfungsi menghubungkan torak dengan batang torak adalah ..."},
            {"Poros engkol","Poros nok","Pena torak","Silinder","Untuk merubah gerak bolak-balik torak menjadi gerak putar pada sumbu utama motor diperlukan ..."},
            {"Udara murni","Campuran udara - bahan bakar","Air","Bensin","Pada motor diesel, saat langkah hisap yang diisap adalah"},

            {"Karburator","Tangki","Turbocharger","Nozel","Bagian pokok sebuah motor bensin yang berfungsi mencampur bahan bakar dengan udara untuk keperluan pembakaran adalah"},
            {"Piston","Busi","Intake manifold","Exhaust manifold","Pada motor bensin, kepala silinder berfungsi sebagai tempat dudukan komponen berikut ini, kecuali ..."},
            {"Air filter","Oil filter","Water filter","Fuel filter","Yang berfungsi untuk menahan kotoran yang tercampur dalam udara untuk keperluan pembakaran adalah ..."},
            {"1 kg bensin diperlukan 12 kg udara","1 liter oli untuk 1 liter air","1 kg udara untuk 12 kg air","1 kg udara diperlukan 12 kg bensin","Campuran bahan bakar dan udara dengan perbandingan 1 : 12 artinya ..."},
            {"Cincin kompresi","Ruang engkol","Pena torak","Cincin pelumas","Komponen yang berfungsi untuk mencegah kebocoran antara dinding silinder dengan torak adalah ..."},

            {"Roda gila","Tekanan oli yang kental","Karburator","Poros engkol","Komponen mesin yang berfungsi untuk menyimpan tenaga selama motor tidak menghasilkan tenaga adalah ..."},
            {"Camshaft","Crank shaft","Connecting rod","Piston pin","Yang berfungsi untuk membuka katup-katup masuk dan buang yang digerakkan oleh timing pengapian melalui V-belt atau rantai yaitu ..."},
            {"Mempercepat pendinginan","Meredam getaran","Mencegah karat","Penahan panas","Fungsi sirip-sirip pada kepala silinder adalah ..."},
            {"Kepala silinder","Batang torak","Poros engkol","Blok silinder","Pengabut (injector) pada motor diesel dipasang pada ..."},
            {"Motor Sinkron","Motor shunt","Motor separately exited","motor self exited","Pada umumnya motor AC dibagi menjadi dua, salah satunya adalah ..."},

            {"Transistor","Generator","Dinamo","Trafo","Di bawah ini alat yang tidak menerapkan prinsip induksi elektromagnetik ..."},
            {"Generator","Akumulator","Transistor","Resistor","Alat yang dapat mengubah energi mekanik menjadi energi listrik disebut ..."},
            {"Altenator","Dinamo","Akumulator","Resistor","Generator yang menghasilkan arus AC biasa disebut dengan ..."},
            {"Generator 3-phase","Generator shunt","Generator compound","Generator penguat terpisah","Generator AC ditinjau dari sumbernya dibagi menjadi dua, salah satunya adalah ..."},
            {"Searah","Kuat","Bolak-balik","Lemah","Dinamo yang terpasang pada roda sepeda akan menghasilkan arus ..."}};

    private TextView hasil_jawab;
    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioButton d;
    private TextView soal;

    int Pertanyaan[] ={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
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
    private TextView[] jawaban_nilai = new TextView[25];
    private TableRow[] warna_hasil = new TableRow[25];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agung_kuis_activity);

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
        jawaban_nilai[15] = (TextView)findViewById(R.id.jawab16);
        jawaban_nilai[16] = (TextView)findViewById(R.id.jawab17);
        jawaban_nilai[17] = (TextView)findViewById(R.id.jawab18);
        jawaban_nilai[18] = (TextView)findViewById(R.id.jawab19);
        jawaban_nilai[19] = (TextView)findViewById(R.id.jawab20);
        jawaban_nilai[20] = (TextView)findViewById(R.id.jawab21);
        jawaban_nilai[21] = (TextView)findViewById(R.id.jawab22);
        jawaban_nilai[22] = (TextView)findViewById(R.id.jawab23);
        jawaban_nilai[23] = (TextView)findViewById(R.id.jawab24);
        jawaban_nilai[24] = (TextView)findViewById(R.id.jawab25);

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
        warna_hasil[15]=(TableRow)findViewById(R.id.warna_jawab16);
        warna_hasil[16]=(TableRow)findViewById(R.id.warna_jawab17);
        warna_hasil[17]=(TableRow)findViewById(R.id.warna_jawab18);
        warna_hasil[18]=(TableRow)findViewById(R.id.warna_jawab19);
        warna_hasil[19]=(TableRow)findViewById(R.id.warna_jawab20);
        warna_hasil[20]=(TableRow)findViewById(R.id.warna_jawab21);
        warna_hasil[21]=(TableRow)findViewById(R.id.warna_jawab22);
        warna_hasil[22]=(TableRow)findViewById(R.id.warna_jawab23);
        warna_hasil[23]=(TableRow)findViewById(R.id.warna_jawab24);
        warna_hasil[24]=(TableRow)findViewById(R.id.warna_jawab25);

        for(int a=0; a<Pertanyaan.length; a++){
            random = Math.random()*25;
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
                    hasil_acak==Pertanyaan[15] ||
                    hasil_acak==Pertanyaan[16] ||
                    hasil_acak==Pertanyaan[17] ||
                    hasil_acak==Pertanyaan[18] ||
                    hasil_acak==Pertanyaan[19] ||
                    hasil_acak==Pertanyaan[20] ||
                    hasil_acak==Pertanyaan[21] ||
                    hasil_acak==Pertanyaan[22] ||
                    hasil_acak==Pertanyaan[23] ||
                    hasil_acak==Pertanyaan[24] ||
                    hasil_acak==Pertanyaan[0]){

                random = Math.random()*25;
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
        hasil_acak_text_tampil.setText((indek_soal+1)+" / 25");
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
        if(soal_awal<25) {
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
            if(soal_awal<25) {
                kuis_tes(soal_awal);
            }
        }else {
            kerja_soal.setText("Cek hasil");
            soal_ganti.setVisibility(View.GONE);
            hasil_nilai.setVisibility(View.VISIBLE);
        }
    }
}