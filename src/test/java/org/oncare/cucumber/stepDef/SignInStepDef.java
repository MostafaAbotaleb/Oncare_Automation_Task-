package org.oncare.cucumber.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.oncare.cucumber.runner.TestState;
import org.oncare.selenium.page.SignInPage;


public class SignInStepDef extends AbstractStepDef {
    public SignInStepDef(TestState state) {
        super(state, SignInStepDef.class.getName());
    }

    @Given("^open sign in page$")
    public void openSignInPage() throws Throwable {
        SignInPage signInPage = new SignInPage(state.getDriver());
        signInPage.openSignInPage();
    }

    @And("^the correct Url is loaded$")
    public void theCorrectURLIsLoaded() {
        SignInPage signInPage = new SignInPage(state.getDriver());
        Assert.assertEquals("Sign In page not opened", "http://automationpractice.com/index.php?controller=authentication&back=my-account", signInPage.getUrl());


    }


    @And("^create a new account$")
    public void createANewAccountName(DataTable table) {
        SignInPage signInPage = new SignInPage(state.getDriver());
        table.asMap(String.class, String.class).forEach((field, value) -> {
            try {
                signInPage.typeText(field, value);

            } catch (Throwable e) {
                e.printStackTrace();
            }

        });

        signInPage.typeIntFields("5","6","1987","32","21");
    }
    @And("using random email {string} to create a new account")
    public void usingEmailToCreateANewAccount(String email) {
        SignInPage signInPage = new SignInPage(state.getDriver());
        signInPage.typeRandomEmail(email);
    }


}





