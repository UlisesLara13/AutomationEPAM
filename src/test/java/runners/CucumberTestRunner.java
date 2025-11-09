package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

/**
 * Cucumber Test Runner Class
 * Configures the Cucumber test execution environment.
 * Specifies the location of feature files.
 * Sets the glue code packages.
 * Enables parallel execution with dynamic configuration.
 * Adjusts the parallel execution factor for optimal performance.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps,test")
@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true")
@ConfigurationParameter(key = "cucumber.execution.parallel.config.strategy", value = "dynamic")
@ConfigurationParameter(key = "cucumber.execution.parallel.config.dynamic.factor", value = "10")
public class CucumberTestRunner {
}