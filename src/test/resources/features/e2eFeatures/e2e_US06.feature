@e2e_US06
Feature: Deans should be able to create a Vice Dean account

  @UI06
  Scenario: With_Valid_Credentials
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "DeSouza"
    And user enters password "DeSouza25"
    And user clicks on login button
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Male Gender
    Then enter date of Birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify Vice Dean is created successfully confirmation message
    Then close the application

  @US06_DB
  Scenario: Validate created vice_dean on database
    Given get Vice_Dean Data by username
    Then validate  Vice_Dean on database
    And close the database connection

  @US06_API @Api_dean
  Scenario: Validate created vice_dean on API
    Given send get ViceDean request on API
    Then filter ViceDean Data using username and validate

  @US06_API @Api_dean
  Scenario: Admin should be able to delete information of Vice Dean List
    Given send A  ViceDean Delete request with username on API
    Then body must be empty with non existing username

