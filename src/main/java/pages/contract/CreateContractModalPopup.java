package pages.contract;

import com.microsoft.playwright.Locator;

import static java.lang.String.format;

public class CreateContractModalPopup {

    private final Locator root;

    public CreateContractModalPopup(Locator root) {
        this.root = root;
    }

    public CreateContractModalPopup setField(String fieldLabel, String option) {
        Locator fieldLocator = root.locator(format("flowruntime-screen-field:has-text('%s')", fieldLabel));
        fieldLocator.locator("input").click();
        fieldLocator.getByText(option).click();
        return this;
    }

    public void createContractInstance() {
        root.locator("button").getByText("Create Contract Instance").click();
    }
}
