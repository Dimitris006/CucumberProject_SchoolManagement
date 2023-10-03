@e2e_US15
Feature: Vice Deans should be able to create a student
  @UI15
  Scenario: With_Valid_Credentials
    Given user navigates to
    And user clicks on login link
    And user enters username "Agent07"
    And user enters password "11111111eW"
    And user clicks on login button
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

  @US15_DB
  Scenario: Validate created student on database
    Given get Student Data by username
    Then validate Student data
    Then close the connection

  @US15_API @Api_viceDean
  Scenario: Validate created student on API
    Given send get All Student request on API
    Then filter Student Data using username and validate

  @US15_API_delete @Api_viceDean
  Scenario: Delete student data and validate it on API
    Given send get All Student request on API
    Then get studentID from API
    Then delete student using studentID
    And validate student data deleted