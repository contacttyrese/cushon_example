package com.cushon.steps;

import com.google.inject.Inject;
import com.cushon.cushon.contracts.AccountLogin;
import io.cucumber.java8.En;

import static org.junit.Assert.*;

public class AccountLoginSteps implements En {

    @Inject
    private AccountLogin accountLogin;

    public AccountLoginSteps() {
        Then("^user is on Account Login$", () -> {
            String errMsg = "account login is not displayed";
            boolean actual = accountLogin.isDisplayed();
            assertTrue(errMsg, actual);
        });
    }

}
