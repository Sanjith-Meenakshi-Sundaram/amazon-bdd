package stepdefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

import pages.SearchPage;
import utils.DriverManager;
import utils.ExcelReader;

public class SearchSteps {

    WebDriver driver = DriverManager.getDriver();
    SearchPage searchPage = new SearchPage();

    String filePath = "src/test/resources/testdata/amazon.xlsx";

    @Given("user is logged into Amazon")
    public void user_is_logged_into_amazon() {

        System.out.println("User already logged in from Login scenario");
    }

    @When("user searches products from Excel file")
    public void user_searches_products_from_excel_file() {

    	 String[][] data = ExcelReader.getTestData(filePath, 0);

    	    for (String[] row : data) {

    	        String product = row[0];

    	        if (product == null || product.trim().isEmpty()) {
    	            System.out.println("Skipping empty product from Excel");
    	            continue;
    	        }

    	        System.out.println("Searching product: " + product);

    	        searchPage.searchProduct(product);
        }
    	    searchPage.filter();
    }

    @Then("search results should appear")
    public void search_results_should_appear() {

        System.out.println("Search completed successfully");
    }
}