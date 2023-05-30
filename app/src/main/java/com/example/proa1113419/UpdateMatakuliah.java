package com.example.proa1113419;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateMatakuliah extends AppCompatActivity implements View.OnClickListener {
    EditText ekode,enama,esks,ealamat,ekota,epredikat;
    Button btnupdate,btndelete,btnview;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_matakuliah);

        dbh=new DatabaseHelper(this);

        ekode=findViewById(R.id.editkode);
        enama=findViewById(R.id.editnama);
        esks=findViewById(R.id.editsks);
        ealamat=findViewById(R.id.editalamat);
        ekota = findViewById(R.id.editKota);
        epredikat=findViewById(R.id.editpredikat);

        Bundle bundle=getIntent().getExtras();
        ekode.setText(bundle.getString("kodene"));
        enama.setText(bundle.getString("namane"));
        esks.setText(bundle.getString("skse"));
        ealamat.setText(bundle.getString("alamate"));
        ekota.setText(bundle.getString("kotae"));
        epredikat.setText(bundle.getString("predikat"));

        btnupdate = findViewById(R.id.tombolupdate);
        btndelete=findViewById(R.id.tomboldelete);
        btnview=findViewById(R.id.tombolview);

        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        btnview.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tombolupdate)
        {
            //update
            String xkode=ekode.getText().toString();
            String xnama=enama.getText().toString();
            String xsks=esks.getText().toString();
            String xalamat = ealamat.getText().toString();
            String xkota = ekota.getText().toString();
            String xpredikat=epredikat.getText().toString();

            dbh.ubah_data(xkode,xnama,xsks,xalamat,xkota,xpredikat);
        }else if(view.getId()==R.id.tomboldelete)
        {
            //delete
            String xkode=ekode.getText().toString();
            dbh.hapus_matakuliah(xkode);
        }
        else
        {
            //view
        }

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateMatakuliah.this,BacaSqlite.class);
                startActivity(intent);
            }
        });
    }
}