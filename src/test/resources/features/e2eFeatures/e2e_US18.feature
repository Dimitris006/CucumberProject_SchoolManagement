@E2E @US18_Api
Feature: The teacher should be able to view and update the grades given to the student.(Student Info List)

  @Api_US18_TC01-03 @Api_dunkTeacher
  Scenario: In the Student Info List; Name, Lesson Name, Absentee, Midterm and Final Exam, Note, Info Note and Average information should be visible.
    Given logged in as Dunk teacher, get all student information
    Then assert the information is correct
    And teacher should be able to update student information
    And teacher should be able to delete student information

  @Db_US18
  Scenario: Teacher is able to view student information in database
    Given teacher is able to view all student information on database
    And teacher can search students by id