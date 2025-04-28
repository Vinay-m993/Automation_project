package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

	WebDriver driver;

	By emailField = By.xpath("//input[@class='control']");
	By cardNumberField = By.xpath("//input[@id='card_number']");
	By expiryDateField = By.xpath("//input[@id='cc-exp']");
	By cvvField = By.xpath("//input[@id='cc-csc']");
	By postalCodeField = By.xpath("(//input[@class='control'])[4]");
	By payButton = By.xpath("//span[@class='iconTick']");

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillPaymentDetails() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		driver.findElement(emailField).sendKeys("test@email.com");
		driver.findElement(cardNumberField).sendKeys("4242424242424242");
		driver.findElement(expiryDateField).sendKeys("12/25");
		driver.findElement(cvvField).sendKeys("666");
		driver.findElement(postalCodeField).sendKeys("87654");
		driver.findElement(payButton).click();

		driver.switchTo().defaultContent();
	}
}
