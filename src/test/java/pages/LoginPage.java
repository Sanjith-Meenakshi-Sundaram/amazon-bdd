package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "nav-link-accountList")
    WebElement accountMenu;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    WebElement signInButton;

    @FindBy(id = "ap_email_login")
    WebElement emailField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement passwordField;

    @FindBy(id = "signInSubmit")
    WebElement signInSubmit;

    @FindBy(xpath = "//div[contains(@class,'a-alert-content')]")
    WebElement errorMessage;

    // ACTION METHODS 
    //action

    public void hoverAccountMenu() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(accountMenu));

        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();
    }
    public void clickSignIn() {
        signInButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickContinue() {

        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
    }

    public void enterPassword(String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField));

        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        signInSubmit.click();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
}