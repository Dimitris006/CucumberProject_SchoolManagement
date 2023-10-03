@E2E_US05
Feature: Admins should be able to see and update Deans

  @UI05_TC01

  Scenario: TC01_Admin should be able to see Name, Gender, Phone Number, SSN and User Name information of Deans

    Given Admin user is on The Managementon Schools website
    And clicks on Login link
    And sees the page has Login title
    When Admin user enters username on Login page "AdminProjectDot"
    And enters password on Login page "Project11+"
    And Admin user clicks on login button
    Then sees the "Admin Management" title
    Given Admin user clicks on menu button
    And sees the menu list on the left hand side
    When user clicks on "Dean Management" link
    And goes to Add Dean section
    And enters name "<name>" on Add Dean section
    And enters surname "<surname>" on Add Dean section
    And enters birthplace "<birthplace>" on Add Dean section
    And clicks on Female for gender on Add Dean section
    And enters Date of Birth on Add Dean section
    And enters Phone number "<Phone number>" on Add Dean section
    And enters ssn number "<ssn number>" on Add Dean section
    And Admin user enters a new username "<username>" on Add Dean section
    And enters the password "Istabul1" on Add Dean section
    And user clicks on submit on Add Dean section
    Then sees the Dean Saved alert
    And Admin user goes to the last page of the dean list
    Then sees the the Deans information


  @DB05_TC01

  Scenario Outline: Validate Admins can see registered Dean's Name, Gender, Phone Number, SSN and User Name information of Deans
    Given connect to database
    When get Dean via username "<username>"
    Then validate  name "<name>", surname "<surname>", birth_place "<birth_place>", gender "<gender>", birth_day "<birth_day>", phone_number "<phone_number>",ssn "<ssn>", username"<username>"
    And close the connection


    Examples:
      | name   | surname  | birth_place | gender | birth_day  | phone_number | ssn         | username |
      | Serena | Williams | Istanbul    | 1      | 1234-11-11 | 181-081-6739 | 253-85-9497 | 123      |

  @API05-TC01 @Api_admin

  Scenario: Validate Admins can see registered Dean's Name, Gender, Phone Number, SSN and User Name information of Deans

    Given send get request to get all dean users
    Then validate Dean's details are seen


  @UI05_TC03

  Scenario: TC03_Admin should be able to update Deans

    Given Admin user is on The Managementon Schools website
    And clicks on Login link
    And sees the page has Login title
    When Admin user enters username on Login page "AdminProjectDot"
    And enters password on Login page "Project11+"
    And Admin user clicks on login button
    Then sees the "Admin Management" title
    And Admin user clicks on menu button
    And sees the menu list on the left hand side
    When user clicks on "Dean Management" link
    And Admin user goes to the last page of the dean list
    And goes to the last Dean created
    And clicks on Edit button on the Dean List
    And enters a new name "<name>" on edit Dean section
    And enters surname "<surname>" on edit Dean section
    And enters birthplace "<birthplace>" on edit Dean section
    And clicks on Male for gender on edit Dean section
    And enters Date of Birth on edit Dean section
    And enters Phone number "<Phone number>" on edit Dean section
    And enters ssn number "<ssn number>" on edit Dean section
    And Admin user enters a new username "<username>" on edit Dean section
    And enters the password on the edit box "<Istanbul1>"
    And Admin user clicks Submit button on the edit box
    Then sees the Dean updated Successful alert

    @DB05_TC03

    Scenario: Admin should be able to update Deans

      Given connect to database
      When get updated Dean via username
      Then validate Dean's details are updated
      And close the connection

    @API05-TC03 @Api_admin

    Scenario: Validate Admins can update Deans

      Given send get request to get all dean users for API test
      Then validate Dean's details are updated by API


















