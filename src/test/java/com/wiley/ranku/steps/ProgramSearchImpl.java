package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.BDDAssertions.then;

public class ProgramSearchImpl {

    //String searchprogramURL  = "https://ranku-api-dev.herokuapp.com/programs/search/1000?n=health&clientIp=%3A%3Affff%3A10.0.2.2&socialProfile=%7B%7D&skip=0&site=msu";

    String searchprogramURL  = "https://ranku-api-dev.herokuapp.com/programs/search/1000";

    String pram= "https://ranku-api-dev.herokuapp.com/programs/search/";

    public void findprogram(){

        Header h1 = new Header("Content-Type","application/json");
        Header h2 = new Header("x-api-key","102a4fec2007388288ae37c9882c3604");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);
        Headers header = new Headers(list);


        Response response = (Response) given()
                .headers(header)
                .param("n","health")
                .param("clientIp","%3A%3Affff%3A10.0.2.2")
                .param("socialProfile","%7B%7D")
                .param("skip",0)
                .param("site","msu")
                .get(searchprogramURL);


        System.out.println(response.getStatusCode());



    }

    @Step("Get Program search result")
    public void getProgramList(){

        given().
                get("https://ranku-api-dev.herokuapp.com/programs/search/1000?n=&clientIp=::1&socialProfile={}&skip=0&select=id name degree program_duration cost score school_id parameterized_string school_name courses proprietary&degree_level=certificate&fields=&site=indiana").
                then().statusCode(200);
//        Response response = RestAssured.get(pram + "/1000?n=&clientIp=::1&socialProfile={}&skip=0&select=id&name_degree_program_duration_cost_score_school_id_parameterized_string_school_name_courses_proprietary&degree_level=certificate&fields=&site=indiana");
//        System.out.println(response.toString());
//        int code = response.getStatusCode();
//        System.out.println(code);
    }
}
