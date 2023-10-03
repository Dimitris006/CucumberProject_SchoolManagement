
@US25
Feature: Admin should be able to create a student

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
    Then user sees title "Dean Management"
  @US25_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    Then verify student created successfully confirmation message
    Then click last page button
    And verify student number created automatically
    Then close the application



  @US25_TC02
  Scenario: Name_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    #And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    Then verify submit fails

  @US25_TC03
  Scenario: Surname_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    #And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC04
  Scenario: Birth_Place_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    #And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC05
  Scenario: Email_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    #And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC06
  Scenario: AdvisorTeacher_Not_Chosen
    And click menu button
    And click Student Management Link
    #And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails with error message

  @US25_TC07
  Scenario: Phone_Number_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    #And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC08
  Scenario: Username_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    #And enter student username
    And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC09
  Scenario: Father_Name_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    #And enter father name
    And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC10
  Scenario: Mother_Name_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    #And enter mother name
    And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC11
  Scenario: Password_Field_Left_Empty
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    #And enter password
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC12
  Scenario: Invalid_Password_Without_Numbers
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password without numbers
    Then password without numbers error message appears
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC13
  Scenario: Invalid_Password_Without_Uppercase
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password without uppercase chars
    Then password without uppercase error message appears
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC14
  Scenario: Invalid_Password_Without_Lowercase
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password without lowercase chars
    Then password without lowercase error message appears
    And click submit button
    And click submit button
    Then verify submit fails

  @US25_TC15
  Scenario: Invalid_Password_Less_Then_8_Character
    And click menu button
    And click Student Management Link
    And choose Advisor Teacher
    And enter Name
    And enter Surname
    And enter Birth Place
    And enter email
    And select Male Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter student username
    And enter father name
    And enter mother name
    And enter password with only seven chars
    Then password less then 8 character error message appears
    And click submit button
    And click submit button
    Then verify submit fails