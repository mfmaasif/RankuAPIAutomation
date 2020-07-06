package com.wiley.ranku;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.gauge.BeforeSuite;
import com.wiley.ranku.datamodel.TestData;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

public class TestBase {
    public Headers header;
    public JSONObject json;

    protected static TestData testData;


    @BeforeSuite
    public void initializeDriver() throws InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            testData = mapper.readValue(getClassLoader().getResourceAsStream(System.getenv("test")+".json"), TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHeaders(){
        Header h1 = new Header("Content-Type","application/json");
        Header h2 = new Header("x-api-key","102a4fec2007388288ae37c9882c3604");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);

        header = new Headers(list);
    }

    public void setResponseBody(HashMap<String, String> dataset){

        json=new JSONObject();

        for(HashMap.Entry<String, String> entry : dataset.entrySet()){
            //System.out.println("field: "+entry.getKey()+"    value: "+entry.getValue());
            json.put(entry.getKey(),entry.getValue());
        }
    }

    public void setResponseBodySignUp(HashMap<String, String> dataset){
        JSONObject object = new JSONObject();
        json=new JSONObject();

        for(HashMap.Entry<String, String> entry : dataset.entrySet()){
            //System.out.println("field: "+entry.getKey()+"    value: "+entry.getValue());
            object.put(entry.getKey(),entry.getValue());
        }

        json.put("userData",object);
        json.put("ip","::1");
    }

    public void setResponseBodyBookmark(HashMap<String, String> dataset){
        JSONObject object = new JSONObject();
        json=new JSONObject();

        for(HashMap.Entry<String, String> entry : dataset.entrySet()){
            object.put(entry.getKey(),entry.getValue());
        }

        json.put("data",object);

    }
}
