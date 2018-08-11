package com.example.annis.apps.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPengaduan {
    @SerializedName("id_pelapor")
    @Expose
    private String id_pelapor;
    @SerializedName("nama_pelapor")
    @Expose
    private String nama_pelapor;
    @SerializedName("no_hp")
    @Expose
    private String no_hp;
    @SerializedName("waktu")
    @Expose
    private String waktu;
    @SerializedName("nama_sungai")
    @Expose
    private String nama_sungai;
    @SerializedName("lokasi_sungai")
    @Expose
    private String lokasi_sungai;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("bukti")
    @Expose
    private String bukti;

    public String getId_pelapor() {
        return id_pelapor;
    }

    public void setId_pelapor(String id_pelapor) {
        this.id_pelapor = id_pelapor;
    }

    public String getNama_pelapor() {
        return nama_pelapor;
    }

    public void setNama_pelapor(String nama_pelapor) {
        this.nama_pelapor = nama_pelapor;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getNama_sungai() {
        return nama_sungai;
    }

    public void setNama_sungai(String nama_sungai) {
        this.nama_sungai = nama_sungai;
    }

    public String getLokasi_sungai() {
        return lokasi_sungai;
    }

    public void setLokasi_sungai(String lokasi_sungai) {
        this.lokasi_sungai = lokasi_sungai;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getBukti() {
        return bukti;
    }

    public void setBukti(String bukti) {
        this.bukti = bukti;
    }
}

