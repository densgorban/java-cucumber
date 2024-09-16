Feature: Create playground on Hands-On Orgs
  As a User, I want to login and create Playground
  So that new organization appears in my application

  Background:
    Given I login as user "Denys Horban"
    When I navigate to My Profile and click "Hands-On Orgs"

  @regression @e2e
  @allure.label.epic:Documents
  Scenario: Create Playground
    And I create Playground with name "random"
    Then new organization appears in my app list

