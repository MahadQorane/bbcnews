Feature: comments on news articles
  As a member of audience
  I would like to provide comments
  so that my comments can be shared

  Scenario: Registered member of the audience could submit a comment
    Given a member of the audience is on news blog page
    And signed in with a valid bbc account
    When the member posts a the following comment "ggggggggggg gggg rrrr rrrr rrr teteteteuu"
    Then the posted comment is added to the news blog








