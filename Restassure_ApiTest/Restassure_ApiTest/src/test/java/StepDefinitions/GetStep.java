package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssureExtension;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetStep {
    private  static ResponseOptions<Response> response;
    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
       // response=RestAssureExtension.GetOps(url);
    }

    @And("^I perform get opertaion for port number \"([^\"]*)\"$")
    public void iPerformGetOpertaionForPortNumber(String portnumber) throws Throwable {
        BddStyleMethod.SimpleGet(portnumber);
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
assertThat(response.getBody().jsonPath().get("author"),hasItem(arg0));
    }

    @Then("^I should see the author name$")
    public void iShouldSeeTheAuthorName() {
        BddStyleMethod.PerformContainsCollection();
    }

    @Then("^I should see verify get parameter$")
    public void iShouldSeeVerifyGetParameter() {
        BddStyleMethod.PerformPathParameter();
    }

    @Then("^I should see verify get Queryparameter$")
    public void iShouldSeeVerifyGetQueryparameter() {
        BddStyleMethod.PerformQueryParameter();
    }

    @Given("^Here I am Perform a PostRequest \"([^\"]*)\"$")
    public void hereIAmPerformAPostRequest(String arg0) throws Throwable {
        BddStyleMethod.PerformPOSTWithBodyParameter();
    }

}
