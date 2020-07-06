package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ProgramSearchlmpl {

    @Step("Search Program with <filtervalue> from <filterFeild>")
    public void verifyProgramSaecrhData(String filtervalue, String filterFeild) throws InterruptedException {
        Response response = getProgramListFromFields(filtervalue, filterFeild);
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        Assert.assertEquals("200", "200");
        response.jsonPath().getList("results").size();
        Thread.sleep(5000);
        System.out.println(response.jsonPath().getList("results").size());
//        Assert.assertEquals(response.jsonPath().getList("results").size(),19);
    }

    @Step("Search Program with study field <studyfield>, degree level <degreelevl> and keyword text <keywordtext>")
    public void verifyProgramSearchWithMultipleData(String studyfield, String degreelevl, String keywordtext) throws InterruptedException {
        Response response = getProgramListFromMultipleField(studyfield,degreelevl,keywordtext);
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        Assert.assertEquals("200", "200");
        response.jsonPath().getList("results").size();
        Thread.sleep(5000);
        System.out.println(response.jsonPath().getList("results").size());

    }


    public Response getProgramListFromFields(String filtervalue, String filterOption) {

        String fieldValue = null;
        String degreelevel = null;
        String keywordtext = null;

        switch (filterOption) {
            case "field":
                fieldValue = filtervalue;
                break;
            case "degree level":
                degreelevel = filtervalue;
                break;
            case "keyword text":
                keywordtext = filtervalue;
                break;
            default:
                break;
        }

        RequestSpecification request = RestAssured.given();
//        request.contentType("");
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("n", keywordtext)
                .queryParam("clientIp", "::1")
                .queryParam("socialProfile", "{}")
                .queryParam("skip", "0")
                .queryParam("select", "id name degree program_duration cost score school_id parameterized_string school_name courses proprietary")
                .queryParam("degree_level", degreelevel)
                .queryParam("fields", fieldValue)
                .queryParam("site", "stm");

        return request.get("http://ranku-api-dev.herokuapp.com/programs/search/1000");


    }


    public Response getProgramListFromMultipleField(String fieldValue, String degreelevel , String keywordtext){

        RequestSpecification request = RestAssured.given();
//        request.contentType("");
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("n", keywordtext)
                .queryParam("clientIp", "::1")
                .queryParam("socialProfile", "{}")
                .queryParam("skip", "0")
                .queryParam("select", "id name degree program_duration cost score school_id parameterized_string school_name courses proprietary")
                .queryParam("degree_level", degreelevel)
                .queryParam("fields", fieldValue)
                .queryParam("site", "stm");
        return request.get("http://ranku-api-dev.herokuapp.com/programs/search/1000");
    }

}
