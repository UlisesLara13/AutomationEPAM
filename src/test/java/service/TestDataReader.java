package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final String ENV = System.getProperty("environment", "test");
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(ENV);

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
