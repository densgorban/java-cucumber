package steps;

import io.cucumber.java.en.Given;

public class CurrencyApiSteps {

    @Given("I perform {string} operation for {string}")
    public void sendRequest(String operation, String path) {
        System.out.println("Opearion: " + operation + "; path: " + path);
    }


}
