@e2e_US10
Feature:  Vice Deans should be able to create a lesson schedule
  @UI10
Scenario: With_Valid_Credentials
    Given login as vice dean "ViceDeanEmilly" "ViceDeanEmilly123"
    And click menu button
    And click lesson management
    And click lesson program
    And choose Lesson EmillyLesson
    And choose education term
    And chose day
    And choose start time
    And choose stop time
    And click submit button on Add Lesson Program
    Then verify lesson is created
  @US10_API @Api_viceDean
    Scenario: Validate created lesson program
    Given Send get all lesson program request on API
    Then filter lessons programs by id and verify













