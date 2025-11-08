package service;

import model.User;

public class UserCreator {
    public static User withValidCredentials() {
        return new User(
                TestDataReader.getTestData("valid.username"),
                TestDataReader.getTestData("valid.password")
        );
    }

    public static User withInvalidCredentials() {
        return new User(
                TestDataReader.getTestData("invalid.username"),
                TestDataReader.getTestData("invalid.password")
        );
    }
}
