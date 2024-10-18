package pages.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j
public class TemplateBuilder {

    private final Page page;
    Locator TITLE_INPUT;
    Locator SAVE_AS_NEW_BUTTON;
    Locator UPDATE_BUTTON;
    Locator TEMPLATE_BUILDER_ROOT;
    Locator TEMPLATE_BUILDER_PANEL;
    Locator TEMPLATE_BUILDER_CONTENT;

    public TemplateBuilder(Page page) {
        this.page = page;
        TITLE_INPUT = page.locator("input.cke_editable.contractName");
        TEMPLATE_BUILDER_ROOT = page.locator("c-negotiation-butler-contract-template-builder");
        TEMPLATE_BUILDER_PANEL = page.locator("c-negotiation-butler-contract-highlight-panel");
        TEMPLATE_BUILDER_CONTENT = page.locator("c-negotiation-butler-contract-content");
        SAVE_AS_NEW_BUTTON = TEMPLATE_BUILDER_PANEL.getByText("Save As a New Template");
        UPDATE_BUTTON = TEMPLATE_BUILDER_PANEL.locator("button").getByText("Update");
    }

    @SneakyThrows
    public TemplateBuilder setName(String templateName) {
        TITLE_INPUT.click();
        Thread.sleep(500);
        TITLE_INPUT.fill(templateName);
        TEMPLATE_BUILDER_ROOT.focus();
        TITLE_INPUT.fill(templateName);
        page.locator("div.createContentCard").click();
        TITLE_INPUT.fill(templateName);
        return this;
    }

    @SneakyThrows
    public TemplateBuilder saveAsNewTemplate() {
        SAVE_AS_NEW_BUTTON.focus();
        SAVE_AS_NEW_BUTTON.click();
        Thread.sleep(500);
        return this;
    }

    public TemplateBuilder checkUpdateButtonIsVisible() {
        assertThat(UPDATE_BUTTON).isVisible();
        return this;
    }

    public TemplateBuilder updateTemplate() {
        page.locator("button:has-text('Update')").click();
        return this;
    }

    public TemplateBuilder checkSuccessPopupAppears() {
        assertThat(page.locator("div[data-key='success']")).isVisible();
        return this;
    }

    public TemplateBuilder focusTemplateBuilderRoot() {
        TEMPLATE_BUILDER_ROOT.focus();
        return this;
    }

    public void addClause(String someText, String tag) {
        assertThat(TEMPLATE_BUILDER_CONTENT).isVisible();
        Locator section1Locator = TEMPLATE_BUILDER_CONTENT
                .locator("c-negotiation-butler-contract-item[data-name='1']");
        ContractItem contractItem1 = new ContractItem(section1Locator);
        contractItem1.edit()
                .clearText()
                .typeText(someText)
                .save();
        contractItem1.tag()
                .putText(tag)
                .save();
    }

}

