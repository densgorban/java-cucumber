package steps;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import pages.LoginPage;
import pages.OneAppLauncherElement;

@Slf4j
public class AppLauncherSteps {

    OneAppLauncherElement oneAppLauncher = new OneAppLauncherElement(DriverFactory.getPage());

    @And("I navigate to {string} application")
    public void navigateToApplication(String appName) {
        oneAppLauncher.selectApplication(appName);
    }
}
