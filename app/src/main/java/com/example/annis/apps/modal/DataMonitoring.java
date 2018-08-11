package com.example.annis.apps.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by annis on 04/05/2018.
 */

public class DataMonitoring {
    @SerializedName("id")
    @Expose
    private String idRekap;
    @SerializedName("nama_sungai")
    @Expose
    private String nama_sungai;
    @SerializedName("ketinggian")
    @Expose
    private String ketinggian;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("waktu")
    @Expose
    private String waktu;

    public String getIdRekap() {
        return idRekap;
    }

    public void setIdRekap(String idRekap) {
        this.idRekap = idRekap;
    }

    public String getNama_sungai() {
        return nama_sungai;
    }

    public void setNama_sungai(String nama_sungai) {
        this.nama_sungai = nama_sungai;
    }

    public String getKetinggian() {
        return ketinggian;
    }

    public void setKetinggian(String ketinggian) {
        this.ketinggian = ketinggian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

}
