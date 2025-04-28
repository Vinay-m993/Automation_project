package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoisturizerPage {

	WebDriver driver;

	By aloeMoisturizer = By.xpath("(//button[@class='btn btn-primary'])[3]");
	By almondMoisturizer = By.xpath("(//button[@class='btn btn-primary'])[1]");
	By cartButton = By.xpath("//button[@class='thin-text nav-link']");

	public MoisturizerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAloeMoisturizer() {
		driver.findElement(aloeMoisturizer).click();
		System.out.println("Added Aloe Moisturizer!");
	}

	public void addAlmondMoisturizer() {
		driver.findElement(almondMoisturizer).click();
		System.out.println("Added Almond Moisturizer!");
	}

	public void goToCart() {
		driver.findElement(cartButton).click();
		System.out.println("Clicked on Cart");
	}
}
