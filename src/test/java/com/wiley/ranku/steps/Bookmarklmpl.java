package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;

public class Bookmarklmpl extends TestBase {

    RequestSpecification request;
    Response response;

    ArrayList<HashMap<String, String>> dataset;
    ArrayList<Response> responses;

    String bookmarkurl = "https://ranku-api-dev.herokuapp.com/bookmark?site=msu";

    public void bookmark(String testcaseID) {
        responses = new ArrayList<Response>();
        dataset = testData.getDataSet(testcaseID);

        for (HashMap<String, String> d : dataset) {
            setHeaders();
            setResponseBodyBookmark(d);

            request = RestAssured.given();
            request.headers(header);
            request.body(json.toJSONString());

            response = request.put(bookmarkurl);
           // System.out.println(bookmarkurl);

            responses.add(response);
        }
    }

    @Step("Bookmark a selected program <TC_BookmarkAdd_01>")
    public void bookmarkProgram(String testcaseID) {
        bookmark(testcaseID);
        for (Response r : responses) {
            // Assert.assertEquals(r.getStatusCode(),200);
            System.out.println(r.getStatusCode() + " : ");
        }
    }

    @Step("Remove bookmarked program <TC_BookmarkRemove_01>")
    public void removeBookmarkedProgram(String testcaseID) {
        bookmark(testcaseID);
        for (Response r : responses) {
            // Assert.assertEquals(r.getStatusCode(),200);
            System.out.println(r.getStatusCode() + " : ");
        }
    }
}
