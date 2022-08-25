package org.oncare.selenium.page;


import org.oncare.selenium.driver.CustomWebDriver;
import org.oncare.selenium.page.core.PageObject;

import static org.oncare.selenium.locator.SignInLocator.*;
public class SignInPage extends PageObject {
    public SignInPage(CustomWebDriver driver) {
        super(driver, SignInPage.class.getName());
    }

    public String getUrl() {
        driver.waitUntilPageUrlContains("http://automationpractice.com/index.php?controller=authentication&back=my-account",10);
        return driver.getSeleniumWebDriver().getCurrentUrl();

    }

    public  void openSignInPage() {
        driver.waitVisibilityOf(signInTap.by(), 10);
        driver.clickOn(signInTap);

    }

    public  void createNewAccount() {
        driver.waitVisibilityOf(emailField.by(), 10);

        driver.sendKeysTo(emailField,"username1000"+ driver.randomIntger() +"@gmail.com");

        driver.clickOn(submitButton);
        driver.clickOn(genderRadioButton);
        driver.sendKeysTo(firstNameField,"Mostafa");
        driver.sendKeysTo(lastNameField,"Abotaleb");
        driver.sendKeysTo(passwordField,"123456");
        driver.selectByIndex(daysDropdown.by(),5);
        driver.selectByIndex(monthsDropdown.by(),6);
        driver.selectByValue(yearsDropdown.by(),"1987");
        driver.sendKeysTo(companyField,"Oncare");
        driver.sendKeysTo(addressField,"101 Manhattan New Yourk");
        driver.sendKeysTo(cityField,"Manhattan");
        driver.selectByValue(stateDropdown.by(),"32");
        driver.sendKeysTo(postcodeField,"12913");
        driver.selectByValue(countryDropdown.by(),"21");
        driver.sendKeysTo(mobilePhoneField,"0100002000023");
        driver.sendKeysTo(addressAliasField," in Manhattan");
        driver.clickOn(registerButton);

    }
}
