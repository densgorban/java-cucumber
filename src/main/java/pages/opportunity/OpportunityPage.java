package pages.opportunity;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.contract.CreateContractModalPopup;

public class OpportunityPage {

    private final Page page;
    private Locator root;

    public OpportunityPage(Page page) {
        this.page = page;
        this.root = page.locator("div[data-aura-class='forceListViewManager']");
    }

    public OpportunityPage openOpportunity(String opportunityTitle) {
        root.locator("a").getByText(opportunityTitle).click();
        return this;
    }

    public CreateContractModalPopup createNewAgreement() {
        page.locator("button").getByText("Create Agreement").click();
        return new CreateContractModalPopup(page.locator("div[aria-label='Create Agreement']"));
    }
}
