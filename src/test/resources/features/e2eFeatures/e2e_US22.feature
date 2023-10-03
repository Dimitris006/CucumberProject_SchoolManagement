@E2E_US22
Feature: Admins should be able to be registered in the system

  @US22_TC01
  Scenario: With_Valid_Credentials
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "TestOfMyUS"
    And user enters password "TestTest2"
    And user clicks on login button
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter your date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify Admin created successfully confirmation message
    Then close the application

  @Database_Test
  Scenario: Validate registered user on database
#    Given connect to database
    When get admin user via username
    Then validate username name phone_number ssn surname birth_place date_of_birth password
#    And close the connection

  @US22_API @Api_admin
  Scenario: Validate created admin on API
    Given send get All Admin request on API
    Then validate admin data

  @US22_API @Api_admin
  Scenario: Delete admin data and validate it on API
    Given send get All Admin request on API
    Then get adminID from API
    Then delete admin using adminID
    And validate admin data deleted