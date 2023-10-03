@US24
Feature: Admin should be able to create a teacher

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
  @US24_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Teacher Management Link
    And select lesson from choose lesson
    And enter Teacher Name
    And enter Teacher Surname
    And enter Teacher Birth Place
    And enter Teacher email
    And enter Teacher valid phone number
    And select teacher has advisory role
    And select Teacher Male Gender
    Then enter Teacher date of birth
    And enter Teacher valid SSN
    And enter username for teacher
    And enter password
    And click submit button
    And verify teacher created successfully confirmation message

    @US24_TC02
    Scenario: Invalid Password
      And click menu button
      And click Teacher Management Link
      And select lesson from choose lesson
      And enter Teacher Name
      And enter Teacher Surname
      And enter Teacher Birth Place
      And enter Teacher email
      And enter Teacher valid phone number
      And select teacher has advisory role
      And select Teacher Male Gender
      Then enter Teacher date of birth
      And enter Teacher valid SSN
      And enter username for teacher
      And enter Invalid Password
      And click submit button
      Then verify passwordWithoutUpperCaseErrorMessage

      @US24_TC03
      Scenario: Missing Email
        And click menu button
        And click Teacher Management Link
        And select lesson from choose lesson
        And enter Teacher Name
        And enter Teacher Surname
        And enter Teacher Birth Place
       # And enter Teacher email
        And enter Teacher valid phone number
        And select teacher has advisory role
        And select Teacher Male Gender
        Then enter Teacher date of birth
        And enter Teacher valid SSN
        And enter username for teacher
        And enter password
        And click submit button
        Then verify the required message is visible





