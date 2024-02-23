Feature: To Check Login Functionality

  Scenario Outline: Orange HRM Login Functionality
    Given user is on landing page
    When user enters <username> and <password>
    And user hits on login button
    Then user is redirected to dashboard

    Examples: 
      | username   | password   |
      | 9977213154 | Sam@123456 |
      | 9977213154 | Sam@123456 |
