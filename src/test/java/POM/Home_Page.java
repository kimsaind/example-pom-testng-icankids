package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Lấy element page Home

public class Home_Page {

	private static WebElement element = null;

	public static WebElement btn_Buy(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Xem thêm gói') or contains(text(),'Mua Gói Ngay')]"));
		return element;
	}

	public static WebElement txtbx_Name(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='name']"));
		return element;
	}

	public static WebElement txtbx_Email(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='email']"));
		return element;
	}

	public static WebElement btn_EditName(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(text(),'Sửa')]"));
		return element;
	}

	public static WebElement btn_InfoAccount(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Gói Bạn Mua')]"));
		return element;
	}

	public static WebElement btn_InfoPayment(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Phương Thức Thanh Toán')]"));
		return element;
	}

	public static WebElement btn_HistoryPayment(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Lịch Sử Giao Dịch')]"));
		return element;
	}
	public static WebElement txt_Search_HistoryPayment(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='Search Table']"));
		return element;
	}

	public static WebElement btn_Profile(WebDriver driver) {
		element = driver.findElement(By.linkText("Quản lý hồ sơ"));
		return element;
	}

	public static WebElement btn_Logout(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[contains(text(),'Đăng xuất')]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", element);

		return element;
	}

}
