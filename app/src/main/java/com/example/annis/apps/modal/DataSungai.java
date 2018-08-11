package com.example.annis.apps.modal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by annis on 04/05/2018.
 */

public class DataSungai {
    @SerializedName("id_sungai")
    @Expose
    private String idSungai;
    @SerializedName("nama_sungai")
    @Expose
    private String namaSungai;
    @SerializedName("lokasi_sungai")
    @Expose
    private String lokasiSungai;
    @SerializedName("panjang")
    @Expose
    private String panjang;
    @SerializedName("luas")
    @Expose
    private String luas;
    @SerializedName("hilir")
    @Expose
    private String hilir;
    @SerializedName("kemiringan")
    @Expose
    private String kemiringan;
    @SerializedName("pengelola")
    @Expose
    private String pengelola;
    @SerializedName("gambar")
    @Expose
    private String gambar;

    public String getIdSungai() {
        return idSungai;
    }

    public void setIdSungai(String idSungai) {
        this.idSungai = idSungai;
    }

    public String getNamaSungai() {
        return namaSungai;
    }

    public void setNamaSungai(String namaSungai) {
        this.namaSungai = namaSungai;
    }

    public String getLokasiSungai() {
        return lokasiSungai;
    }

    public void setLokasiSungai(String lokasiSungai) {
        this.lokasiSungai = lokasiSungai;
    }

    public String getPanjang() {
        return panjang;
    }

    public void setPanjang(String panjang) {
        this.panjang = panjang;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getHilir() {
        return hilir;
    }

    public void setHilir(String hilir) {
        this.hilir = hilir;
    }

    public String getKemiringan() {
        return kemiringan;
    }

    public void setKemiringan(String kemiringan) {
        this.kemiringan = kemiringan;
    }

    public String getPengelola() {
        return pengelola;
    }

    public void setPengelola(String pengelola) {
        this.pengelola = pengelola;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
