package appModule;

import org.openqa.selenium.WebDriver;

import POM.Home_Page;

//Thực hiện hành động page Home

public class Home_Action {

	public static void btnBuy(WebDriver driver) {

		Home_Page.btn_Buy(driver).click();
	}

	public static void btnEdit(WebDriver driver) {

		Home_Page.btn_EditName(driver).click();
	}

	public static void inputName(WebDriver driver, String name) {

		Home_Page.txtbx_Name(driver).sendKeys(name);
	}

	public static void inputEmail(WebDriver driver, String email) {

		Home_Page.txtbx_Email(driver).sendKeys(email);
	}

	public static void btnInfoAccount(WebDriver driver) {

		Home_Page.btn_InfoAccount(driver).click();
	}

	public static void btnInfoPayment(WebDriver driver) {

		Home_Page.btn_InfoPayment(driver).click();
	}

	public static void btnHistoryPayment(WebDriver driver) {
		
		Home_Page.btn_HistoryPayment(driver).click();
	}
	public static void txtSearchHistoryPayment(WebDriver driver, String search) {

		Home_Page.txt_Search_HistoryPayment(driver).sendKeys(search);
	}

	public static void btnProfile(WebDriver driver) {

		Home_Page.btn_Profile(driver).click();
	}

	public static void btnLogout(WebDriver driver) {

		Home_Page.btn_Logout(driver);
	}

}
