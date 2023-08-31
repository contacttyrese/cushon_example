@mobile @web @mobileweb @contributions
Feature: Contributions
  As an authenticated user
  I want to use Contributions
  In order to view and update monthly contributions

  Scenario: user can view monthly contributions
    Given user is on Contributions
    When user selects view monthly contributions
    Then monthly contributions are displayed

  Scenario: user can update monthly contribution with exact amount
    Given user is on Contributions
    When user selects update monthly contributions
    And user submits 15 pounds on Contributions Update
    Then user is on Contributions Update Confirmation
    And new amount is displayed on Contributions Update Confirmation

  Scenario: user can update monthly contribution with percentage
    Given user is on Contributions
    When user selects update monthly contributions
    And user submits 20 percent on Contributions Update
    Then user is on Contributions Update Confirmation
    And new percentage is displayed on Contributions Update Confirmation

    @android
  Scenario Outline: user can update monthly contribution with amount or percent
    Given user is on Contributions
    When user selects update monthly contributions
    And user submits <contribution_update> <contribution_type> on Contributions Update
    Then user is on Contributions Update Confirmation
    And <new_update> is displayed on Contributions Update Confirmation

    Examples:
    | contribution_amount | contribution_type | new_update |
    | 15                  | pounds            | amount     |
    | 20                  | percent           | percentage |
