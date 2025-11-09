package com.epam.training.student_ulises_lara.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Singleton class to manage WebDriver instances.
 * Uses ThreadLocal to ensure thread safety for parallel test execution.
 */
public class DriverSingleton {

    /** ThreadLocal to hold WebDriver instances for each thread */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Returns the WebDriver instance for the current thread.
     *
     * Uses ThreadLocal to support parallel execution.
     * Chooses the browser based on the system property "browser" (default is "chrome").
     * Sets up the corresponding driver with WebDriverManager.
     * Maximizes the browser window upon startup.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = System.getProperty("browser", "chrome");

            switch (browser.toLowerCase()) {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
            }

            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    /**
     * Closes the WebDriver instance for the current thread and removes it from ThreadLocal.
     */
    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}