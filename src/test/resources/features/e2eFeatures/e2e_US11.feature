@E2E_US11
Feature:US11 Vice Deans should be able to view the lesson schedule and make updates
    (Lesson Program - Lesson Program List)

    @US11_UI
    Scenario: With_Valid_Credentials on UI
      Given login as vice dean "Agent07" "11111111eW"
      When Management page loads up
      Then click Lesson Program
      Then scroll down until see Lesson Program
      Then verify Lesson, Day, Start Time and Stop Time created are visible
      And verify update Button exists
      Then scroll down until see Lesson Program
      And verify update Button exists
      Then verify Delete button is visible
      Then scroll down until see Lesson Program
      Then verify Delete button is visible
  @US11_API @Api_viceDean
    Scenario: With_Valid_Credentials on API
    When send getAll request for lesson Program
    Then validate that response data includes the lesson program
    When send post request for lesson program
    Then send delete request for deleting lesson Program


