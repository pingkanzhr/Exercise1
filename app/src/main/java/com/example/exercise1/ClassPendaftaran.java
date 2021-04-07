package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class ClassPendaftaran extends AppCompatActivity {
    String agama = "";
    String Kelamin = "";
    Button btnBatal, btnDaftar;
    EditText Alamat, Email, Nama, Password, Repassword;
    TextInputLayout AlamatError, rEmailError, NamaError, PasswordError, RepassError;
    RadioButton rbBudha, rbHindu, rbIslam, rbKatolik, rbKepercayaan, rbKonghucu, rbKristen, rbLaki, rbPerempuan;
    RadioGroup rgAgama, rgAgama1, rgAgama2, rgsKelamin;
    private int CekAgama, CekKelamin;
    boolean EmailValid = false;
    boolean PassValid = false;
    boolean RePassValid = false;
    boolean AlamatValid = false;
    boolean NamaValid = false;
    private boolean Checking = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);
        Item();

        rgAgama.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int k) {
                if (k != -1 && ClassPendaftaran.this.Checking) {
                    ClassPendaftaran.this.Checking = false;
                    ClassPendaftaran.this.rgAgama1.clearCheck();
                    ClassPendaftaran.this.rgAgama2.clearCheck();
                    ClassPendaftaran.this.CekAgama = k;
                }
                ClassPendaftaran.this.Checking = true;
            }
        });
        rgAgama1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int k) {
                if (k != -1 && ClassPendaftaran.this.Checking) {
                    ClassPendaftaran.this.Checking = false;
                    ClassPendaftaran.this.rgAgama.clearCheck();
                    ClassPendaftaran.this.rgAgama2.clearCheck();
                    ClassPendaftaran.this.CekAgama = k;
                }
                ClassPendaftaran.this.Checking = true;
            }
        });
        rgAgama2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int k) {
                if (k != -1 && ClassPendaftaran.this.Checking) {
                    ClassPendaftaran.this.Checking = false;
                    ClassPendaftaran.this.rgAgama.clearCheck();
                    ClassPendaftaran.this.rgAgama1.clearCheck();
                    ClassPendaftaran.this.CekAgama = k;
                }
                ClassPendaftaran.this.Checking = true;
            }
        });
        this.rgsKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int k) {
                if (k != -1 && ClassPendaftaran.this.Checking) {
                    ClassPendaftaran.this.Checking = false;
                    ClassPendaftaran.this.CekKelamin = k;
                }
                ClassPendaftaran.this.Checking = true;
            }
        });
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClassPendaftaran.this.Agama(view);
                ClassPendaftaran.this.JenisKelamin(view);
                ClassPendaftaran.this.ValidasiData(view);
            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClassPendaftaran.this.startActivity(new Intent(ClassPendaftaran.this.getApplicationContext(), MainActivity.class));
            }
        });
    }
    public void Item() {

        Nama = (EditText) findViewById(R.id.idNama);
        Alamat = (EditText) findViewById(R.id.idalamat);
        Email = (EditText) findViewById(R.id.idEmail);
        Password = (EditText) findViewById(R.id.idPw);
        Repassword = (EditText) findViewById(R.id.idfRepw);
        rgsKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        rgAgama = (RadioGroup) findViewById(R.id.rg1);
        rgAgama1 = (RadioGroup) findViewById(R.id.rg2);
        rgAgama2 = (RadioGroup) findViewById(R.id.rg3);
        rbLaki = (RadioButton) findViewById(R.id.lk);
        rbPerempuan = (RadioButton) findViewById(R.id.pr);
        rbIslam = (RadioButton) findViewById(R.id.idAgamaI);
        rbKatolik = (RadioButton) findViewById(R.id.idAgamaKa);
        rbKristen = (RadioButton) findViewById(R.id.idAgamaK);
        rbKonghucu = (RadioButton) findViewById(R.id.idAgamaKH);
        rbHindu = (RadioButton) findViewById(R.id.idAgamaH);
        rbBudha = (RadioButton) findViewById(R.id.idAgamaB);
        rbKepercayaan = (RadioButton) findViewById(R.id.idKepercayaan);
        NamaError = (TextInputLayout) findViewById(R.id.NamaError);
        AlamatError = (TextInputLayout) findViewById(R.id.AlamatError);
        rEmailError = (TextInputLayout) findViewById(R.id.EmailError);
        PasswordError = (TextInputLayout) findViewById(R.id.PwError);
        RepassError = (TextInputLayout) findViewById(R.id.idRepwError);
        btnBatal = (Button) findViewById(R.id.buttnBatal);
        btnDaftar = (Button) findViewById(R.id.buttnDaftar);
    }

    private void Agama(View v) {
        int i = this.CekAgama;
        if (i == R.id.idAgamaI) {
            this.agama = "Islam";
        } else if (i == R.id.idAgamaKa) {
            this.agama = "Katolik";
        } else if (i == R.id.idAgamaK) {
            this.agama = "Kristen";
        } else if (i == R.id.idAgamaKH) {
            this.agama = "Konghucu";
        } else if (i == R.id.idAgamaH) {
            this.agama = "Hindu";
        } else if (i == R.id.idAgamaB) {
            this.agama = "Budha";
        } else if (i == R.id.idKepercayaan) {
            this.agama = "Aliran Kepercayaan";
        }
    }
    private void JenisKelamin(View v) {
        int i = this.CekKelamin;
        if (i == R.id.lk) {
            Kelamin = "Laki-Laki";
        } else if (i == R.id.pr) {
            Kelamin = "Perempuan";
        }
    }
    private void ValidasiData(View v) {
        if (this.Nama.getText().toString().isEmpty() || Alamat.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()
                || Repassword.getText().toString().isEmpty() || agama.isEmpty() || Kelamin.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_LONG).show();
        }
        if (Nama.getText().toString().isEmpty()) {
            NamaError.setError("Harap Isi");
            NamaValid = false;
        } else {
            NamaError.setErrorEnabled(false);
            NamaValid = true;
        }
        if (Alamat.getText().toString().isEmpty()) {
            AlamatError.setError("Alamat Tidak Boleh Kosong");
            AlamatValid = false;
        } else {
            AlamatError.setErrorEnabled(false);
            AlamatValid = true;
        }
        if (Email.getText().toString().isEmpty()) {
            rEmailError.setError("Harap Isi");
            EmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
            rEmailError.setError("Masukkan Email Valid");
            EmailValid = false;
        } else {
            EmailValid = true;
            rEmailError.setErrorEnabled(false);
        }
        if (Password.getText().toString().isEmpty()) {
            PasswordError.setError("HARAP ISI");
            PassValid = false;
        } else if (this.Password.getText().length() < 6) {
            PasswordError.setError("Panjang Pass Minimal 6 Karakter");
            PassValid = false;
        } else {
            PassValid = true;
            PasswordError.setErrorEnabled(false);
        }
        if (Repassword.getText().toString().isEmpty()) {
            RepassError.setError("RePass JANGAN KOSONG");
            RePassValid = false;
        } else if (Repassword.getText().length() < 6) {
            RepassError.setError("RePass Min 6 Karakter");
            RePassValid = false;
        } else if (!Repassword.getText().toString().equals(Password.getText().toString())) {
            RepassError.setError("Password Tidak Sama");
            RePassValid = false;
        } else {
            RePassValid = true;
            RepassError.setErrorEnabled(false);
        }
        if (NamaValid && AlamatValid && EmailValid && PassValid && RePassValid
                && !agama.isEmpty() && !Kelamin.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}