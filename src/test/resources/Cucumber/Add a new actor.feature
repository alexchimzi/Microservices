Feature: Adding a new Actor
  As a user I would like to add a new actor into my table
  Scenario: I successfully add an actor into my table
    Given I have the actors information
    When I input the data into the database
    Then I get the success return string