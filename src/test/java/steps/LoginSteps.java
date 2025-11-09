package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.training.student_ulises_lara.page.LoginPage;
import com.epam.training.student_ulises_lara.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class that represents the steps definitions for login-related scenarios.
 */
public class LoginSteps {

    /**
     * Logger instance for logging scenario details
     */
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    /**
     * Instance of LoginPage to interact with login page elements
     */
    private LoginPage loginPage;

    /**
     * Thread-local StringBuilder to accumulate scenario logs
     */
    private static final ThreadLocal<StringBuilder> scenarioLog = ThreadLocal.withInitial(StringBuilder::new);

    /**
     * Method executed before each scenario to initialize logging
     *
     * @param scenario the current Cucumber scenario
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioLog.get().append("\n=== START SCENARIO: ").append(scenario.getName()).append(" ===\n");
    }

    /**
     * Method executed after each scenario to log accumulated details
     *
     * @param scenario the current Cucumber scenario
     */
    @After
    public void afterScenario(Scenario scenario) {
        scenarioLog.get().append("=== END SCENARIO: ").append(scenario.getName()).append(" ===\n");
        logger.info(scenarioLog.get().toString());
        scenarioLog.remove();
    }

    /**
     * Logs a message to the scenario log
     *
     * @param message the message to log
     */
    public void log(String message) {
        scenarioLog.get().append(message).append("\n");
    }

    /**
     * Step definition to open the login page
     */
    @Given("I open the login page")
    public void openLoginPage() {
        loginPage = new LoginPage(test.Hooks.getDriver()).openPage();
        log("Opened Login Page");
    }

    /**
     * Step definition to enter username into the username field
     *
     * @param username the username to enter
     */
    @When("I enter {string} into the username field")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        log("Entered Username: " + username);
    }

    /**
     * Step definition to enter password into the password field
     *
     * @param password the password to enter
     */
    @When("I enter {string} into the password field")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        log("Entered Password");
    }

    /**
     * Step definition to clear the username field
     */
    @When("I clear the username field")
    public void clearUsername() {
        loginPage.clearUsername();
        log("Cleared Username");
    }

    /**
     * Step definition to clear the password field
     */
    @When("I clear the password field")
    public void clearPassword() {
        loginPage.clearPassword();
        log("Cleared Password");
    }

    /**
     * Step definition to click the login button
     */
    @When("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
        log("Clicked Login Button");
    }

    /**
     * Step definition to check the error message displayed on the login page
     *
     * @param expectedMessage the expected error message
     */
    @Then("I should see the error message {string}")
    public void checkErrorMessage(String expectedMessage) {
        assertThat(loginPage.getAlertMessage(), equalTo(expectedMessage));
        log("Checked error message: " + expectedMessage);
    }

    /**
     * Step definition to check the header title on the main page after login
     *
     * @param expectedTitle the expected header title
     */
    @Then("I should see the header title {string}")
    public void checkHeaderTitle(String expectedTitle) {
        MainPage mainPage = new MainPage(test.Hooks.getDriver());
        assertThat(mainPage.getHeaderTitle(), equalTo(expectedTitle));
        log("Checked header title: " + expectedTitle);
    }
}
