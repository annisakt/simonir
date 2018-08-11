package com.example.annis.apps.api;

/**
 * Created by annis on 04/05/2018.
 */

import java.util.List;

import com.example.annis.apps.Sungai;
import com.example.annis.apps.modal.DataSungai;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseApi {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sungai")
    @Expose
    private List<DataSungai> sungai = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataSungai> getSungai() {
        return sungai;
    }

    public void setSungai(List<DataSungai> sungai) {
        this.sungai = sungai;
    }

    //Rekap com.example.annis.apps.Monitoring
//    public class Example {
//
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("rekap")
//        @Expose
//        private List<Rekap> rekap = null;
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public List<Rekap> getRekap() {
//            return rekap;
//        }
//
//        public void setRekap(List<Rekap> rekap) {
//            this.rekap = rekap;
//        }
//
//    }
}