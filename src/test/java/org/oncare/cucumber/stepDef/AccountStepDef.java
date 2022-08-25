package org.oncare.cucumber.stepDef;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.oncare.cucumber.runner.TestState;
import org.oncare.selenium.page.AccountPage;

public class AccountStepDef extends AbstractStepDef {
    public AccountStepDef(TestState state) {
        super(state, AccountStepDef.class.getName());
    }
    @And("^the account page is loaded$")
    public void theAccountPageIsLoaded() {
        AccountPage accountPage=new AccountPage(state.getDriver());

        Assert.assertEquals("My account page not opened","MY ACCOUNT",accountPage.vlidateMyAccountHeader());

    }

    @And("^open the dresses category$")
    public void openTheDressesCategory() {
        AccountPage accountPage=new AccountPage(state.getDriver());
        accountPage.clickOnDressesCategory();
        accountPage.vlidateDressesHeader();

    }
}
