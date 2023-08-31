package com.cushon.steps;

import com.google.inject.Inject;
import com.cushon.cushon.contracts.Home;
import io.cucumber.java8.En;

import static org.junit.Assert.*;

public class HomeSteps implements En {

    @Inject
    private Home home;

    public HomeSteps() {
        Given("^user is on Home$", () -> {
            String errMsg = "home is not displayed";
            boolean actual = home.isDisplayed();
            assertTrue(errMsg, actual);
        });

        When("^user (is|is not) authenticated$", (String isOrIsNot) -> {
            String errMsg = "user " + isOrIsNot + " authenticated"
            boolean actual = home.isUserAuthenticated();
            if (isOrIsNot.equalsIgnorecase("is")) {
                assertTrue(errMsg, actual);
            } else if (isOrIsNot.equalsIgnorecase("is not")) {
                assertFalse(errMsg, actual);
            }
        });

        When("^user allows permission on login screen$", () -> {
            login.allowPermissionForFiles();
        });

        When("^user selects sign in on login screen$", () -> {
            login.selectSignIn();
        });

        Then("^Google sign in screen is displayed$", () -> {
            String errMsg = "Google sign in did not display";
            boolean actual = login.isGoogleSignInVisible();
            assertTrue(errMsg, actual);
        });

        Then("^Google select account screen is displayed$", () -> {
            String errMsg = "Google select account(s) did not display";
            boolean actual = login.isGoogleSelectVisible();
            assertTrue(errMsg, actual);
        });

    }

}
