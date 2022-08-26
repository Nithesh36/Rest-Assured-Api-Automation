package assertionsTut;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.*;
public class HashMapvalidation {
	@Test
	public void assert1() {
	RestAssured.baseURI="https://reqres.in/";
	Response res=given().get("/api/users?page=2");
	
	LinkedHashMap<String, String>data=res.body().jsonPath().get("data[0]");
	System.out.println(data);
	//check if the key is exit or not
	res.then().assertThat().body("data[0]",hasKey("email"));
	//check if key has  expected value
	res.then().assertThat().body("data[0]",hasValue(7));
	//
	}
}
