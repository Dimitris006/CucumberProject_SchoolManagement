@E2E @US14_Api
Feature: Vice Dean should be able to see and update teachers.

  Background:
    Given login as vice dean is authorized on api

  @Api_US14_TC01-02 @Api_viceDean
  Scenario: The Name, Phone Number, SSN, and User Name information of the created teacher should be visible for Vice Dean.
    Then create teacher with valid information
    And confirm that the teacher information is accessible in api
    And update the teacher information