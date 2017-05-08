# bbcnews
This is completed excercise project using cucumber-jvm and selenium-webdriver to run browser-based automated tests in desktop Chrome.

you'll need Chrome (or Chromium) installed, and you'll also need the Chromedriver executable available on your path. You can get Chromedriver from here https://sites.google.com/a/chromium.org/chromedriver/downloads

-------------------------------------------------------
 T E S T S
-------------------------------------------------------

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Feature: comments on news articles
  As a member of audience
  I would like to provide comments
  so that my comments can be shared

  Scenario: Registered member of the audience could submit a comment                          # src/test/resources/features/comments_on_news_articles.feature:6
    Given a member of the audience is on news blog page                                       # CommentStepDef.a_member_of_the_audience_is_on_news_blog_page()
    And signed in with a valid bbc account                                                    # CommentStepDef.signed_in_with_a_valid_bbc_account()
    When the member posts a the following comment "Great comment is always from a great member" # CommentStepDef.the_member_posts_a_the_following_comment(String)
    Then the posted comment is added to the news blog                                         # CommentStepDef.the_posted_comment_is_added_to_the_news_blog()

1 Scenarios (1 passed)
4 Steps (4 passed)
0m46.284s

Running Scenario: Registered member of the audience could submit a comment
Starting ChromeDriver 2.29.461585 (0be2cd95f834e9ee7c46bcc7cf405b483f5ae83b) on port 4385Only local connections are allowed.Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec - in Scenario: Registered member of the audience could submit a comment
Feature: comments on news articles
  As a member of audience
  I would like to provide comments
  so that my comments can be shared

  Scenario: Registered member of the audience should not submit empty comments # src/test/resources/features/submit_empty_comment.feature:6
    Given a member of the audience is on news blog page                        # CommentStepDef.a_member_of_the_audience_is_on_news_blog_page()
    And signed in with a valid bbc account                                     # CommentStepDef.signed_in_with_a_valid_bbc_account()
    When the member submit empty comments                                      # CommentStepDef.the_member_submit_empty_comments()
    Then appropriate error is displayed                                        # CommentStepDef.appropriateErrorIsDisplayed()

1 Scenarios (1 passed)
4 Steps (4 passed)
0m13.655s

Running Scenario: Registered member of the audience should not submit empty comments
Starting ChromeDriver 2.29.461585 (0be2cd95f834e9ee7c46bcc7cf405b483f5ae83b) on port 23977Only local connections are allowed.Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec - in Scenario: Registered member of the audience should not submit empty comments

Results :

Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ bbc-news ---
[INFO] Building jar: /Users/mahmed/temp/bbcnews/target/bbc-news-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ bbc-news ---
[INFO] Installing /Users/mahmed/temp/bbcnews/target/bbc-news-1.0-SNAPSHOT.jar to /Users/mahmed/.m2/repository/bbc-news/bbc-news/1.0-SNAPSHOT/bbc-news-1.0-SNAPSHOT.jar
[INFO] Installing /Users/mahmed/temp/bbcnews/pom.xml to /Users/mahmed/.m2/repository/bbc-news/bbc-news/1.0-SNAPSHOT/bbc-news-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------