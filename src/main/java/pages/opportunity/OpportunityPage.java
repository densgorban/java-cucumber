package pages.opportunity;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.contract.ContractEditPanel;
import pages.contract.CreateContractModalPopup;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.lang.String.format;

public class OpportunityPage {

    private final Page page;
    private Locator root;

    public OpportunityPage(Page page) {
        this.page = page;
        this.root = page.locator("div[data-aura-class='forceListViewManager']");
    }

    public OpportunityPage openOpportunity(String opportunityTitle) {
        root.locator(format("a[title='%s']", opportunityTitle)).click();
        return this;
    }

    public CreateContractModalPopup createNewAgreement() {
        page.locator("button").getByText("Create Agreement").click();
        return new CreateContractModalPopup(page.locator("div[aria-label='Create Agreement']"));
    }

    public ContractEditPanel agreementEditPage() {
        return new ContractEditPanel();
    }

    public void checkOpportunityStage(String expectedStageName) {
        Locator subheader = page.locator("slot[name='subheader']");
        assertThat(subheader)
                .isVisible();
        assertThat(subheader.locator("li.slds-is-current"))
                .containsText(expectedStageName);


    }
}
