@US04
Feature: Admin should be able to create a dean

  Background: go_homepage_and_login
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "AdminProjectDot"
    And user enters password "Project11+"
    And user clicks on login button
  @US04_TC01
  Scenario: With_Valid_Credentials
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    And verify dean created successfully confirmation message

  @US04_TC02
  Scenario: Name_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails


  @US04_TC03
  Scenario: SurName_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC04
  Scenario: Birth_Place_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC05
  Scenario: Female_Gender_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC06
  Scenario: date_of_birth_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter SurName
    And enter Birth Place
    And select Female Gender
    And enter valid phone number
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC07
  Scenario: valid_phone_number_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid SSN
    And enter username
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC08
  Scenario: valid_SSN_number_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter username
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC09
  Scenario: valid_user_name_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter password
    And click submit button
    Then verify submit fails

  @US04_TC10
  Scenario: valid_SSN_number_Field_Left_Empty
    And click menu button
    And click Dean Management Link
    And enter Name
    And enter Surname
    And enter Birth Place
    And select Female Gender
    Then enter date of birth
    And enter valid phone number
    And enter valid SSN
    And enter username
    And click submit button
    Then verify submit fails

