package com.wiley.ranku.steps;


import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RFIStepImpl extends TestBase {

    Response response;
    RequestSpecification request;

    ArrayList<HashMap<String, String>> dataset;

    String rfiURL="https://ranku-api-dev.herokuapp.com/inquiry/submit";

    public void submitRFI(String testcaseID) {
        dataset = testData.getDataSet(testcaseID);
        System.out.println();

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseBody(d);

            request = RestAssured.given();
            request.headers(header);
            request.body(json.toJSONString());

            response = request.put(rfiURL);

            Assert.assertEquals(response.getStatusCode(), 200);

            System.out.println("Status : " + response.getStatusCode());
            System.out.println("ID : " + response.jsonPath().get("id"));
        }
    }

    @Step("Submit Requests for Information with country US <TC_RFI_01>")
    public void submitRFIwithUS(String testcaseID) {
        submitRFI(testcaseID);
    }

    @Step("Submit Requests for Information without country US <TC_RFI_02>")
    public void submitRFIwithoutUS(String testcaseID) {
        submitRFI(testcaseID);
    }

    @Step("Submit Requests for Information with SMS consent <TC_RFI_03>")
    public void submitRFIwithSMSconsent(String testcaseID) {
        submitRFI(testcaseID);
    }

    @Step("Submit Requests for Information without SMS consent <TC_RFI_04>")
    public void submitRFIwithoutSMSconsent(String testcaseID) {
        submitRFI(testcaseID);
    }

}
