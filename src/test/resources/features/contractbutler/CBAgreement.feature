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
    And I can see Agreement editing view
    And I Submit Agreement for Approval
    And I Approve using Approval Records
#    And Approves the new Agreement


