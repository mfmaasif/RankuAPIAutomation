package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EventManagelmpl {

    @Step("Create new event for program")
    public void createNewEvent() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\EventCreate.json"));

        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .headers("content-Type","application/json")
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8"))
                .when()
                .log().all()
                .post(System.getenv("site")+"/sites/_stm/programs/event")
                .then()
                .statusCode(200);
    }

    @Step("Get details of an Event")
    public void getEventDetails(){

        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .pathParam("eventID", "1582445412191")
                .when()
                .get(System.getenv("site")+"/sites/_stm/programs/event/{eventID}")
                .then()
                .statusCode(200);
    }

    @Step("Update an Event")
    public void updateEvent() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\EventUpdate.json"));

        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .headers("content-Type","application/json")
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8"))
                .when()
//                .log().all()
                .put(System.getenv("site")+"/updateMultiple")
                .then()
                .statusCode(200);
    }

    @Step("Delete an Event")
    public void deleteEvent(){
        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .pathParam("eventID", "1596475246060")
                .when()
                .delete(System.getenv("site")+"/sites/_stm/programs/event/{eventID}")
                .then()
                .statusCode(200);
    }
}
