package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManagelmpl {

    protected String uniqueSiteMail = null;
    protected String siteID = null;

    @Step("Get all users From Manage For <site>")
    public void getUsers(String site){
        String legacyName = null;
        if (site=="MSU"){
            legacyName= "_msu";
        }else if (site == "STM"){
            legacyName = "_stm";
        }else if (site=="SUNY"){
            legacyName = "_suny";
        }
        RequestSpecification request = RestAssured.given();
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("select","email%20first_name%20last_name%20title%20preferredRole%20active%20ip_list%20password")
                .queryParam("legacyName",legacyName);
        Response response = request.get(System.getenv("site")+"/v2/manage/user");
        Assert.assertEquals(200,response.statusCode());
    }

    @Step("Get available product in ranku manage for <site>")
    public void getManageProducts(String site){
        String siteTag=null;
        if (site=="MSU"){
            siteTag= "_msu";
        }else if (site == "STM"){
            siteTag = "_stm";
        }else if (site=="SUNY"){
            siteTag = "_suny";
        }
        RequestSpecification request = RestAssured.given();
        request.headers("x-api-key", "102a4fec2007388288ae37c9882c3604");
        request.queryParam("tag",siteTag);
        Response response = request.get(System.getenv("site")+"/v2/site");
        Assert.assertEquals(200,response.statusCode());
    }

    @Step("Get last 100 logs for <site>")
    public void getLogsForSite(String site){
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
        request.queryParam("limit",100)
                .queryParam("type","manage")
                .queryParam("prettyPrint",0)
                .pathParam("site",siteTag);
        Response response = request.get(System.getenv("site")+"/event/bySite/{site}");
        Assert.assertEquals(200,response.statusCode());
    }

    @Step("Get user Details of <site> Ranku manage")
    public void getUserDetails(String site){
        String userID = null;
        if (site.equals("MSU")){
            userID= "5f1e5e6abbfa1c000c4d02e1";
        }else if (site.equals("STM")){
            userID = "5f1e5f61077f5c000cee05fd";
        }else if (site.equals("SUNY")){
            userID = "5f1e602dbbfa1c000c4d02e5";
        }
        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .pathParam("userid", userID)
                .when()
                .get(System.getenv("site")+"/v2/manage/user/{userid}")
                .then()
                .statusCode(200);
    }

    @Step("Get ranku manage product details")
    public void getProductDetails(){
        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .pathParam("product", "program-editor")
                .pathParam("version","3")
                .when()
                .get("https://ranku-api-dev.herokuapp.com/v2/manage/product/{product}/{version}")
                .then()
                .statusCode(200);

    }

    @Step("Get all log for Ranku <site> manage user")
    public void getLogsForUser(String site){
        String userID = null;
        if (site.equals("MSU")){
            userID= "5f1e5e6abbfa1c000c4d02e1";
        }else if (site.equals("STM")){
            userID = "5f1e5f61077f5c000cee05fd";
        }else if (site.equals("SUNY")){
            userID = "5f1e602dbbfa1c000c4d02e5";
        }
        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .pathParam("userID", userID)
                .when()
                .get("https://ranku-api-dev.herokuapp.com/event/byUser/{userID}")
                .then()
                .statusCode(200);
    }

    @Step("Update User <userEditorRole> and <userManagerRole> From Ranku Manage for <site>")
    public void updateUser(String userEditorRole, String userManagerRole, String site) throws IOException {
        String userID = null;
        String userEmail = "APITestUser@test.com";
        String lastName = "user";
        String split[] = userEmail.split("@");

        switch (site){
        case "MSU":
            siteID = "0b71b2d9-b2ca-44b5-b439-ea6bab8d693d";
            userID = "5f1e5e6abbfa1c000c4d02e1";
            lastName = lastName +"MSU";
            userEmail = split[0]+"MSU@"+split[1];
            break;
            case "STM":
                siteID = "2916ff18-ebcc-41c7-a195-4f69bb2aad40";
                userID = "5f1e5f61077f5c000cee05fd";
                lastName = lastName +"STM";
                userEmail = split[0]+"STM@"+split[1];
                break;
            case "SUNY":
                siteID = "f505b2bf-72b8-46d3-b0a8-9c2a93877790";
                userID = "5f1e602dbbfa1c000c4d02e5";
                lastName = lastName +"SUNY";
                userEmail = split[0]+"SUNY@"+split[1];
                break;
            default:
                break;
        }

        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ManageUserUpdate.json"));

        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .headers("content-Type","application/json")
                .pathParam("user",userID)
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8")
                        .replace("{{manageUserID}}",userID)
                        .replace("{{lastName}}",lastName)
                        .replace("{{userEmail}}",userEmail)
                        .replace("{{siteID}}",siteID)
                        .replace("{{userEditorRole}}",userEditorRole)
                        .replace("{{userManagerRole}}",userManagerRole))
                .when()
//                .log().all()
                .put(System.getenv("site")+"/v2/manage/user/{user}")
                .then()
                .statusCode(200);

    }

    @Step("Create a new User in Ranku Manage for <site>")
    public void createNewUserInManage(String site) throws IOException {

        getmail(site);
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\NewManageUser.json"));

        RestAssured.given()
                .headers("x-api-key", "102a4fec2007388288ae37c9882c3604")
                .headers("content-Type","application/json")
//                .pathParam("user","5e7ae7a351de2b5c97d11485")
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8")
                        .replace("{{userEmail}}",uniqueSiteMail)
                        .replace("{{baseURL}}",System.getenv("site"))
                        .replace("{{siteID}}",siteID))
                .when()
                .log().all()
                .post(System.getenv("site")+"/v2/manage/user")
                .then()
                .statusCode(200);


    }

    @Step("test")
    public void generateNumberAndSave() throws FileNotFoundException {

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MMddhhmmss");
        String datetime = ft.format(dNow);
        String path=System.getProperty("user.dir")+"\\SiteUserEmail.txt";
        try{
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(datetime);
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        BufferedReader reader = new BufferedReader(new FileReader(path));

        try{
            String line;
            //as long as there are lines in the file, print them
            while((line = reader.readLine()) != null){
                String ID = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getmail(String site) throws FileNotFoundException {


        String email = "APITestUser@test.com";
        String spilt[];

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MMddhhmmss");
        String datetime = ft.format(dNow);

        switch (site){
            case "MSU":
                siteID = "0b71b2d9-b2ca-44b5-b439-ea6bab8d693d";
                spilt = email.split("@");
                uniqueSiteMail = spilt[0]+"MSU"+datetime+"@"+spilt[1];
                break;
            case "STM":
                siteID = "2916ff18-ebcc-41c7-a195-4f69bb2aad40";
                spilt = email.split("@");
                uniqueSiteMail = spilt[0]+"STM"+datetime+"@"+spilt[1];
            case "SUNY":
                siteID = "f505b2bf-72b8-46d3-b0a8-9c2a93877790";
                spilt = email.split("@");
                uniqueSiteMail = spilt[0]+"SUNY"+datetime+"@"+spilt[1];
            default:
                break;
        }
    }

}
