package pages.contract;

import com.microsoft.playwright.Locator;

public class ContractItemActionTag {

    private final Locator modalWindow;
    public ContractItemActionTag(Locator modalDialogWindow) {
        this.modalWindow = modalDialogWindow;
    }

    public ContractItemActionTag putText(String tag) {
        modalWindow.locator("input.slds-input").pressSequentially(tag);
        return this;
    }

    public ContractItemActionTag save() {
        modalWindow.getByText("Save").click();
        return this;
    }
}

