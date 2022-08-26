package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssureExtension;

public class Egsteps {
    public static ResponseOptions<Response> response;
    public static String token;
    @Given("^I perform authentication operation for \"([^\"]*)\" with body$")
    public void iPerformAuthenticationOperationForWithBody(String url) throws Throwable {
        response = RestAssureExtension.GetOpsWithToken(url, token);
    }

    @Given("^I perform a GET operation for \"([^\"]*)\"$")
    public void iPerformAGETOperationFor(String url) throws Throwable {
        response = RestAssureExtension
                .GetOpsWithToken(url, response.getBody()
                        .jsonPath()
                        .get("access_token"));
    }

    @Then("^I should see a author name as \"([^\"]*)\"$")
    public void iShouldSeeAAuthorNameAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
