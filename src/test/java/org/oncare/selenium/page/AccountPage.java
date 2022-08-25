package org.oncare.selenium.page;


import org.oncare.selenium.driver.CustomWebDriver;
import org.oncare.selenium.page.core.PageObject;
import static org.oncare.selenium.locator.AccountLocator.*;
import static org.oncare.selenium.locator.DressesLocator.headerOfDresses;

public class AccountPage extends PageObject {
    public AccountPage(CustomWebDriver driver) {
        super(driver, AccountPage.class.getName());
    }


    public String vlidateMyAccountHeader() {
        driver.waitVisibilityOf(headerOfMyAccount.by(), 10);
        return driver.getText(headerOfMyAccount.by());

    }

    public void clickOnDressesCategory() {
        driver.clickOn(dressesTab);
    }

    public String vlidateDressesHeader() {
        driver.waitVisibilityOf(headerOfDresses.by(), 10);
        return driver.getText(headerOfDresses.by());
    }
}
