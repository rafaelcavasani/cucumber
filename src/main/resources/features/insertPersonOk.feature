Feature: Insert a Person

  Scenario: With status ok
    Given a valid request payload
    When call the post endpoint
    Then return should be 201
    And the person should be find in get endpoint