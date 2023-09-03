package com.cushon.android.screens;

import com.google.inject.Inject;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ContributionsScreen implements Contributions {
    private AndroidDriver appiumDriver;
    private FluentWait<AndroidDriver> wait;

    private final String containerId = "contributionsConstraintLayout";
    private final String viewMonthlyContributionsButtonId = "viewMonthlyContributionsButton";
    private final String updateMonthlyContributionsButtonId = "updateMonthlyContributionsButton";
    private final String amountOrPercentFieldId = "amountOrPercentTextField";
    private final String poundsToggleId = "poundsToggle";
    private final String percentToggleId = "percentToggle";
    private final String submitButtonId = "submitButton";
    private final String monthlyContributionsId = "listItemMonthlyContribution";

    private WebElement container, viewMonthlyContributionsButton, updateMonthlyContributionsButton,
    amountOrPercentField, poundsToggle, percentToggle, submitButton,
    monthlyContributions;

    @Inject
    public ContributionsScreen(AppiumDriver appiumDriver, FluentWait wait) {
        this.appiumDriver = (AndroidDriver) appiumDriver;
        this.wait = wait;
    }

    @Override
    public boolean isDisplayed() {
        container = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(containerId)));
        return container.isDisplayed();
    }

    @Override
    public void selectViewMonthlyContributions() {
        viewMonthlyContributionsButton = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(viewMonthlyContributionsButtonId)));
        viewMonthlyContributionsButton.click();
    }

    @Override
    public void selectUpdateMonthlyContributions() {
        updateMonthlyContributionsButton = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(updateMonthlyContributionsButtonId)));
        updateMonthlyContributionsButton.click();
    }

    @Override
    public void enterAmountOrPercent(int amountOrPercent) {
        amountOrPercentField = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(amountOrPercentFieldId)));
        amountOrPercentField.sendKeys(amountOrPercent);
    }

    @Override
    public void selectPoundsToggle() {
        poundsToggle = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(poundsToggleId)));
        poundsToggle.click();
    }

    @Override
    public void selectPercentToggle() {
        percentToggle = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(percentToggleId)));
        percentToggle.click();
    }

    @Override
    public void selectSubmit() {
        submitButton = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(submitButtonId))).click();
        submitButton.click();
    }

    @Override
    public boolean areMonthlyContributionsDisplayed() {
        monthlyContributions = wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(monthlyContributionsId)));
        return monthlyContributions.isDisplayed();
    }
}
