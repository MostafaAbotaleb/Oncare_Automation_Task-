package org.oncare.selenium.locator;


import org.apache.log4j.Logger;
import org.oncare.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum AccountLocator implements Locator {

    dressesTab(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]")),
    headerOfMyAccount(By.cssSelector("h1[class='page-heading']"));





    static Logger logger = Logger.getLogger(AccountLocator.class.getName());
    private By locator;

    AccountLocator(By locator) {
        this.locator = locator;
    }

//    @Override
    public By by() {
        logger.trace("locator");
        return locator;
    }
}
