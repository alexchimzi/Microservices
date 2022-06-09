Feature: Removing actor
  As a user, I would like to remove an actor from table
  Scenario: I successfully removed an actor from table
    Given I have the actors ID
    When I remove user from the database
    Then I get the success return Boolean