Feature: Insert a Person

  Scenario: With status ok
    Given the client wants to insert a person
    When the request is valid
    And call the post endpoint
    Then return should be 201
    And the person should be find in get endpoint