package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class PutStep {

    @Given("^Here I am create or Update a resources of \"([^\"]*)\"$")
    public void hereIAmCreateOrUpdateAResourcesOf(String arg0) throws Throwable {
BddStyleMethod.PerformPutOperation();
    }
}
