@E2E_US01
Feature:Prospective students should be able to register in the system

  @UI_Guest
  Scenario Outline: user register successfully
    Given user navigates to "https://managementonschools.com/"
    And user clicks on register link
    And user enters name "Anna"
    And user enters surname "<surname>"
    And user enters birthplace "San Antonio"
    And enter valid phone number
    And user clicks on radio button
    And user enter date of birth "01/01/2000"
    And enter valid SSN
    And user enters user name "<username>"
    And user enters password "Anna1234&"
    And user clicks on register button
    Then verify Guest User registered alert is seen

    Examples: test_data
      | name | surname    | birth_place      | phone_number  | date_of_birth | ssn_number  | username | password  |
      | Anna | Silver     | San Antonio      | 123-321-1243  | 01/01/2000    | 187-89-9765 | Anna     | Anna2323! |


  @DB_Guest
  Scenario Outline: validate registered user on database
    Given connect to database
    When get guest user via username "<username>"
    Then validate  username "<username>" date_of_birth "<date_of_birth>"   birth_place "<birth_place>"   name "<name>" phone_number "<phone_number>"  ssn_number "<ssn_number>" surname "<surname>"
    And close the connection
    Examples:
#      | username | date_of_birth | birth_place | name | phone_number | ssn_number  | surname    |
#      | Blondell | 2000-01-01    | San Antonio | Anna | 193-668-7626 | 874-63-7767 | Antoinette |
      | username | date_of_birth | birth_place | name | phone_number | ssn_number  | surname |
      | Raven    | 2000-01-01    | San Antonio | Anna | 522-463-4918 | 380-19-2132 | Timmy   |

  @API_US01 @Api_admin
  Scenario Outline: Validate registered user on API
    Given send get request to get all guest users
    Then validate  username "<username>" date_of_birth "<date_of_birth>"   birth_place "<birth_place>"   name "<name>" phone_number "<phone_number>"  ssn_number "<ssn_number>" surname "<surname>" by API
    Examples:
      | username | date_of_birth | birth_place | name | phone_number | ssn_number  | surname |
      | Raven    | 2000-01-01    | San Antonio | Anna | 522-463-4918 | 380-19-2132 | Timmy   |


