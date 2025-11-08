package test;

import model.User;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTests extends CommonConditions {
    @Test
    public void loginSuccess() {
        User user = UserCreator.withValidCredentials();
        String title = new LoginPage(driver)
                .openPage()
                .login(user)
                .getHeaderTitle();

        assertThat(title, is(equalTo("Swag Labs")));
    }
}
