package pages.contract;

import com.microsoft.playwright.Locator;

import java.util.function.Function;

import static java.lang.String.format;

public class CreateContractModalPopup {

    private final Locator root;
    Locator CREATE_CONTRACT_BUTTON;


    public CreateContractModalPopup(Locator root) {
        this.root = root;
        CREATE_CONTRACT_BUTTON = root.locator("button:has-text('Create Contract')");

        root.getByText("Create Agreement").isVisible();
        CREATE_CONTRACT_BUTTON.isVisible();
    }

    public boolean isStageOne() {
        return CREATE_CONTRACT_BUTTON.innerText().equals("Create Contract");
    }
    public boolean isStageTwo() {
        return CREATE_CONTRACT_BUTTON.innerText().equals("Create Contract Instance");
    }

    public CreateContractModalPopup setDropdownField(String fieldLabel, String option) {
        Locator fieldLocator = root.locator(format("flowruntime-screen-field:has-text('%s')", fieldLabel));
        if (fieldLocator.isVisible()) {
            fieldLocator.locator("input").click();
            fieldLocator.locator("lightning-base-combobox-item").getByText(option).nth(0).click();
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
        CREATE_CONTRACT_BUTTON.click();
        return this;
    }
}
