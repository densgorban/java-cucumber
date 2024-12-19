package steps;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.contract.CreateContractModalPopup;
import pages.opportunity.OpportunityPage;

import static factory.ContextData.CONTRACT_NAME;
import static factory.DriverFactory.testContext;

public class OpportunitySteps {

    OpportunityPage opportunityPage;

    @Given("I open opportunity")
    public void openOpportunity() {
        opportunityPage = new OpportunityPage(DriverFactory.getPage());
        opportunityPage.openOpportunity("PDFButler for Solvay S.A.");
        opportunityPage.checkOpportunityStage("Quote/proposal sent");
    }
    @Given("I create new Agreement")
    public void createNewAgreement() {
        //todo: verify that Opportunity is on 'Quote/Propose sent' stage
        String contractName = "AContract_" + System.currentTimeMillis();
        testContext.get().data.put(CONTRACT_NAME, contractName);
        CreateContractModalPopup newAgreementPopup = opportunityPage.createNewAgreement();
        if (newAgreementPopup.isStageOne()) {
            newAgreementPopup
                    .setCalendarField("Contract Start Date", "31-Oct-2023")
                    .setTextField("Contract Term (months)", "3")
                    .createContractInstance();
        }
        newAgreementPopup
                .setDropdownField("Contract Status", "Draft")
                .setDropdownField("Contract Approver:", "Luke White")
                .setDropdownField("Template:", "End-user subscription agreement v3")
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
