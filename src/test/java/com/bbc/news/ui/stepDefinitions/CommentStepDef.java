package com.bbc.news.ui.stepDefinitions;


import com.bbc.news.ui.pageObjects.BbcNewsBlogPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CommentStepDef extends BbcNewsBlogPage {

    public static final String MESSAGE_SUCCESS = "Thanks, your comment has been posted.";
    public static final String ERROR_MESSAGE = "You need to write your comment before you post it.";

    WebDriver driver = getDriver();


    @Given("^a member of the audience is on news blog page$")
    public void a_member_of_the_audience_is_on_news_blog_page() {
        openBlogPage();
    }

    @And("^signed in with a valid bbc account$")
    public void signed_in_with_a_valid_bbc_account() {
        SignIn();
        signInWithValidAcount();
    }

    @When("^the member posts a the following comment \"([^\"]*)\"$")
    public void the_member_posts_a_the_following_comment(String comment) {
        postComments(comment);
    }

    @When("^the member posts a the following comment:$")
    public void the_member_posts_a_the_following_comment(List<String> comment) {
        postComments(comment.get(0));
        clickToComment();
        System.out.println("Comment : " + comment.get(0));
    }

    @When("^the member submit empty comments$")
    public void the_member_submit_empty_comments() {
        submitEmptyComment();

    }

    @Then("^the posted comment is added to the news blog$")
    public void the_posted_comment_is_added_to_the_news_blog() {
        assertTrue(isTextPresent(MESSAGE_SUCCESS));
        driver.quit();
    }

    @Then("^appropriate error is displayed$")
    public void appropriateErrorIsDisplayed() {
        assertTrue(isTextPresent(ERROR_MESSAGE));
        driver.quit();
    }
}
