package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestData {

    @JsonProperty("TC_RFI_01")
    private ArrayList<HashMap<String,String>>  TC_RFI_01;

    @JsonProperty("TC_RFI_02")
    private ArrayList<HashMap<String,String>>  TC_RFI_02;

    @JsonProperty("TC_RFI_03")
    private ArrayList<HashMap<String,String>>  TC_RFI_03;

    @JsonProperty("TC_RFI_04")
    private ArrayList<HashMap<String,String>>  TC_RFI_04;

    @JsonProperty("TC_Login_01")
    private ArrayList<HashMap<String,String>>  TC_Login_01;

    @JsonProperty("TC_Login_02")
    private ArrayList<HashMap<String,String>>  TC_Login_02;

    @JsonProperty("TC_Login_03")
    private ArrayList<HashMap<String,String>>  TC_Login_03;

    @JsonProperty("TC_Login_04")
    private ArrayList<HashMap<String,String>>  TC_Login_04;

    @JsonProperty("TC_SignUp_01")
    private ArrayList<HashMap<String,String>>  TC_SignUp_01;

    @JsonProperty("TC_BookmarkAdd_01")
    private ArrayList<HashMap<String,String>>  TC_BookmarkAdd_01;

    @JsonProperty("TC_BookmarkRemove_01")
    private ArrayList<HashMap<String,String>>  TC_BookmarkRemove_01;

    @JsonProperty("TC_PC_01")
    private ArrayList<HashMap<String,String>>  TC_PC_01;

    @JsonProperty("TC_PC_02")
    private ArrayList<HashMap<String,String>>  TC_PC_02;

    @JsonProperty("TC_PC_03")
    private ArrayList<HashMap<String,String>>  TC_PC_03;

    @JsonProperty("TC_PC_04")
    private ArrayList<HashMap<String,String>>  TC_PC_04;

    @JsonProperty("TC_PC_05")
    private ArrayList<HashMap<String,String>>  TC_PC_05;

    @JsonProperty("TC_PC_06")
    private ArrayList<HashMap<String,String>>  TC_PC_06;

    ArrayList<HashMap<String,String>> data;

    public ArrayList<HashMap<String, String>> getDataSet(String id) {

        data = new ArrayList<HashMap<String, String>>();

        switch (id) {

            case "TC_RFI_01":
                data = TC_RFI_01;
                break;
            case "TC_RFI_02":
                data = TC_RFI_02;
                break;
            case "TC_RFI_03":
                data = TC_RFI_03;
                break;
            case "TC_RFI_04":
                data = TC_RFI_04;
                break;
            case "TC_Login_01":
                data = TC_Login_01;
                break;
            case "TC_Login_02":
                data = TC_Login_02;
                break;
            case "TC_Login_03":
                data = TC_Login_03;
                break;
            case "TC_Login_04":
                data = TC_Login_04;
                break;
            case "TC_SignUp_01":
                data = TC_SignUp_01;
                break;
            case "TC_BookmarkAdd_01":
                data = TC_BookmarkAdd_01;
                break;
            case "TC_BookmarkRemove_01":
                data = TC_BookmarkRemove_01;
                break;
            case "TC_PC_01":
                data = TC_PC_01;
                break;
            case "TC_PC_02":
                data = TC_PC_02;
                break;
            case "TC_PC_03":
                data = TC_PC_03;
                break;
            case "TC_PC_04":
                data = TC_PC_04;
                break;
            case "TC_PC_05":
                data = TC_PC_05;
                break;
            case "TC_PC_06":
                data = TC_PC_06;
                break;
        }
        return data;
    }


}