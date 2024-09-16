package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UISteps {

    @Given("^I login as user \"([^\"]*)\"$")
    public void m(String userName) {
        System.out.println("Login as user");
    }
    @When("^I navigate to My Profile and click \"([^\"]*)\"$")
    public void m2(String option) {
        System.out.println("Click options");
    }

    @And("^I create Playground with name \"([^\"]*)\"$")
    public void m3(String companyName) {
        System.out.println("Playground");
    }
    @Then("^new organization appears in my app list$")
    public void m4() {
        System.out.println("Orgs lists");
    }


}
