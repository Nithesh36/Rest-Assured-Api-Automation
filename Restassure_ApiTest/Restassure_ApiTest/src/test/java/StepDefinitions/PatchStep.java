package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PatchStep {

    @Given("^Here I am Just Changing a few attributes \"([^\"]*)\"$")
    public void hereIAmJustChangingAFewAttributes(String arg0) throws Throwable {
       BddStyleMethod.PerformPatchOperation();
    }


}
