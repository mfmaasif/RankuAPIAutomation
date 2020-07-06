package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SignUPStepImpl extends TestBase {

    RequestSpecification request;
    Response response=null;

    ArrayList<HashMap<String, String>> dataset;
    ArrayList<Response> responses;
   HashMap<String, String> reponsedata;

    String loginURL="https://ranku-api-dev.herokuapp.com/v2/main/user";


    public void login(String testcaseID) {
        responses = new ArrayList<Response>();

        dataset = testData.getDataSet(testcaseID);

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseBody(d);

            request = RestAssured.given();
            request.headers(header);
            request.body(json.toJSONString());

            response = request.post(loginURL);

            responses.add(response);
        }
    }

    public void signUp(String testcaseID) {
        responses = new ArrayList<Response>();

        dataset = testData.getDataSet(testcaseID);

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseBodySignUp(d);

            request = RestAssured.given();
            request.headers(header);
            request.body(json.toJSONString());

            response = request.put(loginURL);

            responses.add(response);
        }
    }

    @Step("Create a new user account <TC_SignUp_01>")
    public void createAccount(String testcaseID) {
        signUp(testcaseID);
        for(Response r:responses){
            Assert.assertEquals(r.getStatusCode(),200);
            System.out.println(r.getStatusCode()+" : ");


        }
    }

    @Step("Login with a valid username and password <TC_Login_01>")
    public void validLogin(String testcaseID) {
        login(testcaseID);

        for(Response r:responses){
            Assert.assertEquals(r.getStatusCode(),200);
            System.out.println(r.getStatusCode()+" : ");
        }
    }

    @Step("Login with a valid username and a invalid password <TC_RFI_02>")
    public void invalidPassword(String testcaseID) {
        login(testcaseID);
        for(Response r:responses){
            Assert.assertEquals(r.getStatusCode(),403);
            Assert.assertEquals(r.jsonPath().get("error"), "Incorrect username or password");
            System.out.println(r.getStatusCode()+" : "+r.jsonPath().get("error"));
        }
    }

    @Step("Login with a invalid user name and valid password <TC_RFI_03>")
    public void invalidUsername(String testcaseID) {
        login(testcaseID);
        for(Response r:responses){
            Assert.assertEquals(r.getStatusCode(),403);
            Assert.assertEquals(r.jsonPath().get("error"), "Incorrect username or password");
            System.out.println(r.getStatusCode()+" : "+r.jsonPath().get("error"));

        }
    }

    @Step("Login with a invalid user name and invalid password <TC_Login_04>")
    public void invalidLogin(String testcaseID) {
        login(testcaseID);
        for(Response r:responses){
            Assert.assertEquals(r.getStatusCode(),403);
            Assert.assertEquals(r.jsonPath().get("error"), "Incorrect username or password");
            System.out.println(r.getStatusCode()+" : "+r.jsonPath().get("error"));
        }
    }
}
