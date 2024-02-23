Feature: To Check Registration Functionality
	@smoke
  Scenario Outline: Orange HRM Registration Functionality
    Given user is on landing page
    When user enters <username> and <password>
    And user hits on registration button

    Examples: 
      | username   | password   |
      | 9977213154 | Sam@123456 |
      | 9977213154 | Sam@123456 |
