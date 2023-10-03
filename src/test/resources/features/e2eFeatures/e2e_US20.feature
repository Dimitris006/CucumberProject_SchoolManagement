@E2E
Feature: The teacher should be able to create meetings with students feature


  @UI_TC01
  Scenario: The Date, Start Time, Stop Time and Description of the meetings should be visible to the teacher
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "Anna"
    And user enters password "Anna123@"
    And user clicks on login button
    And click menu button
    And click Meet Management button
    And select Student
    And select Date Of Meeting
    And enter Start Time
    And enter Stop Time
    And enter Description of meet
    And click submit button
    And Verify the date is visible
    And Verify the start time is visible
    And Verify the stop time is visible
    And Verify the description is visible

  @API_TC01 @Api_Annateacher
  Scenario Outline:
   # Given send post request meet
    Given send get request to get meet via id
    Then validate  description "<description>" date "<date>" start_time "<start_time>"   stop_time "<stop_time>" by Api
    Then validate created message is seen
    Examples:
      | description   | date       | start_time | stop_time |
      | Test Results2 | 2025-01-01 | 10:00:00   | 10:20:00  |


  @DB_TC01
  Scenario Outline: validate created meeting
    Given connect to database
    When get meeting via description "<description>"
    Then validate  description "<description>" date "<date>" start_time "<start_time>"   stop_time "<stop_time>"
    And close the connection
    Examples:
      | description      | date                         | start_time              | stop_time                |
      | rehberlk         | 2023-10-10                   | 08:20:00                | 09:20:00                 |




  @UI_TC02
  Scenario: Teacher can update meet
    And click on edit button
    And update description
    And user click on submit button
    And Verify meet is successfully updated

  @API_TC02 @Api_Annateacher
  Scenario Outline:
    Given send put request to get meet via id
    Then validate  description "<description>" by Api
    Then validate updated message is seen

    Examples:
      | description   | date       | start_time | stop_time |
      | Test Results3 | 2025-01-01 | 10:00:00   | 10:20:00  |

  @DB_TC02
  Scenario Outline: validate created meeting updated
    Given connect to database
    When get updated meeting via description "<description>"
    Then validate  updateddescription "<description>"
    And close the connection
    Examples:
      | description         | date                        | start_time             | stop_time |
      | Toplanti updated    | 2025-01-01                  | 10:00:00                | 11:00:00  |

  @UI_TC03
  Scenario: Teacher can delete meet
    And click on delete button
    And Verify meet is successfully deleted

#  @API_TC03 @Api_Annateacher
#  Scenario: Delete
#    Given send delete request to delete meet
#    Then validate  meet is deleted



  @DB_TC03
  Scenario Outline: validate created meeting updated
    Given connect to database
    When get deleted meeting via description "<description>"
    Then validate  there is such meeting description  "<description>"
    And close the connection
    Examples:
      | description         | date                        | start_time             | stop_time |
      | Delete meeting      | 2023-12-14                  | 11:00:00                | 11:20:00  |



