package org.oncare.selenium.locator;


import org.apache.log4j.Logger;
import org.oncare.selenium.locator.core.Locator;
import org.openqa.selenium.By;

public enum DressesLocator implements Locator {


    headerOfDresses(By.cssSelector("h2[class='title_block']")),
    productNameClass(By.cssSelector("a[class='product-name']")),
    printedSummerDress(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/h5[1]")),
    orangeColor(By.id("color_21")),
    sizesDropdown(By.cssSelector("select[id='group_1']")),
    addToCartButton(By.id("add_to_cart")),
    successfulMessage(By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6']")),
    proceedToCheckoutInThePopup(By.cssSelector("a[title='Proceed to checkout']")),
    proceedToCheckout(By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']")),
    proceedTocheckoutButton(By.cssSelector("button[name='processAddress']")),
    agreeCheckbox(By.id("uniform-cgv")),
    proceedToCheckoutAfterAgreeShipping(By.cssSelector("button[name='processCarrier']")),
    payByBankWire(By.cssSelector("a[class='bankwire']")),
    confirmMyOrderButton(By.cssSelector("button[class='button btn btn-default button-medium']")),
    orderConfirmationmessage(By.cssSelector("p[class='cheque-indent']")),
    boxOfOrederDetails(By.xpath("//*[@id='center_column']/div")),
    myOrdersHistory(By.cssSelector("a[title='My orders']")),
    orderStatus(By.cssSelector("td[class='history_state']"));






    static Logger logger = Logger.getLogger(DressesLocator.class.getName());
    private By locator;

    DressesLocator(By locator) {
        this.locator = locator;
    }

//    @Override
    public By by() {
        logger.trace("locator");
        return locator;
    }
}
