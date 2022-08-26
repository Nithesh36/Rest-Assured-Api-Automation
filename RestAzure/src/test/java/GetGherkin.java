import java.util.ArrayList;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetGherkin {

	public static void main(String[] args) {
			RestAssured.baseURI = "http://localhost:3000/";
			String path="/employees";
			Response createUser = RestAssured.given(). 
            when() .get(path);
			//access elements when we have multiple elements
			ArrayList<String> emails=createUser.body().jsonPath().get("email");
			System.out.println("first way of handling res data "+emails.get(4));
			//second way of accessing elememts
			
			ArrayList<String >parseEmail=	RestAssured.given(). 
            when() .get(path).then().extract().path("email");
			System.out.println("res "+parseEmail.get(4));
			
			
			//validation part
			
			System.out.println("res "+RestAssured.given(). 
		            when() .get(path).then().assertThat().statusCode(200));
	}

}
