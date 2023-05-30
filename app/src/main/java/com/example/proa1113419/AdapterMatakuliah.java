package com.example.proa1113419;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMatakuliah extends RecyclerView.Adapter<AdapterMatakuliah.myViewHolder> {
    Context context;
    ArrayList<ModelMatakuliah> matakuliahArrayList;

    public AdapterMatakuliah(Context context, ArrayList<ModelMatakuliah> matakuliahArrayList) {
        this.context = context;
        this.matakuliahArrayList = matakuliahArrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_tapilan_mtkl,parent,false);
         return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.ekode.setText(matakuliahArrayList.get(position).kode);
        holder.enama.setText(matakuliahArrayList.get(position).nama_mtkl);
        holder.esks.setText(matakuliahArrayList.get(position).sks);
        holder.ealamat.setText(matakuliahArrayList.get(position).alamat);
        holder.ekota.setText(matakuliahArrayList.get(position).kota);
        holder.epredikat.setText(matakuliahArrayList.get(position).predikat);
        holder.akurela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),UpdateMatakuliah.class);
                intent.putExtra("kodene",matakuliahArrayList.get(position).kode);
                intent.putExtra("namane",matakuliahArrayList.get(position).nama_mtkl);
                intent.putExtra("skse",matakuliahArrayList.get(position).sks);
                intent.putExtra("alamate",matakuliahArrayList.get(position).alamat);
                intent.putExtra("kotae",matakuliahArrayList.get(position).kota);
                intent.putExtra("predikat",matakuliahArrayList.get(position).predikat);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return matakuliahArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView ekode,enama,esks,ealamat,ekota,epredikat;
        RelativeLayout akurela;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ekode=itemView.findViewById(R.id.kodemtkl);
            enama=itemView.findViewById(R.id.namamtkl);
            esks=itemView.findViewById(R.id.sksmtkl);
            ealamat=itemView.findViewById(R.id.alamatmtkl);
            ekota=itemView.findViewById(R.id.kotamtkl);
            akurela = itemView.findViewById(R.id.rela01);
            epredikat=itemView.findViewById(R.id.predikatmtkl);
        }
    }
}
