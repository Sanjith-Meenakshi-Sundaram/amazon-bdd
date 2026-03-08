package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage();

    @Given("user is on Amazon homepage")
    public void user_is_on_amazon_homepage() {
        // URL is already opened by DriverFactory
        System.out.println("Amazon homepage loaded");
    }

    @When("user navigates to login page")
    public void user_navigates_to_login_page() {

        loginPage.hoverAccountMenu();
        loginPage.clickSignIn();
    }

    @And("user enters email {string}")
    public void user_enters_email(String email) {

        loginPage.enterEmail(email);
        loginPage.clickContinue();
    }

    @And("user enters password {string}")
    public void user_enters_password(String password) {

        loginPage.enterPassword(password);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {

        loginPage.clickLogin();
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));
    }

    @Then("login should fail with error message")
    public void login_should_fail_with_error_message() {

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
}