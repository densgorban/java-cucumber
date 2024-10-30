@allure.label.epic:AgreementTemplate
@PDFButler
Feature: Contract Butler Contract Agreement
  As a Contract Manager, I want to manage contract Agreement
  So that I perform Get List, Create, Edit and Delete contract Templates

  Background:
    Given I login as 'sales' user
    And I navigate to 'CONTRACT Butler' application

  Scenario:
    When I open 'Opportunities' tab
    And I open opportunity
    And I create new Agreement
#    And I click on create Template
#    And Wait for Success popup
#    And I can see Agreement editing view
#    And I save agreement
#    And I login in another tab as 'approver' user
#    And Approves the new Agreement
#    Then I can see the new item in the templates list


