package com.epam.training.student_ulises_lara.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.training.student_ulises_lara.service.TestDataReader;

/**
 * MainPage class represents the Page after login the application.
 * It provides methods to interact with the main page elements.
 */
public class MainPage extends AbstractPage {

    /** The URL of the application's main page,
     * loaded from external URL properties configuration.
     */
    private final String PAGE_URL = TestDataReader.getTestData("base.url");

    /** Web element for the page title. */
    @FindBy(xpath = "//*[@class='app_logo']")
    private WebElement pageTitle;

    /**
     * Constructor for MainPage.
     * Initializes web elements using PageFactory.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Opens the main page by navigating to the specified URL.
     *
     * @return the current instance of MainPage
     */
    @Override
    public MainPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    /**
     * Retrieves the header title text from the main page.
     *
     * @return the header title text
     */
    public String getHeaderTitle() {
        return pageTitle.getText();
    }

}
