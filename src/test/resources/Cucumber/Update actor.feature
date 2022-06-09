Feature: Update actor information
  As a user, i would like to update actor information on the table
  Scenario: I successfully updated actor information on table
    Given I have the actors ID and Update
    When  I update actor information on table
    Then I get the success Message