package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class ProgramEditorImpl extends TestBase {

    Response response;
    RequestSpecification request;

    ArrayList<HashMap<String, String>> dataset;

    public void programsetup(String testcaseID) {
        dataset = testData.getDataSet(testcaseID);


        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseBody(d);

            RestAssured.baseURI = "https://ranku-api-dev.herokuapp.com";

            given().
                    headers(header).
                    body(json.toJSONString()).
                    when().
                    post("/program").
                    then().
                    assertThat().statusCode(200);
        }
    }

    public void programupdate(String testcaseID) {
        dataset = testData.getDataSet(testcaseID);
        System.out.println();

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseProgram(d);

            RestAssured.baseURI = "https://ranku-api-dev.herokuapp.com";

            given().
                    headers(header).
                    body(json.toJSONString()).
                    when().
                    put("/updateMultiple").
                    then().
                    assertThat().statusCode(200);
        }
    }

    public void programpublish(String testcaseID) {
        dataset = testData.getDataSet(testcaseID);
        System.out.println();

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseProgram(d);

            RestAssured.baseURI = "https://ranku-api-dev.herokuapp.com";

            given().
                    headers(header).
                    body(json.toJSONString()).
                    when().
                    post("program/5f035d98b1aa0c000c77b6a8/publish").
                    then().
                    assertThat().statusCode(200);
        }
    }

    public void programunpublish(String testcaseID) {
        dataset = testData.getDataSet(testcaseID);
        System.out.println();

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseBody(d);

            RestAssured.baseURI = "https://ranku-api-dev.herokuapp.com";

            given().
                    headers(header).
                    body(json.toJSONString()).
                    when().
                    post("/program/11594056088717/unpublish").
                    then().
                    assertThat().statusCode(200);
        }
    }

    @Step("Add new Program <TC_PC_01>")
    public void createProgram(String testcaseID) {
        programsetup(testcaseID);
    }

    @Step("Update an existing Program <TC_PC_03>")
    public void updateProgram(String testcaseID) {
        programupdate(testcaseID);
    }

    @Step("Publish Program <TC_PC_04>")
    public void publishProgram(String testcaseID) {
        programpublish(testcaseID);
    }

    @Step("Unublish Program <TC_PC_05>")
    public void unpublishProgram(String testcaseID) {
        programunpublish(testcaseID);
    }

    @Step("Delete Program <TC_PC_05>")
    public void deleteProgram(String testcaseID) {
        dataset = testData.getDataSet(testcaseID);
        for (HashMap<String, String> d : dataset) {
            setHeaders();
            String id=d.get("id");
            System.out.println(id);
            RestAssured.baseURI = "https://ranku-api-dev.herokuapp.com";

            given().
                    headers(header).
                    when().
                    delete("/program/"+id).
                    then().
                    assertThat().statusCode(200);
        }
    }
}