package pages.contract;

import com.microsoft.playwright.Locator;

import static java.lang.String.format;

public class CreateContractModalPopup {

    private final Locator root;

    public CreateContractModalPopup(Locator root) {
        this.root = root;
        root.getByText("Create Agreement").isVisible();
    }

    public CreateContractModalPopup setDropdownField(String fieldLabel, String option) {
        Locator fieldLocator = root.locator(format("flowruntime-screen-field:has-text('%s')", fieldLabel));
        if (fieldLocator.isVisible()) {
            fieldLocator.locator("input").click();
            fieldLocator.getByText(option).click();
        }
        return this;
    }

    public CreateContractModalPopup setTextField(String fieldLabel, String text) {
        Locator fieldLocator = root.locator(format("flowruntime-screen-field:has-text('%s')", fieldLabel));
        if (fieldLocator.isVisible()) {
            fieldLocator.locator("input").fill(text);
        }
        return this;
    }

    public CreateContractModalPopup setCalendarField(String fieldLabel, String option) {
        Locator fieldLocator = root.locator(format("flowruntime-screen-field:has-text('%s')", fieldLabel));
        if (fieldLocator.isVisible())
            fieldLocator.locator("input").fill(option);
        return this;
    }

    public CreateContractModalPopup createContractInstance() {
        root.locator("button").getByText("Create Contract").click();
        return this;
    }
}
