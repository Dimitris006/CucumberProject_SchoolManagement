@e2e_US25

Feature: Admin should be able to add a student

  @UI25
  Scenario: With_Valid_Credentials
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
    Then user sees title "Dean Management"
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    Then verify student created successfully confirmation message
    Then click last page button
    And verify student number created automatically
    Then close the application

  @US25_DB
  Scenario: Validate student added on database
    Given get Student Data by username
    Then validate Student data
    Then close the connection

  @US25_API @Api_admin
  Scenario: Validate student added on API
    Given send get All Student request on API
    Then filter Student Data using username and validate