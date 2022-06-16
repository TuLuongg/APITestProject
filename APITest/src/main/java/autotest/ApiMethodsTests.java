package autotest;

import org.json.simple.JSONObject;
import org.testng.Assert;
//import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class ApiMethodsTests {
 
  
    void getUserDetailsTest() {
        //The base URI to be used
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET, "2");
 
        //Checks the Status Code
        int statusCode = response.getStatusCode();
        
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
    
 
    void updateUserDetailsTest() {
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        RequestSpecification httpRequest = RestAssured.given();
 
        JSONObject updateData = new JSONObject();
        updateData.put("name", "Aarna");
 
        httpRequest.header("Content-Type", "application/json");
 
        httpRequest.body(updateData.toJSONString());
        Response response = httpRequest.request(Method.PUT, "4");
        int statusCode = response.getStatusCode();
        System.out.println(response.getStatusLine());
        Assert.assertEquals(statusCode, 200);
 
        JsonPath newData = response.jsonPath();
        String name = newData.get("name");
        Assert.assertEquals(name, "Aarna");
    }
}