package com.bbc.news.ui.pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BbcNewsBlogPage {

    public static final String USERNAME = "mahadqorane@gmail.com";
    public static final String PASSWORD = "aniga2017";
    public static final String BBC_NEW_BLOG_PAGE = "http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0#comments";
    public static final String CHROME_MAXIMISED = "--start-maximized";

    protected static WebDriver driver;


    //locators
    private By username_inpt = By.cssSelector("#username-input");
    private By password_inpt = By.cssSelector("#password-input");
    private By comments = By.cssSelector("#comments");
    private By signInLink = By.linkText("Sign in");
    private By submit_btn = By.cssSelector("#submit-button");
    private By commentsLink = By.cssSelector(".blogs-comments-link");
    String bbcBlogs = "bbc-blogs-comments-iframe";
    private By addComments_inpt = By.cssSelector("textarea.cmts-post-box");
    private By postComment_btn = By.cssSelector(".cmts-submit.cmts-button");

    public WebDriver getDriver() {
        if (driver == null) {
            setUp();
        }
        return driver;
    }

    public void openBlogPage() {
        driver.get(BBC_NEW_BLOG_PAGE);
    }

    public void signInWithValidAcount() {
        enterUserName();
        enterPassword();
        clickToSignIn();
    }

    private void enterUserName() {
        driver.findElement(username_inpt).sendKeys(USERNAME);
    }

    private void enterPassword() {
        driver.findElement(password_inpt).sendKeys(PASSWORD);
    }

    public void SignIn() {
        elementToBeVisible(comments);
        driver.findElement(signInLink).click();
    }

    public void clickToComment() {
        swithingToFrame(bbcBlogs);
        driver.findElement(commentsLink);
    }

    public static Object executeScript(String script, Object... elements) {
        return ((JavascriptExecutor) driver).executeScript(script, elements);
    }

    public void postComments(String myComment) {
        swithingToFrame(bbcBlogs);

        WebElement textArea = driver.findElement(addComments_inpt);
        WebElement submitForm = driver.findElement(postComment_btn);

        textArea.sendKeys(myComment);
        submitForm.click();
        driver.switchTo().defaultContent();


    }

    public void submitEmptyComment() {
        swithingToFrame(bbcBlogs);

        WebElement textArea = driver.findElement(addComments_inpt);
        WebElement submitForm = driver.findElement(postComment_btn);

        textArea.sendKeys("");
        submitForm.click();
        driver.switchTo().defaultContent();
    }

    private void swithingToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    public void actionsElement(By el) {
        WebElement element = driver.findElement(el);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
    }


    public void clickToSignIn() {
        driver.findElement(submit_btn).click();
    }


    public void setUp() {
//       Chromedriver executable available on your path -
        System.setProperty("webdriver.chrome.driver", "/Users/mahmed/chromeDriver/chromedriver");
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.addArguments(CHROME_MAXIMISED);
        driver = new ChromeDriver(browserOptions);
        driver.manage().deleteAllCookies();
    }

    public void elementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }


    public boolean isTextPresent(String text) {
        swithingToFrame(bbcBlogs);

        try {
            boolean b = driver.getPageSource().contains(text);
            return b;
        } catch (Exception e) {
            return false;
        }
    }

    public void tearDown() {
        driver.quit();
    }


}
