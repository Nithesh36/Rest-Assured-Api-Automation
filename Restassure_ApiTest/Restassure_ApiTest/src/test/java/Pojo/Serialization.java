package Pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertEquals;


public class Serialization {
    public static final ObjectMapper MAPPER=new ObjectMapper() ;
    public static void main(String[] a) throws JsonProcessingException {
        Example example = new Example();
        example.setId("5");
        example.setAuthor("Indu");
        example.setTitle("Front End ");

        String url="http://localhost:3000/posts";
        String json=MAPPER.writeValueAsString(example);
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .log()
                .all(true)
                .body(json)
                .post(url)
                .andReturn();
        assertEquals(response.getStatusCode(),201);
    }
    }


