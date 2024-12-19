package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import utam.core.framework.base.BaseRootPageObject;
import utils.WebActions;

import static java.lang.String.format;


public class LoginPage extends BaseRootPageObject {
    private final Page page;
    private final Locator USERNAME_EDITBOX;
    private final Locator PASSWORD_EDITBOX;
    private final Locator LOGIN_BUTTON;

    public LoginPage(Page page) {
        this.page = page;
        this.USERNAME_EDITBOX = page.locator("#username");
        this.PASSWORD_EDITBOX = page.locator("#password");
        this.LOGIN_BUTTON = page.locator("#Login");
    }

    public void navigateToUrl(String url) {
        String realUrl = WebActions.decrypt(url);
        Allure.step(format("Navigate to '%s'", realUrl));
        this.page.navigate(realUrl);
    }

    public void enterUsername(String role) {
        String userName = WebActions.decrypt(role);
        Allure.step(format("Set Username: %s", userName));
        USERNAME_EDITBOX.fill(userName);
    }

    public void enterPassword(String password) {
        Allure.step(format("Set Password: (decrypted): %s", password));
        PASSWORD_EDITBOX.fill(WebActions.decrypt(password));
    }

    public void clickLogin() {
        Allure.step("Click Login");
        LOGIN_BUTTON.click();
    }

    public void bypassLoginBlockers() {
        if(page.getByText("Register Your Mobile Phone").isVisible()) {
            page.getByText("Remind Me Later").click();
        }
    }
}
