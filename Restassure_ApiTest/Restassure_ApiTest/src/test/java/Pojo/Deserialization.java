package Pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import java.lang.reflect.Type;
import java.util.List;

public class Deserialization {
    public static final ObjectMapper MAPPER=new ObjectMapper() ;
    public static void main(String[] a) throws JsonProcessingException {
        String url="http://localhost:3000/posts/5";
      Example e=  RestAssured.given().get(url).as(Example.class);
      System.out.println("Single value"+e.toString());
        String url1="http://localhost:3000/posts";
        Type type=new TypeReference<List<Example>>(){}.getType();
        List<Example> l=RestAssured.get(url1).as(type);
        System.out.println("List Of values "+l.toString());
}}
