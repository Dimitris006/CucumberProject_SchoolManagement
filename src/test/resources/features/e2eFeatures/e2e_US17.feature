@US_DB_17
Feature: giving grades to the student
  @UI_Test
  Scenario: Signing at Student info
    Given user navigate to "https://managementonschools.com"
    Given click on Login link
    And user enter username "philips"
    And user enter password "Philips#5678"
    And user clicks on login button on login button
    And user clicks Menu button
    And user selects student info management
    And user chooses the lesson Lesson
    And user chooses the student student
    And user chooses education term
    And user enter Absentee
    And user enter Midterm exam grade
    And user enter final exam grade
    And user enter info note
    And user clicks on submit buttons
    Then verify student info saved successfully

  @Database_Test
  Scenario Outline: Validate adding info to the student on Database
    Given connect to the database
    When get student_info via username "<username>"
    Then validate Lesson "<Lesson>" Student "<Student>" Education_Term "<Education_Term>" absentee "<absentee>" midterm_exam "<midterm_exam>" final_exam "<final_exam>" info_note "<info_note>"
    And closes the connection
    Examples:
      | username | Lesson | Student   | Education_Term  | absentee | midterm_exam | final_exam |    info_note     |
      | philips | Cypress | Adil Sert | SPRING_SEMESTER |    17    |      90      |      93    | Completed lesson |


  @Api_Test @Api_teacher
  Scenario: Validate adding Info to the student on API
     Given send get request to get student info
     Then Assert teacher can see all student info










