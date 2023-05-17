package com.example.tugasuts_2003030002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HalamanHasil extends AppCompatActivity {

Button gnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_hasil);

        TextView textView = findViewById(R.id. textView);
        textView.setText("Berhasil");

        gnt = findViewById(R.id. btnganti);
        gnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gantioke();
            }
        });
    }

    public void gantioke() {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor edit = SP.edit();

        String gntpswd = ((EditText) findViewById(R.id. Tganti)).getText().toString();
        String repswd = ((EditText) findViewById(R.id. Reganti)).getText().toString();

        if (!gntpswd.equals(repswd)) {
            Toast.makeText(this.getBaseContext(),"Kedua Password tidak sama", Toast.LENGTH_LONG).show();
            return;
        }


        edit.putString("password", gntpswd);
        edit.commit();

        Toast.makeText(this.getBaseContext(), "Password Changed Successfully", Toast.LENGTH_SHORT).show();
        }
    }
