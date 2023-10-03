@e2e_US13
Feature: Vice Deans should be able to create a teacher
  @US13_UI
  Scenario: With_Valid_Credentials
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "Agent07"
    And user enters password "11111111eW"
    And user clicks on login button
    And click menu button
    And click TeacherManagementLink
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

    @US13_DB
    Scenario: Validate created teacher on database
      Given connect to DataBase
      When get teacher user via username "<username>"
      Then validate the credentials for teacher
      And close the connection on dataBase

      @US13_API @Api_viceDean
      Scenario: Validate created teacher on API
        Given create teacher with post request save
        Then validate with get request that teacher is created





