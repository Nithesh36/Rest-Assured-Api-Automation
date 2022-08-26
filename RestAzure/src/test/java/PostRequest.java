import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		RestAssured.baseURI ="https://reqres.in/";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "8");
		requestParams.put( "first_name","nithesh");
		

		
		request.body(requestParams.toJSONString());
		Response response = request.patch("/api/users/8");

//		int statusCode = response.getStatusCode();
		System.out.println(response.getBody().asPrettyString());
		
		
		
//		Response res = 
//				given()
//					.header("Content-Type","application/json")
//					.body("{\n" + 
//							"    \"name\": \"Tarun Goswami1\",\n" + 
//							"    \"job\": \"QA\"\n" + 
//							"}")
//				.when()	
//					.patch("/users/2")
//				.then()
//					.statusCode(200)
//					.extract().response();
//		
//		System.out.println(res.body().prettyPrint());	
	}

}
