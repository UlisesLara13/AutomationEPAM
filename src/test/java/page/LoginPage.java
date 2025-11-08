package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import service.TestDataReader;


public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = TestDataReader.getTestData("base.url");

    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement alertMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(inputLogin));
        logger.info("Login page opened");
        return this;
    }

    public MainPage login(User user) {

        wait.until(ExpectedConditions.visibilityOf(inputLogin));
        inputLogin.sendKeys(user.getUsername());

        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(user.getPassword());

        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        buttonSubmit.click();
        logger.info("Login performed");

        return new MainPage(driver);
    }

    public void enterUsername(String username) {
        clearUsername();
        inputLogin.sendKeys(username);
    }

    public void enterPassword(String password) {
        clearPassword();
        inputPassword.sendKeys(password);
    }

    public void clearUsername() {
        inputLogin.sendKeys(Keys.CONTROL + "a");
        inputLogin.sendKeys(Keys.BACK_SPACE);
    }

    public void clearPassword() {
        inputPassword.sendKeys(Keys.CONTROL + "a");
        inputPassword.sendKeys(Keys.BACK_SPACE);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        buttonSubmit.click();
    }

    public String getAlertMessage() {
        return alertMessage.getText().trim();
    }

}
