@E2E @US21_Api
Feature: student choose lesson from management panel(Api)
  Background:Go_to_Homepage
    Given user navigates to "https://managementonschools.com"
    And user clicks on login link
    And user enters username "samcarter"
    And user enters password "Abc12345"
    And user clicks on login button

 @US21_Api @Api_student
  Scenario: Validate chosen lessons on API (PositiveScenario)
    When send post request to select a lesson from lessons page
    Then validate lesson is added to list or error message about double booking

  @US21_DB
  Scenario Outline:Validate selected lesson on database
    Given connect to Data Base
    When get selected course via student name "<name>"
    Then validate course lesson title "<lesson_name>" day "<day>" start_time "<start_time>" stop_time "<stop_time>"
    And close the connection to DB
    Examples:
      | lesson_name | day    | start_time | stop_time |
      | Physics     | FRIDAY | 12:00:00   | 13:00:00  |