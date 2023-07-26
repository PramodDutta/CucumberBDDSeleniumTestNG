package com.thetestingacademy.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class VWOLoginPageDef {

    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    @Given("User is on Login page {string}")
    public void loginTest(String url) {
        driver.get(url);
    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) throws InterruptedException {

        // login to application
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@id=\"js-login-btn\"]")).click();
        Thread.sleep(3000);
        // go the next page

    }

    @Then("User should be able to login sucessfully and new page {string}")
    public void userShouldBeAbleToLoginSucessfullyAndNewPage(String arg0) {

        String homePageHeading = driver.findElement(By.xpath("//h1[normalize-space()=\"Dashboard\"]")).getText();
        //Verify new page - HomePage
        Assert.assertEquals(homePageHeading, arg0);

    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id=\"js-notification-box-msg\"]")).getText();
        // Verify Error Message
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
