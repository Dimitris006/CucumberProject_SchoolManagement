@US_02
Feature:Admin should be able to see the Guest User List

  @Guest_UserRegistration
  Scenario: GuestUser register successfully
    Given user navigate to Url "https://managementonschools.com/"
    And user click on register link
    And user enter name "Sanam"
    And user enter surname "<Sabah>"
    And user enter birthplace "Kalamata"
    And enter valid Tel number
    And user click on radio button
    And user enters date of birth "05/04/2014"
    And enters valid SSN
    And user enter user name "<sanamsabah>"
    And enters password "Sanam1234@"
    And user click on register button

  @UI_Test_guest_user
  Scenario:Admin should be able to see Name, Phone Number, SSN and User Name information in the guest user list
    Given user navigates to the Web "https://managementonschools.com"
    Given user clicks on the signin link
    And user send the username
    And user send the password
    And user click on singin button
    And user click on the menu button
    And user click on the guest user
    Then user verify to see the guest user

  @Api_Test @Api_admin
  Scenario Outline: Validate to see guest user on API
    Given send get request to get all guest users
    Then validate  username "<username>" name "<name>" phone_number "<phone_number>"  ssn "<ssn>"  by API
    Examples:
      | username |    name | phone_number | ssn         |
      | sanamsabah  | Sanam | 334-999-4433 | 444-55-8888|

  @Api_Test_Deleted @Api_Test @Api_admin
  Scenario: Validate deleted user on API
    Given send get request to get all guest users
    Then validate user "sanamsabah" is deleted