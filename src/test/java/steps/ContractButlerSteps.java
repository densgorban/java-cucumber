package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.ContractButlerPage;

@Slf4j
public class ContractButlerSteps {

    private ContractButlerPage cbPage = new ContractButlerPage();

    @When("I open {string} tab")
    @And("I return to {string} tab")
    public void openTab(String tabName) {
        cbPage.selectTab(tabName);
    }
    @When("I create new contract Template")
    public void createContract() {
        cbPage.clickButton("New");
    }

    @And("I set contract Template name {string}")
    public void setContractName(String user) {
        cbPage.templateBuilder().setName("ATemplate_"+System.currentTimeMillis() );
    }
    @And("I save Template")
    public void saveTemplate() {
        cbPage.templateBuilder().saveAsNewTemplate();
    }

    @And("Wait for Success popup")
    public void waitForSuccessStatus() {
        cbPage.templateBuilder().successMessage();
    }

    @And("I can see the new item in the templates list")
    public void assertNewItemInList() {
    }

}
