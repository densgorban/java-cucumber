package pages;

import com.google.common.base.Optional;
import com.microsoft.playwright.Page;
import factory.DriverFactory;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;

@Slf4j
public class ContractButlerPage {

    Page page = DriverFactory.getPage();
    TemplateBuilder templateBuilder;

    @Step
    public void selectTab(String tabName) {
        page.locator(format("one-app-nav-bar-item-root a[title='%s']", tabName)).click();
    }

    @Step
    public void clickButton(String buttonName) {
        page.locator(format("li a[title='%s']", buttonName)).click();
    }

    public TemplateBuilder templateBuilder() {
        if(templateBuilder == null)  templateBuilder = new TemplateBuilder(page);
        return templateBuilder;
    }
}
