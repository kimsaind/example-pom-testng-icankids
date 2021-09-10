package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Lẩy element Login 

public class Login_Page {
	private static WebElement element = null;

	public static WebElement txtbx_Phone(WebDriver driver) {

		// element=driver.findElement(By.xpath("//*[@id=\"phone-number-1\"]"));

		element = driver.findElement(By.id("phone-number-1"));
		return element;
	}

	public static WebElement txtbx_Otp(WebDriver driver) {

		// element=driver.findElement(By.xpath("//*[@id=\"phone-otp-2\"]"));

		element = driver.findElement(By.id("phone-otp-2"));
		return element;
	}

	public static WebElement btn_Submit(WebDriver driver) {

		// element = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
		element = driver.findElement(By.id("btnSubmit"));
		return element;

	}

	public static WebElement btn_Re_SendOtp(WebDriver driver) {

		// element = driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]"));
		element = driver.findElement(By.xpath("//button[@id='resendOTP']"));
		return element;

	}

}
