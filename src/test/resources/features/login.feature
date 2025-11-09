Feature: Login functionality

  Background:
    Given I open the login page

  Scenario: Login with empty credentials
    When I enter "standard_user" into the username field
    And I enter "123" into the password field
    And I clear the username field
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Username is required"

  Scenario: Login with username but no password
    When I enter "standard_user" into the username field
    And I enter "123" into the password field
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Password is required"

  Scenario Outline: Login with valid credentials
    When I enter "<username>" into the username field
    And I enter "secret_sauce" into the password field
    And I click the login button
    Then I should see the header title "Swag Labs"

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | visual_user             |