Feature: Parallel run test
  As Test Engineer I want to test how my framework run in parallel
  So I can present this feature for customer

  @parallel
  Scenario: Single test
    Given I perform test with timeout 500
    Then I log results

  @parallel
  Scenario Outline: Multiple tests
    Given I perform test with timeout <timeout>
    Then I log results
  Examples:
    | timeout |
    | 100     |
    | 200     |
    | 300     |
    | 400     |

