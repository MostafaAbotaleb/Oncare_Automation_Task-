package org.oncare.cucumber.stepDef;

public class AccountStepDef extends AbstractStepDef {
    public AccountStepDef(TestState state) {
        super(state, AccountStepDef.class.getName());
    }
    @And("^the account page is loaded$")
    public void theAccountPageIsLoaded() {

    }
}
