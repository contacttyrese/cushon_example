package com.cushon.steps;

import com.google.inject.Inject;
import com.cushon.cushon.contracts.Contributions;
import com.cushon.cushon.contracts.ContributionsUpdateConfirmation;
import io.cucumber.java8.En;

import static org.junit.Assert.*;

public class ContributionsSteps implements En {
    private int savedAmountOrPercent = 0;

    @Inject
    private Contributions contributions;

    @Inject
    private ContributionsUpdateConfirmation contributionsUpdateConfirmation;

    public ContributionsSteps() {
        Given("^user is on Contributions$", () -> {
            String errMsg = "contributions is not displayed";
            boolean actual = contributions.isDisplayed();
            assertTrue(errMsg, actual);
        });

        When("^user selects view monthly contributions$", () -> {
            contributions.selectViewMonthlyContributions();
        });

        When("^user selects update monthly contributions$", () -> {
            contributions.selectUpdateMonthlyContributions();
        });

        When("^user submits (\\d+) (pounds|percent) on Contributions Update$", (int amountOrPercent, String poundsOrPercent) -> {
            contributions.enterAmountOrPercent(amountOrPercent);
            savedAmountOrPercent = amountOrPercent;
            if (poundsOrPercent.equalsIgnorecase("pounds")) {
                contributions.selectPoundsToggle();
            } else if (poundsOrPercent.equalIgnoreCase("percent")) {
                contributions.selectPercentToggle();
            }
            contributions.selectSubmit();
        });

        Then("^monthly contributions are displayed$", () -> {
            String errMsg = "monthly contributions are not displayed";
            boolean actual = contributions.areMonthlyContributionsDisplayed();
            assertTrue(errMsg, actual);
        });

        Then("^user is on Contributions Update Confirmation$", () -> {
            String errMsg = "contribution update confirmation did not display";
            boolean actual = contributionsUpdateConfirmation.isDisplayed();
            assertTrue(errMsg, actual);
        });

        Then("^new (amount|percentage) is displayed on Contributions Update Confirmation$", (String amountOrPercent) -> {
            String errMsg = "new " + amountOrPercent + " did not display in confirmation message";
            boolean actual = contributionsUpdateConfirmation.isSavedAmountOrPercentageDisplayedInConfirmationMessage(savedAmountOrPercent);
            assertTrue(errMsg, actual);
        });
    }

}
