package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    private static Properties properties;
    private static final String CONFIG_FILE = "src/test/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream(CONFIG_FILE);
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading config.properties: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getTrelloEmail() {
        return properties.getProperty("trello.email", "dmthakare1998@gmail.com");
    }

    public static String getTrelloPassword() {
        return properties.getProperty("trello.password", "Thakare@1998");
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "firefox");
    }

    public static int getExplicitWaitTimeout() {
        return Integer.parseInt(properties.getProperty("explicit.wait.timeout", "20"));
    }
} 