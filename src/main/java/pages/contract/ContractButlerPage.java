package pages.contract;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import factory.DriverFactory;
import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;

@Slf4j
public class ContractButlerPage {

    Page page = DriverFactory.getPage();
    TemplateBuilder templateBuilder;

    public ContractButlerPage selectTab(String tabName) {
        Locator locator = page.locator(format("one-app-nav-bar-item-root a[title='%s']", tabName));
        locator.hover();
        locator.click();
        return this;
    }

    public void clickButton(String buttonName) {
        page.locator(format("li a[title='%s']", buttonName)).click();
    }

    public TemplateBuilder templateBuilder() {
        if(templateBuilder == null)  templateBuilder = new TemplateBuilder(page);
        return templateBuilder;
    }

    public TemplateView templateView() {
        return new TemplateView(page);
    }
    public AgreementView agreementView() {
        return new AgreementView(page);
    }

}
