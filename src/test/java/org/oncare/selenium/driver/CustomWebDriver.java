package org.oncare.selenium.driver;

import org.apache.log4j.Logger;
import org.oncare.selenium.locator.core.Locator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;


public class CustomWebDriver {
    static public WebElement pro;
    private static final Logger logger = Logger.getLogger(CustomWebDriver.class.getName());
    private final WebDriver driver;

    public CustomWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.quit();
    }

    public WebDriver getSeleniumWebDriver() {
        return driver;
    }

    public void goToUrl(String URL) {
        driver.navigate().to(URL);
    }
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }


    public void sendKeysTo(Locator locator, String text) {

        sendKeysTo(locator.by(), text);
    }

    public void sendKeysTo(By by, String text) {
        waitVisibilityOf(by, 120);
        driver.findElement(by).sendKeys(text);
    }

    public void sendKeysAndClear(Locator locator, String text) {
        waitVisibilityOf(locator, 120);
        driver.findElement(locator.by()).clear();
        sendKeysTo(locator, text);
    }

    public void clickOn(By by) {
        waitVisibilityOf(by, 120);
        driver.findElement(by).click();
    }

    public void clickOn(Locator locator) {
        clickOn(locator.by());
    }

    public void forceClickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void waitVisibilityOf(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitVisibilityOf(Locator locator, int timeOut) {
        waitVisibilityOf(locator.by(), timeOut);
    }


    public boolean isElementVisible(By by) {
        return driver.findElement(by).isDisplayed();
    }



    public void blur(Locator locator) {
        WebElement element = driver.findElement(locator.by());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].blur(); return true;", element);
    }

    public void selectByName(By by, String option) throws Throwable {
        boolean staleElement = true;
        int numberTries = 0;
        do {
            try {
                numberTries++;
                List<WebElement> elements = driver.findElements(by);
                int i = IntStream.range(0, elements.size())
                        .filter(index -> elements.get(index).getText().equals(option))
                        .findFirst()
                        .orElseThrow(() -> new Exception(option + " not found"));
                driver.findElements(by).get(i).click();
                staleElement = false;
            } catch (StaleElementReferenceException ex) {
                if (numberTries == 3) {
                    throw ex;
                }
            }
        } while (staleElement);
    }

    public void uploadFileFromDocuments(Locator fileInputElement, String fileName) throws IOException {
        String path = "./src/main/resources/Documents/" + fileName;
        File file = new File(path);
        if (this.isElementVisible(fileInputElement.by())) {
            driver.findElement(fileInputElement.by()).sendKeys(file.getCanonicalPath());
        } else {
            this.sendKeysTo(fileInputElement, file.getCanonicalPath());
        }
    }

    public Set<String> getWindowHandles() {
        return null;
    }

    public WebDriver.TargetLocator switchTo() {
        return null;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(Locator locator) {
        return driver.findElements(locator.by());
    }

    public String switchToNewTab() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        return winHandleBefore;
    }

    public int randomIntger (){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return randomInt;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<String> getAllElementsText(Locator locator) {
        List<String> texts = new ArrayList<>();
        findElements(locator).forEach(webElement -> texts.add(webElement.getText()));
        return texts;



            }



    public String getText(By by) {
        return findElement(by).getText();
    }


    public boolean waitUntilPageUrlContains(String expectedPageUrl, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getSeleniumWebDriver(), timeOutInSeconds);
        wait.until(ExpectedConditions.urlContains(expectedPageUrl));
        return true;
    }

    public void selectByIndex(By by, int index) {
        final Select combo = new Select(driver.findElement(by));
        combo.selectByIndex(index);

    }

    public void streamFilter(Locator locator1,Locator locator2,  String productName){
        List<WebElement> products=driver.findElements(locator1.by());
          pro= products.stream().filter(product->
                product.findElement(locator2.by()).getText()
                        .equals(productName)).findFirst().orElse(null);



    }


    public void selectByValue(By by, String value) {
        final Select combo = new Select(driver.findElement(by));
        combo.selectByValue(value);
    }

}
