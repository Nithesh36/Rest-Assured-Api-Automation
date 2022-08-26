import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class GherkinPost {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//post method using gherkins 
	  	RestAssured.baseURI = "http://localhost:3000/";
		String path="/employees";
		JSONObject requestParams = new JSONObject();
		requestParams.put("id",31);
		requestParams.put("first_name", "lavan");
		requestParams.put("last_name", "Krishnan");
		requestParams.put("email", "lavan@tcs.com");
			
//		String createUser = RestAssured.given()
//	                
//	                .accept(ContentType.JSON)
//	                .contentType(ContentType.JSON)
//	                .body(requestParams.toJSONString())
//	                .post(path).andReturn().asPrettyString();
		Response createUser = RestAssured.given()
                
                
                .contentType(ContentType.JSON)
                .body(requestParams.toJSONString())
                .post(path);

		 System.out.println("res "+createUser.body().jsonPath().getString("email"));
	}

}
