package com.example.tugasuts_2003030002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HalamanLogin extends AppCompatActivity {
    EditText tnama;
    EditText tpswd;
    Button tmbl;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_login);

        tnama = findViewById(R.id. usrnm);
        tpswd = findViewById(R.id. pswd);
        tmbl = findViewById(R.id. btnlogin);
        tmbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logindisini(); }
        });

        Spinner bahasa = (Spinner) findViewById(R.id. spinnerbhs);
        String[] PilihanBahasa = {
                "Jawa" , "Indonesia" , "Inggris" };
        ArrayAdapter<String> arrayAdapterbahasa = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, PilihanBahasa );
        bahasa.setAdapter(arrayAdapterbahasa);
    }
    public void logindisini() {
        CheckBox ingat = findViewById(R.id. checkBox);

        String user, pswd;
        user = tnama.getText().toString();
        pswd = tpswd.getText().toString();

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String tnama = SP.getString("user", "admin");
        String tpswd = SP.getString("password", "admin");

        if (user.equals(tnama) && pswd.equals(tpswd)) {
            Intent login = new Intent(this, HalamanHasil.class);
            startActivity(login);
            mp = MediaPlayer.create(HalamanLogin.this, R.raw.tuturu_1);
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mp.start();
                }
            });
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                }
            });
        } else {
            Toast.makeText(this, "User atau Password salah", Toast.LENGTH_SHORT).show();
        }

    }
}