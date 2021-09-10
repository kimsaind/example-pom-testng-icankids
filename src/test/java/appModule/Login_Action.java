package appModule;

import org.openqa.selenium.WebDriver;

import POM.Login_Page;

//Thực hiện hành động page Login

public class Login_Action {

	public static void inputPhone(WebDriver driver, String Phone) {

		Login_Page.txtbx_Phone(driver).sendKeys(Phone);
	}

	public static void inputOtp(WebDriver driver, String Otp) {

		Login_Page.txtbx_Otp(driver).sendKeys(Otp);
	}

	public static void btnSubmit(WebDriver driver) {

		Login_Page.btn_Submit(driver).click();
	}

	public static void btnReSentOtp(WebDriver driver) {

		Login_Page.btn_Re_SendOtp(driver).click();
	}

}
