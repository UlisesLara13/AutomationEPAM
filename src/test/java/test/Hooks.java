package test;

import com.epam.training.student_ulises_lara.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Hooks class to manage WebDriver lifecycle for Cucumber scenarios.
 */
public class Hooks {

    /**
     * Thread-local WebDriver instance for parallel execution
     * */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Logger instance for logging scenario details
     * */
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    /**
     * Method executed before each scenario to initialize WebDriver
     *
     */
    @Before
    public void setUp() {
        driver.set(DriverSingleton.getDriver());
    }

    /**
     * Method executed after each scenario to close WebDriver and log failures
     *
     * @param scenario the current Cucumber scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: {}", scenario.getName());
        }

        DriverSingleton.closeDriver();
        driver.remove();
    }

    /**
     * Returns the WebDriver instance for the current thread
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }
}