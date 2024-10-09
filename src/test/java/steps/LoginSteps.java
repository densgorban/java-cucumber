package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import pages.LoginPage;

@Slf4j
public class LoginSteps {

    private LoginPage loginPage;

    @Given("I login as {string} user")
    public void login(String user) {
        loginPage = new LoginPage(DriverFactory.getPage());
        loginPage.navigateToUrl("url");
        loginPage.enterUsername("adminUsername");
        loginPage.enterPassword("adminPassword");
        loginPage.clickLogin();
    }

}
