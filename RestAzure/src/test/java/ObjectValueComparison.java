import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class ObjectValueComparison {

	@SuppressWarnings("unchecked")
	@Test
	
	public void objectFieldComparison() {
		RestAssured.baseURI="https://reqres.in/";
		Response res=given().get("/api/users?page=2");
		
		//res.then().assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
		//System.out.println("email is "+((res.jsonPath())).get("data.email"));	
		
		//or operation -any of
		// res.then().assertThat().body("data.email", anyOf(is("nk@gmail.cok"), is("janet.weaver@reqres.in")));

		//and operator 
//		allOf(not(isEmptyOrNullString()), equalTo(teamName))
		System.out.println("id array is ="+(res.jsonPath()).get("data.id"));
//		check array has  specified items
		res.then().assertThat().body("data.id", hasItems(7,8,9,10,11,12));
		
//		check  array  has atleast one items 
		res.then().assertThat().body("data.id", hasItem(10));
		//https://blog.darjan-dzamto.com/working-with-rest-assured-matchers/
		//https://www.vogella.com/tutorials/Hamcrest/article.html
		//body contains anything 
		//res.then().assertThat().body("data.id", anything());
		//check if the   field is empty  or not null
		//res.then().assertThat().body("data.id", allOf(is(notNullValue()),not(emptyString())));
		//check if the arrays has specified item   in any order
	//	res.then().assertThat().body("data.id", containsInAnyOrder(7,9,8,10,11,12));
	
//	 res.then().   assertThat().body("data.id",is(endsWithIgnoringCase("s")));
//and conditon  using simple method -it will  tell which place we are getting error 
		//int id=res.body().jsonPath().get("data[0].id");
		
	//	JsonPath email=res.body().jsonPath();
		//String emailid=email. get("data[0].email");
//		res.then().assertThat.body().(new Object[] {id,emailid},is(new Object[] {7,"michael.lawson@reqres.in"}));
	}
}
