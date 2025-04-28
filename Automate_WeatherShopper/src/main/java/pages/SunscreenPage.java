package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SunscreenPage {

	WebDriver driver;

	By sunscreenItem = By.xpath("//button[@class='btn btn-primary']");
	By cartButton = By.xpath("//span[@id='cart']");

	public SunscreenPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addSunscreen() {
		driver.findElement(sunscreenItem).click();
		System.out.println("Sunscreen Added");
	}

	public void goToCart() {
		driver.findElement(cartButton).click();
		System.out.println("Clicked on Cart");
	}
}