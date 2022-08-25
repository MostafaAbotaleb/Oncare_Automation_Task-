package org.oncare.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SystemProperties {
    private static final Logger logger = Logger.getLogger(SystemProperties.class.getName());
    private static final Properties SYSTEM_PROPS = loadSystemProperties();

    private static Properties loadSystemProperties() {
        Properties systemProps = new Properties();
        try {
            InputStream appConfigIn = SystemProperties.class.getClassLoader().getResourceAsStream("system.properties");
            if (appConfigIn == null) {
                throw new IllegalArgumentException("system.properties not found");
            }
            systemProps.load(appConfigIn);

        } catch (IOException e) {
            logger.error(e);
            throw new IllegalArgumentException(e);
        }
        return systemProps;
    }


    public static String getSeleniumBrowser() {
        String seleniumBrowser = SYSTEM_PROPS.getProperty("selenium.browser");
        if (seleniumBrowser == null) {
            throw new IllegalArgumentException("selenium.browser configuration not found in system.properties");
        }

            return seleniumBrowser;

    }

    public static String getApplicationUrl() {
        String applicationUrl = SYSTEM_PROPS.getProperty("application.url");
        if (applicationUrl == null) {
            throw new IllegalArgumentException("application.url configuration not found in system.properties");
        }
        else {
            return applicationUrl;
        }
    }
}
