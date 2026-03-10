package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends BasePage {

	@FindBy(css = "#add-to-cart-button")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	WebElement proceedToBuy;

	public void AddToCart() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement addToCartElement = wait.until(ExpectedConditions.visibilityOf(addToCartBtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addToCartElement);

		js.executeScript("arguments[0].click();", addToCartElement);

		System.out.println("Product added to cart successfully!");
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToBuy));
	    proceedToBuy.click();

	}

}
 