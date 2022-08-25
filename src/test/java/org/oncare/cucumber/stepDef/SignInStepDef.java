package org.oncare.cucumber.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.oncare.cucumber.runner.TestState;
import org.oncare.selenium.page.SignInPage;


public class SignInStepDef extends AbstractStepDef {
    public SignInStepDef(TestState state) {
        super(state, SignInStepDef.class.getName());
    }

        @Given("^open sign in page$")
        public void openSignInPage () throws Throwable {
            SignInPage signInPage = new SignInPage(state.getDriver());
            signInPage.openSignInPage();
        }

    @And("^the correct Url is loaded$")
    public void theCorrectURLIsLoaded() {
        SignInPage signInPage = new SignInPage(state.getDriver());
        Assert.assertEquals("Sign In page not opened", "http://automationpractice.com/index.php?controller=authentication&back=my-account", signInPage.getUrl());
    }

    @And("^create a new account$")
    public void createANewAccount() {
        SignInPage signInPage = new SignInPage(state.getDriver());
        signInPage.createNewAccount();

    }
}

