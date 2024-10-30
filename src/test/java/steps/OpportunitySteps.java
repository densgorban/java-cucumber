package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import pages.opportunity.OpportunityPage;

public class OpportunitySteps {

    OpportunityPage opportunityPage;

    @Given("I open opportunity")
    public void openOpportunity() {
        opportunityPage = new OpportunityPage(DriverFactory.getPage());
        opportunityPage.openOpportunity("PDFButler for Solvay S.A.");
    }
    @Given("I create new Agreement")
    public void createNewAgreement() {
        opportunityPage.createNewAgreement()
                .setField("Contract status", "Draft")
                .setField("Template", "End-user subscription agreement v3")
                .createContractInstance();
    }
}
