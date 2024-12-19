package pages.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.lang.String.format;

public class AgreementView {

    private final Page page;
    private final Locator TABLE_ROOT;

    public AgreementView(Page page) {
        this.page = page;
        TABLE_ROOT = page.locator("table[aria-label='Agreements']");
        TABLE_ROOT.hover();
    }

    public AgreementView tableContainsAgreement(String fullTemplateName) {
        assertThat(TABLE_ROOT.locator(format("a[title='%s']", fullTemplateName))).hasAttribute("title", fullTemplateName);
        return this;
    }

    public List<String> agreementNames() {
        return page.locator("//tbody/tr/th/span/a").allInnerTexts();
    }

    public void checkAgreementStatus(String agreementName, String status) {
        Locator statusField = TABLE_ROOT.locator(format("tr:has-text('%s')", agreementName))
                .locator("*[role='gridcell']")
                .nth(4);
        assertThat(statusField).containsText(status);
    }
}
