package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginNegativeTests extends CommonConditions {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {TestDataReader.getTestData("valid.username"), "", "Epic sadface: Password is required"},
                {TestDataReader.getTestData("invalid.username"), TestDataReader.getTestData("invalid.password"), "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testInvalidLogins(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver).openPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        assertThat(loginPage.getAlertMessage(), is(equalTo(expectedMessage)));
    }
}
