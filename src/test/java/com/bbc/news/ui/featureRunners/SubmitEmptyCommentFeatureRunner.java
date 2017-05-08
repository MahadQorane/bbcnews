package com.bbc.news.ui.featureRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        format = {"pretty", "html:target/cucumber", "json:target/CommentsOnNewsArticlesFeatureRunner.json"},
        features = {"src/test/resources/features/submit_empty_comment.feature"},
        strict = true,
        glue = {"classpath:com.bbc.news.ui"}
)

public class SubmitEmptyCommentFeatureRunner {
}
