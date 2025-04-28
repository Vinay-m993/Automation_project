package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonLibrary.Base;
import pages.CartPage;
import pages.HomePage;
import pages.MoisturizerPage;
import pages.PaymentPage;
import pages.SunscreenPage;

public class WeatherShopperTest {

	WebDriver driver;
	Base base = new Base();

	HomePage homePage;
	MoisturizerPage moisturizerPage;
	CartPage cartPage;
	PaymentPage paymentPage;
	SunscreenPage sunscreenPage;

	@BeforeMethod
	@Parameters({ "Browser", "Url" })
	public void initialize(String browserName, String url) throws Exception {
		driver = base.browserLaunch(browserName);
		driver.get(url);
	}

	@Test
	public void shopBasedOnTemperature() throws InterruptedException {
		String tempText = homePage.getTemperature();
		int temp = Integer.parseInt(tempText.replaceAll("[^0-9]", ""));

		if (temp < 19) {
			System.out.println("Shopping for Moisturizers");
			homePage.chooseProduct("moisturizer");
			moisturizerPage = new MoisturizerPage(driver);
			moisturizerPage.addAloeMoisturizer();
			moisturizerPage.addAlmondMoisturizer();
			moisturizerPage.goToCart();

		} else if (temp > 34) {
			System.out.println("Shopping for Sunscreens");
			homePage.chooseProduct("sunscreen");
			sunscreenPage = new SunscreenPage(driver);
			sunscreenPage.addSunscreen();
			sunscreenPage.goToCart();
		}

		cartPage = new CartPage(driver);
		cartPage.proceedToCheckout();

		paymentPage = new PaymentPage(driver);
		paymentPage.fillPaymentDetails();

		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("PAYMENT SUCCESS"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}