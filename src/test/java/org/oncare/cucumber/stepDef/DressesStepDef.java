package org.oncare.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.oncare.cucumber.runner.TestState;
import org.oncare.selenium.page.DressesPage;
import org.junit.Assert;



public class DressesStepDef extends AbstractStepDef {
    public DressesStepDef(TestState state) {
        super(state, DressesStepDef.class.getName());
    }


    @And("select a dress name {string}")
    public void selectADress(String dressName) {

        DressesPage dressesPage= new DressesPage(state.getDriver());
        dressesPage.selectDresses(dressName);

    }

    @And("^add to the cart$")
    public void addToTheCart() {
        DressesPage dressesPage= new DressesPage(state.getDriver());
        dressesPage.addToTheCart();

    }

    @And("^proceed to checkout$")
    public void proceedToCheckout() {
        DressesPage dressesPage= new DressesPage(state.getDriver());
        dressesPage.proceedToCheckout();
    }

    @And("^choose the payment$")
    public void chooseThePayment() {
        DressesPage dressesPage= new DressesPage(state.getDriver());
        dressesPage.chooseBankWireMethod();
    }

    @When("^confirm the order$")
    public void confirmTheOrder() {
        DressesPage dressesPage= new DressesPage(state.getDriver());
        dressesPage.confirmTheOrder();
    }

    @Then("^the order request is completed$")
    public void theOrderRequestIsCompleted() {
        DressesPage dressesPage= new DressesPage(state.getDriver());
        Assert.assertEquals("the order confirmation message is not appear","Your order on My Store is complete.",dressesPage.getOrderConfirmationmessage());


    }

    @And("^the same order placed in the history order page$")
    public void theSameOrderPlacedInTheHistoryOrderPage() {
        DressesPage dressesPage= new DressesPage(state.getDriver());
        dressesPage.openTheOrderhistorypage();
        Assert.assertEquals("there is no order on backorder","On backorder",dressesPage.getTheOrderstatus());


    }


}
