package com.example.tugasuts_2003030002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id. btnmulai);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klikregis();}
        });
    }

    public void klikregis() {
        Intent klik = new Intent(this, HalamanLogin.class);
        startActivity(klik);
    }
}