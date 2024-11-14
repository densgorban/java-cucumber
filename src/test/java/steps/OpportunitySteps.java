package steps;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.opportunity.OpportunityPage;

import static factory.ContextData.CONTRACT_NAME;
import static factory.ContextData.TEMPLATE_NAME;
import static factory.DriverFactory.testContext;

public class OpportunitySteps {

    OpportunityPage opportunityPage;

    @Given("I open opportunity")
    public void openOpportunity() {
        opportunityPage = new OpportunityPage(DriverFactory.getPage());
        opportunityPage.openOpportunity("PDFButler for Solvay S.A.");
    }
    @Given("I create new Agreement")
    public void createNewAgreement() {
        String contractName = "AContract_" + System.currentTimeMillis();
        testContext.get().data.put(CONTRACT_NAME, contractName);
        opportunityPage.createNewAgreement()
                .setCalendarField("Contract Start Date", "31-Oct-2023")
                .setTextField("Contract Term (months)", "3")
                .createContractInstance()
                .setTextField("Contract status", "Draft")
                .setDropdownField("Template", "End-user subscription agreement v3")
                .setTextField("Contract Name", contractName)
                .createContractInstance();
    }

    @And("I can see Agreement editing view")
    public void editPanelAgreement() {
        String contractName = testContext.get().data.get(CONTRACT_NAME);
        opportunityPage.agreementEditPage()
                .checkContractName(contractName);
    }

    @And("I Submit Agreement for Approval")
    public void sendAgreementForApproval() {
        opportunityPage.agreementEditPage()
                .submitForApproval();
    }

    @And("I Approve using Approval Records")
    public void approve() {
        opportunityPage.agreementEditPage()
                .approveUsingApprovalRecord();
    }
}
