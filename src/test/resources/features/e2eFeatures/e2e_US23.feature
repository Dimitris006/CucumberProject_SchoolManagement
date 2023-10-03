@e2e_US23
Feature: Admin should be able to create a vice dean


  @UI23
  Scenario:user register successfully
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
    And click menu button
    And click Vice Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter vicedean date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    And verify Vice Dean created successfully confirmation message
    Then close the application


  @US23_DB
  Scenario: Validate created dean on database
    Given connect to vicedean database
    Given get vicedean Data by username
    Then  validate vicedean created on db
    Then close the connection
#            Examples:
#      | username | birth_day  | birth_place | gender | name | phone_number | ssn         | surname |
#      | Wintheiser| 01 01 1001 | Izmir     | Female | Flavia | 257-418-4025 | 884-72-1449 | Wintheiser |



  @US23_API @Api_admin

    Scenario: Admin created vice dean on API
    Given send get All vice dean request on API
    Then validate that vicedean created




