
package autoFrameword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModule.Home_Action;
import appModule.Login_Action;

// Chứa testcase
public class TestCase_Login {

	String phone = "0987654440";
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

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://id.dev.icankids.com.vn/auth");
	}
	

	@Test (description = "Login sucess")
	public void TC_success_Login() throws InterruptedException {
		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);

		// Home_Action.btnLogout(driver);
	}

	@Test (description = "Click button Buy")
	public void TC_invalid_Button_Buy() {
		driver.navigate().refresh();
		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		Home_Action.btnBuy(driver);
	}

	@Test (description = "Click button InfoAccount")
	public void TC_invalid_Btutton_InfoAccount() {
		driver.navigate().refresh();
		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		Home_Action.btnInfoAccount(driver);
	}

	@Test (description = "Click button HitoryPayment")
	public void TC_invalid_Button_HitoryPayment() {
		driver.navigate().refresh();
		Login_Action.inputPhone(driver, phone);
		Login_Action.btnSubmit(driver);
		Login_Action.inputOtp(driver, otp);
		Login_Action.btnSubmit(driver);
		Home_Action.btnHistoryPayment(driver);

	}

	@AfterMethod
	public void End() {
		driver.close();
	}

}
