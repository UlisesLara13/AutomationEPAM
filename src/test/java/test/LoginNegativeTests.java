package test;

import org.junit.jupiter.api.Test;
import page.LoginPage;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class LoginNegativeTests extends CommonConditions {
    /**
     * UC-1
     * Steps:
     * 1) Enter username and password
     * 2) Clear both
     * 3) Click Login
     * Expect: "Epic sadface: Username is required"
     */
    @Test
    public void testEmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver).openPage();
        loginPage.enterUsername("something");
        loginPage.enterPassword("something");

        loginPage.clearUsername();
        loginPage.clearPassword();

        loginPage.clickLogin();

        assertThat(loginPage.getAlertMessage(), equalTo("Epic sadface: Username is required"));
    }

    /**
     * UC-2
     * Steps:
     * 1) Enter username and password
     * 2) Clear password
     * 3) Click Login
     * Expect: "Epic sadface: Password is required"
     */
    @Test
    public void testPasswordIsRequired() {
        LoginPage loginPage = new LoginPage(driver).openPage();
        loginPage.enterUsername("something");
        loginPage.enterPassword("something");

        loginPage.enterPassword("");

        loginPage.clickLogin();

        assertThat(loginPage.getAlertMessage(), equalTo("Epic sadface: Password is required"));
    }
}
