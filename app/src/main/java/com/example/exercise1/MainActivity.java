package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView Daftartv;
    EditText mail;
    EditText pwd;
    boolean mailValid;
    boolean pwdValid;
    TextInputLayout idEmailError, pwdError;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = (EditText) findViewById(R.id.idMail);
        pwd = (EditText) findViewById(R.id.idPw);
        Daftartv = (TextView) findViewById(R.id.tvDaftar);
        button = (Button) findViewById(R.id.idbtn);
        idEmailError = (TextInputLayout) findViewById(R.id.idmailErr);
        pwdError = (TextInputLayout) findViewById(R.id.idpwdErr);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.Validation();
            }
        });

        Daftartv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), ClassPendaftaran.class));
            }
        });
    }

    public void Validation() {

        if (mail.getText().toString().isEmpty()) {
            idEmailError.setError("Email Tidak Boleh Kosong");
            mailValid = false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches()) {
            idEmailError.setError("Masukkan Email Dengan Benar");
            mailValid = false;

        } else {
            mailValid = true;
            idEmailError.setErrorEnabled(false);
        }
        if (pwd.getText().toString().isEmpty()) {
            pwdError.setError("Password Tidak Boleh Kosong");
            pwdValid = false;

        } else if (pwd.getText().length() < 5) {
            pwdError.setError("Panjang Password Minimal 5 Karakter");
            pwdValid = false;

        }else {
            pwdValid = true;
            pwdError.setErrorEnabled(false);

        }
        if (!mailValid || !pwdValid || !mail.getText().toString().equals("exercise1@gmail.com") ||
                !pwd.getText().toString().equals("12345")) {
            Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Login Sukses",Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), Home_Act.class));
    }
}