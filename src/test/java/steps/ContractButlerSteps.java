package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.contract.ContractButlerPage;

import java.util.List;

import static factory.ContextData.*;
import static factory.DriverFactory.testContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

@Slf4j
public class ContractButlerSteps {

    private final ContractButlerPage contractButlerPage = new ContractButlerPage();

    @When("I open {string} tab")
    @And("I return to {string} tab")
    public void openTab(String tabName) {
        contractButlerPage.selectTab(tabName);
    }
    @When("I create new contract Template")
    public void createContract() {
        contractButlerPage.clickButton("New");
    }

    @And("I set contract Template name {string}")
    public void setContractName(String user) {
        String templateName = "ATemplate_" + System.currentTimeMillis();
        testContext.get().data.put(TEMPLATE_NAME, templateName);
        contractButlerPage.templateBuilder()
                .setName(templateName)
                .focusTemplateBuilderRoot();
    }

    @And("I save new Template")
    public void saveTemplate() {
        contractButlerPage.templateBuilder().saveAsNewTemplate();
    }

    @And("I add clause")
    public void addClause() {
        contractButlerPage.templateBuilder().addClause(
                """
                        CLOUDCROSSING REFERENCES TO SUBSCRIBER:
                        Upon execution of this Agreement, CloudCrossing may make references to Subscriber and Subscriber's URL and may use Subscriber's designated trademark and logo for publication on PDF Butler's current list of subscribers located on the PDF Butler Site.
                        PDF Butler may also respond to any inquiry regarding whether Subscriber is a licensee and user of the Services. You can also choose not to have your logo published. This entails a 15% surcharge on the license cost.""",
                "[[!CLOUDCROSSING!]]");
    }

    @And("Wait for Success popup")
    public void waitForSuccessStatus() {
        contractButlerPage.templateBuilder().checkSuccessPopupAppears();
        contractButlerPage.templateBuilder().checkUpdateButtonIsVisible();
    }

    @And("I can see the new item in the templates list")
    public void assertNewItemInList() {
        String templateName = testContext.get().data.get(TEMPLATE_NAME);

        List<String> actualTemplates = contractButlerPage.templateView()
                .tableContainsTemplate(templateName)
                .templateNames();
        log.info("Templates: " + actualTemplates);
        assertThat(actualTemplates, hasItem(templateName));
    }

}
