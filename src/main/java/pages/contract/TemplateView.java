package pages.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.lang.String.format;

public class TemplateView {
    private final Page page;
    private final Locator TABLE_ROOT;

    public TemplateView(Page page) {
        this.page = page;
        TABLE_ROOT = page.locator("table[aria-label='Templates']");
    }

    public TemplateView tableContainsTemplate(String fullTemplateName) {
        assertThat(TABLE_ROOT.locator(format("a[title='%s']", fullTemplateName))).hasAttribute("title", fullTemplateName);
        return this;
    }

    public List<String> templateNames() {
        return page.locator("//tbody/tr/th/span/a").allInnerTexts();
    }
}
