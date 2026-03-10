package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy(xpath = "(//div[contains(@class,'a-section aok-relative s-image-tall-aspect')])[1]")
    WebElement firstProduct;
    
    @FindBy(xpath = "//span[normalize-space(text())='Featured']")
    WebElement sortby;
    
    @FindBy(xpath = "(//li[contains(@class,'a-dropdown-item a-declarative')])[2]")
    WebElement ltoh;
    
    @FindBy(xpath = "(//i[contains(@class,'a-icon a-icon-checkbox')])[3]")
    WebElement brand;

    public void searchProduct(String product) {
    	

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(searchBox));

        searchBox.clear();
        searchBox.sendKeys(product);
        searchBox.sendKeys(Keys.ENTER);
        
      // wait.until(ExpectedConditions.visibilityOf(firstProduct));
    }
    
    public void filter() {
    	

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	wait.until(ExpectedConditions.visibilityOf(sortby));
    	sortby.click();
    	ltoh.click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(brand));
    	
    	
    }

    public void clickFirstProduct() {
    	  String parent = driver.getWindowHandle();

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	    wait.until(ExpectedConditions.visibilityOf(firstProduct));

    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);
    	    firstProduct.click();

    	    Set<String> child = driver.getWindowHandles();

    	    for (String c : child) {
    	        if (!c.equals(parent)) {
    	            driver.switchTo().window(c);
            }
        }
    }
}