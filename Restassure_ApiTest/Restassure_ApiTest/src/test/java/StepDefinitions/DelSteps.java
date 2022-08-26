package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class DelSteps {
    @Given("^Here I am delete a fourth id of \"([^\"]*)\"$")
    public void hereIAmDeleteAFourthIdOf(String arg0) throws Throwable {
        BddStyleMethod.PerformDeleteOpertion();
    }

}
