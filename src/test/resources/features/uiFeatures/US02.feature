
@US02
Feature: f

  Background:
  Given user goes to url
  @US02_TC01
  Scenario: s1
    When User clicks on the login link
    And User sends the user name
    And User sends the password
    And User clicks on the login button
    Then Verify if the user logged in

  @US02_TC02
  Scenario: s2
    When User clicks on the login link
    And User sends the user name
    And User sends the password
    And User clicks on the login button
    When Click on the Menu Button
    And Open the Main menu
    And Click on the Guest User
    And Open the Guest user List
    And Click on Delete button
    Then Verify if the user is deleted

