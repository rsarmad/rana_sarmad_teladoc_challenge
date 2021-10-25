Feature: Add and Remove user from webtables

  Scenario: Validate user is added to webtables
    Given user navigates to website
    When user clicks on Add User button
    And user fills in new user details
    And clicks save button
    Then validate newly added user exists in webtable
    And quit browser

  Scenario: Validate user is removed from webtables
    Given user navigates to website
    When user finds username novak and delete username novak from webtable
    And quit browser
