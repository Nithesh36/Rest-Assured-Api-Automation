package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utilities.ExcelReader;
import utilities.JsonParserUtil;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateBlobReadJsonFileSteps  {

    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;
    private Response response;
//    private String baseURI;
//    private String basePath;
    Properties properties;
    String propertyPath;
    String uri;
    String pathvalue;
    String filepath;

   @Before
   public void setUp() throws IOException {
       System.out.println("---Scenario Starts here---");
//       baseURI="http://localhost:3000";
//       basePath="/posts/";

       String propertyPath=System.getProperty("user.dir")+"/src/test/java/Configuration/Config.properties";
     FileReader fileReader=new FileReader(propertyPath);
     properties=new Properties();
     properties.load(fileReader);
     uri= properties.getProperty("baseURI");
       pathvalue= properties.getProperty("basePath");
       filepath=properties.getProperty("filepath");

       setRequestSpecBuilder();
       setResponseSpecBuilder();
   }
   @After
   public void tearDown(){

       System.out.println("---Scenario Ends here---");
   }

   public  void setRequestSpecBuilder(){
       requestSpec=new RequestSpecBuilder().setBaseUri(uri)
               .setContentType(ContentType.JSON)
               .setAccept(ContentType.JSON).build();
   }
    public  void setResponseSpecBuilder(){
        responseSpec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
    }

    //Reading file
    //Restassure -include jsonfile in the body
    @Given("^I read a Json data file \"([^\"]*)\"$")
    public void iReadAJsonDataFile(String jsonFile) throws Throwable {
       JsonParserUtil jsonParserUtil=new JsonParserUtil();
      String json= jsonParserUtil.getJsonDataFile(jsonFile);
      //System.out.println("json is "+json);
   requestSpec=given().spec(requestSpec).body(json);
   //System.out.println(requestSpec +"Reqst is ");

    }

     //when & Post
    @When("^I post the Request$")
    public void iPostTheRequest() {

       response=  requestSpec.
               when().
               //.post(properties.getProperty("basePath"));
               post(pathvalue);
    }

    @Then("^the response status code should be \"([^\"]*)\"$")
    public void theResponseStatusCodeShouldBe(String string) throws Throwable {
        response.then().assertThat().statusCode(is(equalTo(HttpStatus.SC_CREATED)));
    }

    @And("^response \"([^\"]*)\" should include a \"([^\"]*)\"$")
    public void responseShouldIncludeA(String SheetName, String RowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData(filepath, SheetName);
        String path = testData.get(Integer.parseInt(RowNumber)).get("path");
        String expected = testData.get(Integer.parseInt(RowNumber)).get("expected");

        String actual=response.getBody().jsonPath().getString(path);
        System.out.println("Actual is "+actual);
        System.out.println("Expected is "+expected);
       assertThat(actual,is(equalTo(expected)));
    }

//csv read method
public static String getApiData(String path,int row,int col){
csvReader = new CSVReader(new FileReader(path));
String res="";
		try { 
			//store all the  data driven values
			Data= csvReader.readAll();
			res=Data.get(row)[col];
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
return res;
}

//csv reader

  @And("^response \"([^\"]*)\" should include a \"([^\"]*)\"$")
    public void responseShouldIncludeA(String SheetName, String path) throws IOException, InvalidFormatException {
   String title=  CreateBlobReadJsonFileSteps.getApiData(path,1,2);
// inga assertion paniko da
	
}

//    @And("^response \"([^\"]*)\" should include \"([^\"]*)\"$")
//    public void responseShouldInclude(String path, String expected) throws Throwable {
//         String actual=response.getBody().jsonPath().getString(path);
//        System.out.println("Actual is "+actual);
//        System.out.println("Expected is "+expected);
//       assertThat(actual,is(equalTo(expected)));
//
//
//    }
}
