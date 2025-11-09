package com.epam.training.student_ulises_lara.service;

import java.util.ResourceBundle;

/**
 * TestDataReader is a utility class that reads test data from property files
 * based on the specified environment. It retrieves values associated with
 * provided keys from the resource bundle.
 */
public class TestDataReader {
    /** The environment property determines which resource bundle to load.
     * Defaults to "url" if not specified.
     */
    private static final String ENV = System.getProperty("environment", "url");

    /**
     * ResourceBundle instance for accessing test data properties.
     */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(ENV);

    /**
     * Retrieves the test data value associated with the specified key
     * from the resource bundle.
     *
     * @param key the key for which to retrieve the test data value
     * @return the test data value corresponding to the provided key
     */
    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
