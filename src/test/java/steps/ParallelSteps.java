package steps;

import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParallelSteps {

    @SneakyThrows
    @Given("I perform test with timeout {int}")
    public void m(int timeout) {
        Thread.sleep(timeout);
    }

    @Given("I log results")
    public void m2() {
        log.info(String.format("end the test (thread: %s) ", Thread.currentThread().getId()));
    }

}
