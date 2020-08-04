package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RecruitmentDashboardlmpl {

    @Step("Get all active schools for <site>")
    public void getAllActiveSchools(String site){
        String siteTag=null;
        if (site.equals("MSU")){
            siteTag= "_msu";
        }else if (site.equals("STM")){
            siteTag = "_stm";
        }else if (site.equals("SUNY")){
            siteTag = "_suny";
        }
        RequestSpecification request = RestAssured.given();
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("select","id%20parameterized_name%20name%20media%20meta.urls")
                .queryParam("site",siteTag)
                .queryParam("clientIp","%3A%3Affff%3A10.0.2.2");
        Response response = request.get(System.getenv("site")+"/schools/active/0");
        Assert.assertEquals(200,response.statusCode());
    }

    @Step("Get RFI counts of <site> by Degree levels")
    public void getRFICountsWithDegreeLevel(String site){
        String siteTag=null;
        if (site.equals("MSU")){
            siteTag= "_msu";
        }else if (site.equals("STM")){
            siteTag = "_stm";
        }else if (site.equals("SUNY")){
            siteTag = "_suny";
        }
        RequestSpecification request = RestAssured.given();
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("ip","%3A%3Affff%3A10.0.2.2")
                .queryParam("site",siteTag)
                .queryParam("byDegreeLevel","true");
        Response response = request.get(System.getenv("site")+"/v2/main/degree/activeByProgram");
        Assert.assertEquals(200,response.statusCode());
    }

    @Step("Get RFI counts of <site> by Field Types")
    public void getRFICountsWithFieldTypes(String site){
        String siteTag=null;
        if (site.equals("MSU")){
            siteTag= "_msu";
        }else if (site.equals("STM")){
            siteTag = "_stm";
        }else if (site.equals("SUNY")){
            siteTag = "_suny";
        }
        RequestSpecification request = RestAssured.given();
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("ip","%3A%3Affff%3A10.0.2.2")
                .queryParam("site",siteTag);
        Response response = request.get(System.getenv("site")+"/v2/main/degree/activeByProgram");
        Assert.assertEquals(200,response.statusCode());
    }
}
