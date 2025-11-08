package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.TestDataReader;

public class MainPage extends AbstractPage {

    private final String PAGE_URL = TestDataReader.getTestData("base.url");


    @FindBy(xpath = "//*[@class='app_logo']")
    private WebElement pageTitle;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }


    public String getHeaderTitle() {
        return pageTitle.getText().trim();
    }

}
