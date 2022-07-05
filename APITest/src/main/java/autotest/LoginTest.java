package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testmain.Menu;

import org.json.simple.*;

import com.google.gson.Gson;

import java.util.Scanner;
 
public class LoginTest {
	public static String baseURL;
	private static ResponseSignUp Unittest(String email,String password){		
		baseURI = LoginTest.baseURL; 
		RequestSpecification request = given();

		
		JSONObject requestPrams = new JSONObject();
		requestPrams.put("email", email);
		requestPrams.put("password", password);
	
		request.header("Content-Type", "application/json");
		request.body(requestPrams.toJSONString());

		Response response = request.post("/login");
		System.out.println("Status request: " + response.getStatusLine());
		System.out.println("The content: " + response.prettyPrint());	    
		
		Gson g = new Gson(); 
        ResponseSignUp rp = g.fromJson(response.asString().toString(), ResponseSignUp.class);
		return rp;

	 }
	public static void Login1() {
		ResponseSignUp rp=Unittest("vdq@gmail.com","123");
		System.out.println("Login test 1: The email or password is incorrect:");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1002") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public static void Login2() {
		ResponseSignUp rp=Unittest("","123");
		System.out.println("Login test 2: The email is empty, the code shall be 1001:");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public static void Login3() {
		ResponseSignUp rp=Unittest("thanh12345@gmail.com","123456");
		System.out.println("Login test 3: The email and password are correct, the code shall be 1000:");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1000") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
private int codeResponse;
	private String messageResponse;
	private String dataResponse;
	public String creRequest(String... request) {
		JSONObject req = new JSONObject();
		req.put("email", request[0]);
		req.put("password", request[1]);
		return req.toString();
	}
	
	public void callAPI(String request) {
		baseURI = BaseURL.BASEURI;
		Response response = 
				given()
					.header("Content-Type", "application/json")
					.body(request)
				.when()
					.post("api/login");
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = Integer.parseInt(rep.get("code").toString());
		this.messageResponse = rep.get("message").toString();
		this.setDataResponse(rep.get("data").toString());
	}
	public String getDataResponse() {
		return dataResponse;
	}
	public void setDataResponse(String dataResponse) {
		this.dataResponse = dataResponse;
	}
}
