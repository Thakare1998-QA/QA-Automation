package utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration reader utility class for reading .env file
 */
public class ConfigReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static Dotenv dotenv;
    
    static {
        try {
            // Load .env file from project root
            dotenv = Dotenv.configure()
                    .directory(".")
                    .filename(".env")
                    .load();
            logger.info("Successfully loaded .env file");
        } catch (Exception e) {
            logger.warn("Could not load .env file, falling back to system environment variables: {}", e.getMessage());
            dotenv = null;
        }
    }
    
    /**
     * Get configuration value by key
     * Tries .env file first, then falls back to system environment variables
     * @param key configuration key
     * @return configuration value
     */
    public static String getProperty(String key) {
        String value = null;
        
        // Try .env file first
        if (dotenv != null) {
            value = dotenv.get(key);
            if (value != null) {
                logger.debug("Retrieved '{}' from .env file", key);
                return value;
            }
        }
        
        // Fall back to system environment variables
        value = System.getenv(key);
        if (value != null) {
            logger.debug("Retrieved '{}' from system environment variables", key);
            return value;
        }
        
        logger.warn("Configuration key '{}' not found in .env file or system environment", key);
        return null;
    }
    
    /**
     * Get Trello email from configuration
     * @return Trello email address
     */
    public static String getTrelloEmail() {
        return getProperty("TRELLO_EMAIL");
    }
    
    /**
     * Get Trello password from configuration
     * @return Trello password
     */
    public static String getTrelloPassword() {
        return getProperty("TRELLO_PASSWORD");
    }
    
    /**
     * Validate that all required configuration properties are present
     * @return true if all required properties are available
     */
    public static boolean validateConfig() {
        String email = getTrelloEmail();
        String password = getTrelloPassword();
        
        if (email == null || email.trim().isEmpty()) {
            logger.error("TRELLO_EMAIL is not configured");
            return false;
        }
        
        if (password == null || password.trim().isEmpty()) {
            logger.error("TRELLO_PASSWORD is not configured");
            return false;
        }
        
        logger.info("Configuration validation successful");
        return true;
    }
} 