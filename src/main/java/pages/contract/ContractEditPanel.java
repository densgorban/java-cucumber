package pages.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import factory.DriverFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContractEditPanel {

    private final Locator root;

    public ContractEditPanel() {
        Page page = DriverFactory.getPage();
        this.root = page.locator("c-contract-content-builder");
    }


    public ContractItemActionEdit editSection(int id) {
        return new ContractItemActionEdit(root);
    }


    public ContractEditPanel checkContractName(String expectedName) {
        assertThat(root.locator("div.title")).containsText(expectedName);
        return this;
    }
    public ContractItemActionTag tag() {
        return new ContractItemActionTag(root.page().locator("lightning-modal"));
    }

    public void submitForApproval() {
        root.locator("button").getByText("Submit for Approval").click();

    }

    public void approveUsingApprovalRecord() {
        root.locator("button.button-menu").click();
        root.locator("div.dropdown").getByText("Open Approval Record").click();
        DriverFactory.getPage()
                .locator("one-app-nav-bar-item-root")
                .all()
                .stream().filter(l -> l.innerText().contains("Approval"))
                .findFirst()
                .get()
                .click();
        DriverFactory.getPage()
                .locator("a[role='button']")
                .locator("div[title='Approve']")
                .click();
        DriverFactory.getPage()
                .locator("div.commentContainer")
                .locator("textarea.inputTextArea")
                .fill("Approved " + System.currentTimeMillis());
        DriverFactory.getPage()
                .locator("div.modal-container")
                .getByText("Approve")
                .click();
    }
}
