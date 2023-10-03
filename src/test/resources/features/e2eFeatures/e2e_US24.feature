@e2e_US24
Feature: Admin should be able to create a teacher
  @US24_UI
  Scenario: With_Valid_Credentials
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
    And click menu button
    And click TeacherManagementLink
    And select lesson
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

  @US24_DB
 Scenario: Validate created teacher on database
    Given connect to DataBase
   When get teacher user via username "<username>"
    Then validate the credentials for teacher
   And close the connection

  @US24_API @Api_admin
  Scenario: Validate created teacher on API
    Given create teacher with post request save
    Then validate with get request that teacher is created


