package com.example.annis.apps.api;

import com.example.annis.apps.modal.DataMonitoring;
import com.example.annis.apps.modal.DataSungai;

/**
 * Created by annis on 07/05/2018.
 */

public class JsonList {
    private DataMonitoring[] monitoring;

    public DataMonitoring[] getMonitoring() {
        return monitoring;
    }
    private DataSungai[] sungai;

    public DataSungai[] getSungai() {
        return sungai;
    }
}
