package org.oncare.selenium.page;


import org.oncare.selenium.driver.CustomWebDriver;
import org.oncare.selenium.page.core.PageObject;

import static org.oncare.selenium.driver.CustomWebDriver.pro;
import static org.oncare.selenium.locator.DressesLocator.*;


public class DressesPage extends PageObject {


    public DressesPage(CustomWebDriver driver) {
        super(driver, DressesPage.class.getName());
    }




    public void selectDresses(String dressName)  {


        driver.waitVisibilityOf(orangeColor.by(), 10);

        driver.streamFilter(allProducts,allNamesOfProducts, dressName);
        pro.findElement(orangeColor.by()).click();
        pro.findElement(orangeColor.by()).click();
        driver.selectByIndex(sizesDropdown.by(),2);

        }



    public void addToTheCart(){
        driver.clickOn(addToCartButton);
    }


    public void proceedToCheckout() {

        driver.clickOn(proceedToCheckoutInThePopup);
        driver.clickOn(proceedToCheckout);
        driver.clickOn(proceedTocheckoutButton);
        driver.clickOn(agreeCheckbox);
        driver.clickOn(proceedToCheckoutAfterAgreeShipping);

    }

    public void chooseBankWireMethod() {
        driver.clickOn(payByBankWire);
    }

    public void confirmTheOrder() {
        driver.clickOn(confirmMyOrderButton);
    }

    public String getOrderConfirmationmessage() {

       return driver.getText(orderConfirmationmessage.by());
    }



    public void openTheOrderhistorypage() {
        driver.clickOn(myOrdersHistory);
    }

    public String getTheOrderstatus() {
        return driver.getText(orderStatus.by());
    }
}

