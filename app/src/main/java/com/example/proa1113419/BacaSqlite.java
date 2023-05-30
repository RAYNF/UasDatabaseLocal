package com.example.proa1113419;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BacaSqlite extends AppCompatActivity {

    ArrayList<ModelMatakuliah> matakuliahArrayList=new ArrayList<>();
    RecyclerView recyclerViewmtkl;
    DatabaseHelper dbh;
    TextView sks,jumlahmatkul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_sqlite);
        sks=findViewById(R.id.editsks);
        jumlahmatkul=findViewById(R.id.editjumlahmatkul);


        recyclerViewmtkl=findViewById(R.id.recyclematakuliah);

        dbh=new DatabaseHelper(this);
        Cursor cursor=dbh.baca_data();

        cursor.moveToPrevious();
        while (cursor.moveToNext())
        {
            matakuliahArrayList.add(new ModelMatakuliah(cursor.getString(0),
                                                       cursor.getString(1),
                                                       cursor.getString(2),
                                                       cursor.getString(3),
                                                        cursor.getString(4),
                                                       cursor.getString(5)));

        }

        AdapterMatakuliah adapterMatakuliah=new AdapterMatakuliah(this,matakuliahArrayList);
        recyclerViewmtkl.setAdapter(adapterMatakuliah);
        recyclerViewmtkl.setLayoutManager(new LinearLayoutManager(this));
        sks.setText(dbh.totalsks());
        int jmlmatkul=Integer.parseInt(dbh.jumlahmatkul());
        jumlahmatkul.setText(Integer.toString(jmlmatkul));



    }
}