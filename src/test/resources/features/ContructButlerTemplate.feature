@allure.label.epic:AgreementTemplate
Feature: Contract Butler Contract Template
  As a Contract Manager, I want to manage contract templates
  So that I perform Get List, Create, Edit and Delete contract Templates

  Background:
    Given I login as 'manager' user
    And I navigate to 'CONTRACT Butler' application

  @allure.label.jira:CB-63
  Scenario:
    When I open 'Agreement Templates' tab
    And I create new contract Template
    And I set contract Template name 'AutotestContract'
    And Wait for Success popup
    And I return to 'Agreement Templates' tab
    Then I can see the new item in the templates list

