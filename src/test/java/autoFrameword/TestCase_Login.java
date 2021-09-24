
package autoFrameword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModule.Home_Action;
import appModule.Login_Action;

// Chứa testcase
public class TestCase_Login {

	String phone = "0987123121";
	String otp = "0000";

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeMethod
	public void setUp() {

		// Firefox
		// System.setProperty("webdriver.gecko.driver", projectPath +
		// "/browserDrivers/geckodriver");
		// driver = new FirefoxDriver();

		// Chrome
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://id.dev.icankids.com.vn/auth");
	}

	// @Test (description = "Login sucess")
	public void TC01_success_Login() throws InterruptedException {
		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='container']//h1[contains(text(),'Tài Khoản')]")).getText(),
				"Tài Khoản");

	}

	// @Test (description = "Click button Buy")
	public void TC02_invalid_Button_Buy() {

		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Home_Action.btnBuy(driver);
		sleepInSecond(1);

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='header-page']")).isDisplayed());
	}

	// @Test (description = "Click button InfoAccount")
	public void TC03_invalid_Btutton_InfoAccount() {

		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Home_Action.btnInfoAccount(driver);
		sleepInSecond(1);

		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Bạn đã mua Gói 1 năm - Con Cưng ']")).getText(),
				"Bạn đã mua Gói 1 năm - Con Cưng");
	}

	@Test(description = "Click button HitoryPayment")
	public void TC04_invalid_Button_HitoryPayment() {

		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		Home_Action.btnHistoryPayment(driver);
		sleepInSecond(1);
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[@class='footer__row-count__label' and text()='Hàng trên trang:']"))
						.getText(),
				"Hàng trên trang:");

	}

	public void sleepInSecond(long timeoutInSecound) {
		try {
			Thread.sleep(timeoutInSecound * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void End() {
		driver.close();
	}

}
