package org.oncare.selenium.locator;


import org.apache.log4j.Logger;
import org.oncare.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum SignInLocator implements Locator {
    signInTap(By.xpath("//a[@ class='login']")),
    emailField(By.id("email_create")),
    submitButton(By.xpath("//button[@ name='SubmitCreate']")),
    genderRadioButton(By.id("id_gender1")),
    firstNameField(By.id("customer_firstname")),
    lastNameField(By.id("customer_lastname")),
    passwordField(By.id("passwd")),
    daysDropdown(By.id("days")),
    monthsDropdown(By.id("months")),
    yearsDropdown(By.id("years")),
    companyField(By.id("company")),
    addressField(By.id("address1")),
    cityField(By.id("city")),
    stateDropdown(By.id("id_state")),
    postcodeField(By.id("postcode")),
    countryDropdown(By.id("id_country")),
    mobilePhoneField(By.id("phone_mobile")),
    addressAliasField(By.id("alias")),
    registerButton(By.id("submitAccount")),
    dressesTab(By.xpath("//a[@title='Dresses']"));





    static Logger logger = Logger.getLogger(SignInLocator.class.getName());
    private By locator;

    SignInLocator(By locator) {
        this.locator = locator;
    }

//    @Override
//    @Override2
//    @Override3
//    @Override5
    public By by() {
        logger.trace("locator");
        return locator;
    }
}
