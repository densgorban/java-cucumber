package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;

@Slf4j
public class OneAppLauncherElement {
    private Page page;

    public OneAppLauncherElement(Page page) {
        this.page = page;
    }

    public void selectApplication(String application) {
        page.locator("one-app-launcher-header button").click();
        page.locator("input[placeholder='Search apps and items...']").fill(application);
        page.locator(format("one-app-launcher-menu-item a[data-label='%s']", application)).click();
    }
}
