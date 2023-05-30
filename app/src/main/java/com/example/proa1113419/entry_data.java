package com.example.proa1113419;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class entry_data extends AppCompatActivity {
    EditText ekode,enama,esks,ealamat,ekota,epredikat;
    Button btnsave,btnview;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data);
        dbh=new DatabaseHelper(this);
        ekode=findViewById(R.id.editkode);
        enama=findViewById(R.id.editnama);
        esks=findViewById(R.id.editsks);
        ealamat=findViewById(R.id.editalamat);
        ekota=findViewById(R.id.editKota);
        epredikat=findViewById(R.id.editpredikat);

        btnsave=findViewById(R.id.tombolsave);
        btnview=findViewById(R.id.tombolview);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xkode=ekode.getText().toString();
                String xnama=enama.getText().toString();
                String xsks=esks.getText().toString();
                String xalamat=ealamat.getText().toString();
                String xkota=ekota.getText().toString();
                String xpredikat=epredikat.getText().toString();

                boolean oke=dbh.input_matakuliah(xkode,xnama,xsks,xalamat,xkota,xpredikat);
                if (oke)
                {
                    Toast.makeText(entry_data.this, "Save Ok",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(entry_data.this,
                            "Save failur", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entry_data.this,BacaSqlite.class);
                startActivity(intent);
            }
        });
    }
}