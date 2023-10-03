@US10
Feature: Vice Deans should be able to create a lesson schedule


  Background:

    Given login as vice dean "ViceDeanEmilly" "ViceDeanEmilly123"

  @US10_TC01
  Scenario: With Valid Credentials
    And click menu button
    And click lesson management
    And click lesson program
    And choose Lesson
    And choose education term
    And chose day
    And choose start time
    And choose stop time
    And click submit button on Add Lesson Program
    Then verify lesson is created

    @US10_TC02
    Scenario: Start and Stop time field blanck
      And click menu button
      And click lesson management
      And click lesson program
      And choose Lesson
      And choose education term
      And chose day
     # And choose start time
    #  And choose stop time
      And click submit button on Add Lesson Program
      Then verify the required message is visible

      @US10_TC03
      Scenario: Multiple lessons
        And click menu button
        And click lesson management
        And click lesson program
        And choose multiple lessons
        And choose education term
        And chose day
      And choose start time
      And choose stop time
        And click submit button on Add Lesson Program





