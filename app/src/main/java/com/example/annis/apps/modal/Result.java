package com.example.annis.apps.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS on 2/23/2018.
 */

public class Result {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("value")
    private String value;


    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getValue(){return value;}


}
