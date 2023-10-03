@e2e_US04
Feature: Admin should be able to create a dean

  @UI04
  Scenario:user register successfully
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter dean date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    And verify dean created successfully confirmation message
    Then close the application


      @US04_DB
  Scenario: Validate created dean on database
        Given connect to dean database
        Given get dean Data by username
        Then  validate dean created on db
        Then close the connection
#            Examples:
#      | username | birth_day  | birth_place | gender | name | phone_number | ssn         | surname |
#      | Wintheiser| 01 01 1001 | Izmir     | Female | Flavia | 257-418-4025 | 884-72-1449 | Wintheiser |



  @US04_API @Api_admin
  Scenario: Admin created dean on API
    Given send get All dean request on API
    Then validate that dean created





