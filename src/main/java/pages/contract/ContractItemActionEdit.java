package pages.contract;

import com.microsoft.playwright.Locator;

class ContractItemActionEdit {

    private final Locator itemRoot;
    private final Locator textEditor;

    public ContractItemActionEdit(Locator root) {
        this.itemRoot = root;
        textEditor = itemRoot.locator("div.ql-editor.slds-rich-text-area__content");
    }

    public ContractItemActionEdit clearText() {
        textEditor.clear();
        return this;
    }

    public ContractItemActionEdit typeText(String text) {
        itemRoot.locator("div.ql-editor.slds-rich-text-area__content").pressSequentially(text);
        return this;
    }

    public void save() {
        itemRoot.getByText("OK").click();
    }
}
