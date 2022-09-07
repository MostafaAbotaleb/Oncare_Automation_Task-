package org.oncare.selenium.page;


import org.oncare.selenium.driver.CustomWebDriver;
import org.oncare.selenium.locator.core.Locator;
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

    public void typeRandomEmail(String email){
        driver.waitVisibilityOf(emailField.by(), 10);

        driver.sendKeysTo(emailField,email+ driver.randomIntger() );
        driver.clickOn(submitButton);
        driver.clickOn(genderRadioButton);

    }
    public void typeText(String field, String value) throws Throwable {

        Locator locator;

        switch (field.toLowerCase()) {
            case "name":
                locator = firstNameField;
                break;
            case "lastname":
                locator = lastNameField;
                break;
            case "password":
                locator = passwordField;
                break;
            case "company":
                locator = companyField;
                break;
            case "address":
                locator = addressField;
                break;
            case "city":
                locator = cityField;
                break;

            case "postcode":
                locator = postcodeField;
                break;

            case "mobile":
                locator = mobilePhoneField;
                break;
            case "addressalias":
                locator = addressAliasField;
                break;
            default:
                throw new Exception("Unknown field " + field);
        }
        driver.waitVisibilityOf(locator, 10);
        driver.sendKeysTo(locator, value);

    }


    public void typeIntFields (String day,String month,String year,String state, String country)  {
        driver.selectByValue(daysDropdown.by(),day);
        driver.selectByValue(monthsDropdown.by(),month);
        driver.selectByValue(yearsDropdown.by(),year);
        driver.selectByValue(stateDropdown.by(),state);
        driver.selectByValue(countryDropdown.by(),country);
        driver.clickOn(registerButton);

    }
}

