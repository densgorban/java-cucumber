package pages.contract;

import com.microsoft.playwright.Locator;

public class ContractItem {

    private final Locator root;
    private final Locator actionPanel;

    public ContractItem(Locator locator) {
        this.root = locator;
        this.actionPanel = root.locator("div.contract-item__action-panel");

    }

    public ContractItemActionEdit add() {
        actionPanel.hover();
        actionPanel.locator("div.contract-item__add-panel--show").click();
        return new ContractItemActionEdit(root);
    }
    public ContractItemActionEdit edit() {
        actionPanel.hover();
        actionPanel.locator("div.contract-item__edit-panel-line").click();
        return new ContractItemActionEdit(root);
    }

    //todo: implement remove wrapper
    public ContractItemActionEdit remove() {
        actionPanel.hover();
        actionPanel.locator("div.contract-item__remove-panel-line").click();
        return new ContractItemActionEdit(root);
    }
    public ContractItemActionTag tag() {
        actionPanel.hover();
        actionPanel.locator("div.contract-item__tag-panel--show").click();
        return new ContractItemActionTag(root.page().locator("lightning-modal"));
    }
}
