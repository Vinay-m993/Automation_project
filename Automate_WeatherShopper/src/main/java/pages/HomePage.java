package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;

	By temperature = By.xpath("//span[@id='temperature']");
	By moisturizersButton = By.xpath("//button[@class='btn btn-primary']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTemperature() {
		WebElement temperatureElement = driver.findElement(By.xpath("//span[@class='heading']"));
		return temperatureElement.getText().replaceAll("[^0-9]", "");
	}

	public void chooseProduct(String temperature) {
		int temp = Integer.parseInt(temperature);

		if (temp < 19) {
			System.out.println("Temperature is below 19°C, shopping for Moisturizer.");
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		}

		else if (temp > 34) {
			System.out.println("Temperature is above 34°C, shopping for Sunscreen.");
			driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		}
	}
}
