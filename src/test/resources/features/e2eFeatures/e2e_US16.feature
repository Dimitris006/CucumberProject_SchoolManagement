@E2E_US16
Feature:US16 The Vice Dean should be able to view the messages sent by users
  @US16_UI
  Scenario: Validate delete button on UI
    Given login as vice dean "Agent07" "11111111eW"
    And click Menu button
    And click Get All button
    Then Verify Delete button is visible
    Then verify message is visible
    Then verify Name is visible
    Then verify Email is visible
    Then verify Date is visible
    Then verify Subject is visible
    Then verify ability to delete messages

  @E2E_US16_API @Api_viceDean
  Scenario:Validate contactMessages is deleted on API
    Given send get request to get all messages
    Then validate ID, date, email , message, name, subject by API
    Then validate message is deleted

  @E2E_US16_DB
  Scenario Outline:Validate entered message on DB
    Given connect to DB
    When get message
    Then validate body contains date "<date>", email "<email>", message "<message>", name "<name>", subject "<subject>"
    Examples:
      |   date          | email           | message    | name           | subject|
      | 2023-09-23      | mnop@ukr.net    |That's it   | Irina          |DBtesting|
#  1260	23 сент. 2023 г., 00:00:00	mnop@ukr.net	That's it	Irina	DBtesting

  @E2E_US16_DB_Deleted @US16_DB
  Scenario: Validate deleted message on DB
    Given connect to DB
    When get message via non-existing name "XXXIrina"
    Then validate  if the message is deleted
    And close the connection for US16

