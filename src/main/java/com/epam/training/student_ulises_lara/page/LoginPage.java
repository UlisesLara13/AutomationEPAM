package com.epam.training.student_ulises_lara.page;

import com.epam.training.student_ulises_lara.model.User;
import com.epam.training.student_ulises_lara.service.TestDataReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LoginPage class represents the login page of the application.
 * It provides methods to interact with the login form elements.
 */
public class LoginPage extends AbstractPage {

    /**
     * The URL of the application's login page,
     * loaded from external URL properties configuration.
     */
    private final String PAGE_URL = TestDataReader.getTestData("base.url");

    /** Web element for the username input field. */
    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement inputLogin;

    /** Web element for the password input field. */
    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPassword;

    /** Web element for the submit button. */
    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement buttonSubmit;

    /** Web element for the alert message displayed on login failure. */
    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement alertMessage;

    /**
     * Constructor for LoginPage.
     * Initializes web elements using PageFactory.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the login page by navigating to the specified URL.
     *
     * @return the current instance of LoginPage
     */
    @Override
    public LoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        waitForVisibility(inputLogin);
        return this;
    }

    /** Logs in using the provided User object's credentials.
     *
     * @param user the User object containing username and password
     * @return a new instance of MainPage upon successful login
     */
    @Deprecated
    public MainPage login(User user) {
        typeText(inputLogin, user.getUsername());
        typeText(inputPassword, user.getPassword());
        clickElement(buttonSubmit);
        return new MainPage(driver);
    }

    /** Enters the username into the username input field.
     *
     * @param username the username to be entered
     */
    public void enterUsername(String username) {
        typeText(inputLogin, username);
    }

    /** Enters the password into the password input field.
     *
     * @param password the password to be entered
     */
    public void enterPassword(String password) {
        typeText(inputPassword, password);
    }

    /** Clears the username input field. */
    public void clearUsername() {
        inputLogin.sendKeys(Keys.CONTROL + "a");
        inputLogin.sendKeys(Keys.BACK_SPACE);
    }

    /** Clears the password input field. */
    public void clearPassword() {
        inputPassword.sendKeys(Keys.CONTROL + "a");
        inputPassword.sendKeys(Keys.BACK_SPACE);
    }

    /** Clicks the login button to submit the login form. */
    public void clickLogin() {
        clickElement(buttonSubmit);
    }

    /** Retrieves the alert message displayed on login failure.
     *
     * @return the alert message text
     */
    public String getAlertMessage() {
        return getText(alertMessage);
    }
}
