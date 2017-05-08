Feature: comments on news articles
  As a member of audience
  I would like to provide comments
  so that my comments can be shared

  Scenario: Registered member of the audience should not submit empty comments
    Given a member of the audience is on news blog page
    And signed in with a valid bbc account
    When the member submit empty comments
    Then appropriate error is displayed