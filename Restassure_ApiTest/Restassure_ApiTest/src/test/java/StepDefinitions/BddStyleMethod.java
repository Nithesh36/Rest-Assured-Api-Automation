package StepDefinitions;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;

public class
BddStyleMethod {
    public static void SimpleGet(String portnumber){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(String.format("http://localhost:3000/testlog.request=uri&headers&cookies&body/posts/%s",portnumber))
                . then()
                .body("author", is("Jaisurya"));
    }

    public static void PerformContainsCollection() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", containsInAnyOrder("Jaisurya", "Jai VS", null)).statusCode(200);
    }
    public static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON)
                .with()
                .pathParam("endpoint",1)
                .when().
                get("http://localhost:3000/posts/{endpoint}")
                .then()
                .body("author",containsString("Jaisurya"));
                }

    public static void PerformQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .with()
                .queryParam("id",2)
                .when().
                get("http://localhost:3000/posts/")
                .then()
                .body("author",hasItem("Jai VS"));

    }
    public static void PerformPOSTWithBodyParameter() {
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("id", "4");
        postContent.put("title", "Data Analyst");
        postContent.put("author", "AswinKumar");

        given()
                .contentType(ContentType.JSON).
                with()
                .body(postContent).
                when()
                .post("http://localhost:3000/posts").
                then()
                .body("author", Is.is("AswinKumar"));
    }

    public static void PerformDeleteOpertion(){

        // Delete Booking

        //GIVEN

                given()
                .baseUri("http://localhost:3000/posts/3");
//
//                // WHEN
//                .when()
//                .delete()
//                // THEN
//                .then()
//                .assertThat()
//                .statusCode(200);

        // Verifying booking is deleted
        // Given
        given()
                .baseUri("http://localhost:3000/posts/3")
                // When
                .when()
                .get()
                // Then
                .then()
                .statusCode(404);
    }
    public static void PerformPutOperation(){
        String jsonString = "{\n" +
                "      \"id\": 3,\n" +
                "      \"title\": \"SoftwareDeveloper\",\n" +
                "      \"author\": \"Pavithra\"\n" +
                "    }";

        //GIVEN
        given()
                .baseUri("http://localhost:3000/posts/3")

                .contentType(ContentType.JSON)
                .body(jsonString)
                // WHEN
                .when()
                .put()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("SoftwareDeveloper"))
                .body("author", Matchers.equalTo("Pavithra"));


    }
    public static void PerformPatchOperation(){
        String jsonString = "{\n" +
                "       \"id\": 3,\n" +
                "      \"title\": \"MobileTester\",\n" +
                "       \"author\": \"Pavithra\"\n" +
                "     \n" +
                "    }";

        //GIVEN
       given()
                .baseUri("http://localhost:3000/posts/3")
               .contentType(ContentType.JSON)
                .body(jsonString)
                // WHEN
                .when()
                .patch()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("MobileTester"))
                .body("author", Matchers.equalTo("Pavithra"));

    }
}






