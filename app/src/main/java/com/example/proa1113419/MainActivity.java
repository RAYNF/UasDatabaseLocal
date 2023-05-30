package com.example.proa1113419;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnentry,btntampil,btncetak,btnlaporan,btntentang,btnkeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnentry = findViewById(R.id.entry);
        btntampil=findViewById(R.id.tampil);
        btncetak=findViewById(R.id.cetak);
        btnlaporan=findViewById(R.id.laporan);
        btntentang=findViewById(R.id.tentang);
        btnkeluar=findViewById(R.id.keluar);

        btnentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,entry_data.class);
                startActivity(intent);
            }
        });
        btntampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BacaSqlite.class);
                startActivity(intent);
            }
        });
        btntentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Tentang.class);
                startActivity(intent);

            }
        });
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        btnlaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UpdateMatakuliah.class);
                startActivity(intent);
            }
        });


    }
}