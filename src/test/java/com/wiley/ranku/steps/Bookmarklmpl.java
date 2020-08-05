package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Bookmarklmpl extends TestBase {

    @Step("<action> Bookmark to program <programID> for a user in <site>")
    public void bookmarkPrograms(String action, String programID, String site) throws IOException {
//        String site = "msu";
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\BookmarkData.json"));
        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .headers("content-Type","application/json")
                .queryParam("site",site)
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8")
                .replace("{{action}}",action)
                .replace("{{programID}}",programID))
                .log().all()
                .when()
                .put(System.getenv("site")+"/bookmark")
                .then()
                .statusCode(200)
                .log().all();

    }
}
