package com.phoenix.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Properties properties;

    private ConfigurationManager() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config/FrameworkConfig.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find FrameworkConfig.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Add getter methods for specific configurations with type conversion
    public String getBrowser() {
        return getProperty("browser");
    }

    public String getBaseUrl() {
        return getProperty("baseUrl");
    }

    public String getApiUrl() {
        return getProperty("apiUrl");
    }

    public long getImplicitWait() {
        return Long.parseLong(getProperty("implicitWait"));
    }

    public long getExplicitWait() {
        return Long.parseLong(getProperty("explicitWait"));
    }

    public String getLogLevel() {
        return getProperty("logLevel");
    }

    public String getReportTitle() {
        return getProperty("reportTitle");
    }

    public String getReportName() {
        return getProperty("reportName");
    }
}