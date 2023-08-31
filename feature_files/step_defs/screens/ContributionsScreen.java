package com.cushon.screens;

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

    @Inject
    public ContributionsScreen(AppiumDriver appiumDriver, FluentWait wait) {
        this.appiumDriver = (AndroidDriver) appiumDriver;
        this.wait = wait;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(containerId)).isDisplayed());
    }

    @Override
    public void selectViewMonthlyContributions() {
        wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(viewMonthlyContributionsButtonId))).click();
    }

    @Override
    public void selectUpdateMonthlyContributions() {
        wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(updateMonthlyContributionsButtonId))).click();
    }

    @Override
    public void enterAmountOrPercent(int amountOrPercent) {
        wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(amountOrPercentFieldId))).sendKeys(amountOrPercent);
    }

    @Override
    public void selectPoundsToggle() {
        wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(poundsToggleId))).click();
    }

    @Override
    public void selectPercentToggle() {
        wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(percentToggleId))).click();
    }

    @Override
    public void selectSubmit() {
        wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(submitButtonId))).click();
    }

    @Override
    public boolean areMonthlyContributionsDisplayed() {
        return wait.until(mobileDriver ->
            mobileDriver.findElement(AppiumBy.id(monthlyContributionsId)).isDisplayed());
    }
}
