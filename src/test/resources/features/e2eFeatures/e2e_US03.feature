@E2E @US03_Api @Api_student
Feature: User should be able to send messages from contact page(Api)
  Scenario: Fill out and submit the contact form on API (PositiveScenario)
    When send post request to send message from contact page
    Then validate response data is the same with created user credentials

