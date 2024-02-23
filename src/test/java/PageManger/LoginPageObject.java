package PageManger;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import generics.GenericUtills;

public class LoginPageObject {
	
	GenericUtills util;
	WebDriver driver;

	By SETUSERNAME = By.xpath("//input[@id='email']");
	By SETPASSWORD = By.xpath("//input[@id='pass']");
	By LOGIN = By.xpath("//button[@name='login']");
	By ValiadteLogin = By.xpath("//div[text()='Log in to Faceboo']");
	By LOGINTEXT = By.xpath("//img[@alt='Facebook']");
	By SEEN = By.xpath("//div[@class='_9lsb _9ls8']");
	
	public LoginPageObject(WebDriver driver) throws IOException {
		this.driver = driver;
		this.util = new GenericUtills(driver);
	}
	
	public void send_USERNAME_PASSWORD(String username,String password) {
		util.elementLocator(SETUSERNAME).sendKeys(username);
		util.elementLocator(SETPASSWORD).sendKeys(password);
		util.elementLocator(SEEN).click();
	}
	
	public String GetLoginAssertion() {
		return util.elementLocator(LOGINTEXT).getText();
	}
	
	public void click_on_LOGIN() {
		util.elementLocator(LOGIN).click();
	}
	
	public String Validate_Login() {
	//	util.ElementPresence("//div[text()='Log in to Facebook']");
		return util.elementLocator(ValiadteLogin).getText();
	}
	
}
