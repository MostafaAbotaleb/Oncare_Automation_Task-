package org.oncare.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.oncare.utils.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final String BROWSER = SystemProperties.getSeleniumBrowser();


    public static CustomWebDriver getBrowser() {
        WebDriver driver;
        switch (BROWSER.toUpperCase()) {
            case "CHROME":
                driver = getChromeDriver();
                break;
            case "FIREFOX":
                driver = getFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(BROWSER + "not supported");
        }
        driver.manage().window().maximize();
        return new CustomWebDriver(driver);
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    private static WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
