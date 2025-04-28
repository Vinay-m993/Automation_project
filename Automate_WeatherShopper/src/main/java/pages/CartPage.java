package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;

	By checkoutButton = By.xpath("//button[@class='stripe-button-el']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void proceedToCheckout() {
		driver.findElement(checkoutButton).click();
		System.out.println("Clicked on Pay with Card");
	}
}
