package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 

public class loginPage {

	WebDriver driver;
	By txt_username = By.id("page_email");
	By txt_password = By.id("page_password");
	By btn_login = By.id("LoginPageButton");

	
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	
	}
	
	public void loginValidUser(String username, String pwd)
	{
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(pwd);
		driver.findElement(btn_login).click();
	}
}
