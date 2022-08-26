import java.util.LinkedHashMap;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response   response=httpRequest.queryParam("page", "4").get("/api/users");
//	    System.out.println("respons body "+response.body().asPrettyString());
//	    System.out.println("staus code "+response.getStatusCode());
//		System.out.println(response.body().asPrettyString());
		JsonPath jsonPathEvaluator = response.jsonPath();
//		String email = jsonPathEvaluator.get("data[0].email");
//		System.out.println("email id is "+email);
		LinkedHashMap<String, String>support=jsonPathEvaluator.get("support");
		System.out.println(support);
	//	System.out.println("json "+response.body().asString());
//		System.out.println(response.getStatusLine());
//		System.out.println("respons headers "+response.getHeaders());	
		//send request using Query params - it will appended with URl with ?  after that we will give key=value
//		Response   response=httpRequest.queryParam("page", "4").get("/api/users");
//	    System.out.println("respons body "+response.body().asPrettyString());
//	    System.out.println("staus code "+response.getStatusCode());
	}

}
