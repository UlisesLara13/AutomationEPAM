package test;

import model.User;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTests extends CommonConditions {

    @Test
    void loginSuccess() {
        User user = UserCreator.createUser();
        String title = new LoginPage(driver)
                .openPage()
                .login(user)
                .getHeaderTitle();

        assertThat(title, is(equalTo("Swag Labs")));
    }
}