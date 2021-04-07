package com.example.exercise1;

import android.app.DirectAction;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.NoCopySpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;
    String nama;

    public static String nomor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihatkontak);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("b");

        tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        switch (nama) {
            case "Renjun":
                tvnama.setText("Renjun");
                tvnomor.setText("123456");
                nomor = tvnomor.getText().toString();
                break;
            case "Jeno":
                tvnama.setText("Jeno");
                tvnomor.setText("276320");
                nomor = tvnomor.getText().toString();
                break;
            case "Jaemin":
                tvnama.setText("Jaemin");
                tvnomor.setText("093836");
                nomor = tvnomor.getText().toString();
                break;
            case "Chenle":
                tvnama.setText("Chenle");
                tvnomor.setText("999000");
                nomor = tvnomor.getText().toString();
                break;
            case "Jisung":
                tvnama.setText("Jisung");
                tvnomor.setText("364892");
                nomor = tvnomor.getText().toString();
                break;
            case "Haechan":
                tvnama.setText("Haechan");
                tvnomor.setText("111223");
                nomor = tvnomor.getText().toString();
                break;
            case "Mark":
                tvnama.setText("Mark");
                tvnomor.setText("888999");
                nomor = tvnomor.getText().toString();
                break;
            case "Juki":
                tvnama.setText("Juki");
                tvnomor.setText("009998");
                nomor = tvnomor.getText().toString();
                break;
            case "Jeki":
                tvnama.setText("Jeki");
                tvnomor.setText("222333");
                nomor = tvnomor.getText().toString();
                break;
            case "Sungsung":
                tvnama.setText("Sungsung");
                tvnomor.setText("888333");
                nomor = tvnomor.getText().toString();
                break;
        }
    }
}
