package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.*;

import java.util.Scanner;
 
public class LoginTest {
 
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		baseURI = "https://auctions-app-2.herokuapp.com/api"; 
		RequestSpecification request = given();
		
		System.out.println("Input the name: ");
		String inputName = sc.nextLine();
		System.out.println("Input the job: ");
		String inputJob = sc.nextLine();
		
		JSONObject requestPrams = new JSONObject();
		requestPrams.put("email", inputName);
		requestPrams.put("password", inputJob);
	
		request.header("Content-Type", "application/json");
		request.body(requestPrams.toJSONString());

		Response response = request.post("/login");
		//System.out.println("Status request: " + response.getStatusLine());
		System.out.println("The content: " + response.prettyPrint());	    
	 }
}