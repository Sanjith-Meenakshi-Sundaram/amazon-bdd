package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;
import pages.SearchPage;

public class AddToCartStep {
	
	AddToCartPage ac =new AddToCartPage();
	SearchPage sp=new SearchPage();
	
	@When("user selects the first product")
	public void user_selects_the_first_product() {
		sp.clickFirstProduct();
	
	   
	}

	
	@When("user adds the product to cart")
	public void user_adds_the_product_to_cart() {
		ac.AddToCart();
	   
	}

	@Then("product should be added to cart")
	public void product_should_be_added_to_cart() {
		System.out.println("Product added to cart successfully");
	   
	}



}
