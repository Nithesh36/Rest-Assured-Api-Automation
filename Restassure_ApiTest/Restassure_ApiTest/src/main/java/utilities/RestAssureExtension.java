package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssureExtension {


    public static RequestSpecification Request;
    public RestAssureExtension(){
        RequestSpecBuilder requestSpecification=new RequestSpecBuilder();
        requestSpecification.setBaseUri("http://localhost:3000");
        requestSpecification.setContentType(ContentType.JSON);
        var requestspec=requestSpecification.build();
        Request= RestAssured.given().spec(requestspec);
    }
    public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams) {
        //Act
        Request.pathParams(pathParams);
        try {
            Request.get(new
                    URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static ResponseOptions<Response> GetOps(String url) {
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> GetOpsWithToken(String url, String token) {
        //Act
        try {
            Request.header(new Header("Authorization", "Bearer " + token));
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ResponseOptions<Response> GetWithQueryParamsWithToken(String url,Map<String, String> pathParams, String token)  {
        Request.header(new Header("Authorization", "Bearer " + token));
        Request.queryParams(pathParams);
        return Request.get(url);
    }
}
