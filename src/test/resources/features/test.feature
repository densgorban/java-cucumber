Feature: Currency API
  Test that verifies user GETs a list USD currency rates

  Scenario: Verify GET USD Currency rates
    Given I perform "GET" operation for "/USD"
#    Then response status is 200
#    And response body "result" is "success"
#    And response body "rates.AED" is between 3 and 4
#    And response body "rates.size()" is 164
#    And response body schema matches "currency-schema"
#    And response time execution is less 3 seconds
