
package autoFrameword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Login_Page;
import appModule.Login_Action;

// Chứa testcase
public class TestCase_Register {

	String phone = "0899000001";
	String otp = "0000";

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	Actions action;

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
		
		action = new Actions(driver);

	}

	@Test (description = "Không nhập số điện thoại")
	public void TC_01_Do_Not_Phone_Number() {
		
		// Click button Tiếp tục
		Login_Action.inputPhone(driver, "");
		Login_Action.btnSubmit(driver);
		String nameMessage = getHtml5ValidationMessage(Login_Page.txtbx_Phone(driver));
		Assert.assertEquals("Please fill out this field.", nameMessage);
		}
		
		
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://id.dev.icankids.com.vn/auth");
	
	//@Test (description = "Đúng định dạng số điện thoại")
	public void TC_02_Phone_Number_Is_Correct() {
		
		// Click button Tiếp tục
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input#phone-otp-2")).isDisplayed());
	}
	//@Test (description = "Sai định dạng số điện thoại")
	public void TC_03_Phone_Number_InCorrect() {
		
		// Click button Tiếp tục
		Login_Action.inputPhone(driver, "1234567890");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");
	}
	//@Test (description = "Nhập đầu số khác đầu số VN")
	public void TC_04_Enter_International_Phone_Number() {

		// Click button Tiếp tục
		Login_Action.inputPhone(driver, "25212334512");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");
	}

	//@Test (description = "Nhập số điện thoại bàn")
	public void TC_05_Check_Phone_Number_Front_Desk() {

		// Input phone
		Login_Action.inputPhone(driver, "0281234567");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");

	}
	//@Test (description = "Nhập số điện thoại > 10 ")
	public void TC_06_Check_Large_phone_number_10() {

		// Input phone
		Login_Action.inputPhone(driver, "09871234567");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");
	}

	//@Test (description = "Nhập số điện thoại < 10 ")
	public void TC_07_Check_Small_phone_number_9() {
		// Input phone
		Login_Action.inputPhone(driver, "09871234");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//small[@id='textErrorPhone']")).getText(),
				"Số điện thoại chưa hợp lệ. Vui lòng thử lại");
	}

	//@Test (description = "Không nhập otp")
	public void TC_08_Otp_Should_Be_Avoided() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);
		
		sleepInSecond(1);
		
		// Input otp
		Login_Action.inputOtp(driver, "");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver
				.findElement(By.xpath("//small[contains(text(),'Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!')]"))
				.getText(), "Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!");
	}
	//@Test (description = "Nhập sai otp")
	public void TC_08_Otp_Incorrect() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		// Input otp
		Login_Action.inputOtp(driver, "1234");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(driver
				.findElement(By.xpath("//small[contains(text(),'Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!')]"))
				.getText(), "Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!");
	}

	//@Test (description = "Nhập otp < 4")
	public void TC_09_Check_Small_Otp_4() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		// Input otp
		Login_Action.inputOtp(driver, "123");
		Assert.assertEquals(driver
				.findElement(By.xpath("//small[contains(text(),'Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!')]"))
				.getText(), "Vui lòng nhập đúng mã OTP bạn nhận được qua SMS!");
	}

	//@Test (description = "Nhập otp > 4")
	public void TC_10_Check_Large_Otp_4() {
		// Input phone
		Login_Action.inputPhone(driver, "0987123499");
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);

		// Input otp
		Login_Action.inputOtp(driver, "12345");
		Login_Action.btnSubmit(driver);
		Assert.assertEquals(
				driver.findElement(By.xpath("//small[contains(text(),'Thông tin chứng thực không hợp lệ')]")).getText(),
				"Thông tin chứng thực không hợp lệ");
	}

	@Test (description = "Nhập otp đúng")
	public void TC_11_Otp_Is_Correct() {
		// Input phone
		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		sleepInSecond(1);
		
		// Input otp
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
	
	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		}


	@AfterMethod
	public void End() {
		driver.close();
	}

}
