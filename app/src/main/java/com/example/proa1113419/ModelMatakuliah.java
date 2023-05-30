package com.example.proa1113419;

public class ModelMatakuliah {
    String kode;
    String nama_mtkl;
    String sks;
    String alamat;
    String kota;
    String predikat;



    public ModelMatakuliah(String kode, String nama_mtkl, String sks, String alamat, String kota, String predikat) {
        this.kode = kode;
        this.nama_mtkl = nama_mtkl;
        this.sks = sks;
        this.alamat = alamat;
        this.kota = kota;
       this.predikat= predikat;
    }
    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_mtkl() {
        return nama_mtkl;
    }

    public void setNama_mtkl(String nama_mtkl) {
        this.nama_mtkl = nama_mtkl;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getAlamat(){return alamat;}
    public void setAlamat(String alamat){this.alamat = alamat;}

    public String getKota(){return kota;}
    public void setKota(String kota){this.kota = kota;}

}
