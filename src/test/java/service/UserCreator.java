package service;

import model.User;

public class UserCreator {
    public static User createUser() {
        return new User(
                TestDataReader.getTestData("valid.username"),
                TestDataReader.getTestData("valid.password")
        );
    }

}
