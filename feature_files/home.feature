@mobile @web @mobileweb @home
Feature: Home
  As an user
  I want to use Home
  In order to navigate main functions of app

  Scenario Outline: user can navigate to contributions or login gate
    Given user is on Home
    and user is authenticated
    When user selects contributions on Tab Bar
    Then user is on Contributions

  Scenario: user navigates to login gate via contributions
    Given user is on Home
    and user is not authenticated
    When user selects contributions on Tab Bar
    Then user is on Account Login
