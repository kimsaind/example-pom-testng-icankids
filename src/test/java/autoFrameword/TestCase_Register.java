
package autoFrameword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModule.Login_Action;

// Chứa testcase
public class TestCase_Register {

	String phone = "0899000001";
	String otp = "0000";

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeMethod
	public void setUp() {

		// Firefox
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		// Chrome
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "/browserDrivers/chromedriver");
		// driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);
		driver.get("https://id.dev.icankids.com.vn/auth");

	}

	@Test
	public void TC_01_Null_Phone_Number_Invalid() {

		// Click button Tiếp tục
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver.getCurrentUrl(), "https://id.dev.icankids.com.vn/auth");
	}

	@Test
	public void TC_02_Check_Phone_Number_Front_Desk() {

		// Input phone
		Login_Action.inputPhone(driver, "0281234567");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");

	}

	@Test
	public void TC_03_Check_Large_phone_number_10() {

		// Input phone
		Login_Action.inputPhone(driver, "09871234567");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");
	}

	@Test
	public void TC_04_Check_Small_phone_number_9() {
		// Input phone
		Login_Action.inputPhone(driver, "09871234");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");
	}

	@Test
	public void TC_05_Valid_Telephone_Number() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver
				.findElement(By.xpath("//small[contains(text(),'Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!')]"))
				.getText(), "Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!");
	}

	@Test
	public void TC_06_Check_Otp_3_Invalid() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);

		// Input otp
		Login_Action.inputOtp(driver, "123");
		Assert.assertEquals(driver
				.findElement(By.xpath("//small[contains(text(),'Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!')]"))
				.getText(), "Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!");
	}

	@Test
	public void TC_07_Check_Otp_4_Invalid() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);

		// Input otp
		Login_Action.inputOtp(driver, "1234");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(
				driver.findElement(By.xpath("//small[contains(text(),'Thông tin chứng thực không hợp lệ')]")).getText(),
				"Thông tin chứng thực không hợp lệ");
	}

	@Test
	public void TC_00_Register_Success() {

		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver.getTitle(), "https://id.dev.icankids.com.vn/ho-so/tai-khoan/");
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
