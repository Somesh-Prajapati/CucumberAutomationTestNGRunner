package generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import io.qameta.allure.Attachment;

public class GenericUtills {

	public WebDriver driver;
	public Properties prop;
	public Select select;
	public WebDriverWait wait;
	public Actions action;
	public Robot robot;
	public Assertion assertion;

	public GenericUtills(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	public void SwitchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
		String childWindow = "";
		for (String string : s1) {
			childWindow = string;
		}
		driver.switchTo().window(childWindow);
	}

	public Properties HandlePropertyFiles(String string) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\"+string+".properties");
		prop = new Properties();
		prop.load(fis);
		return prop;
	}

	public WebElement elementLocator(By string) {
		return driver.findElement(string);
	}

	public List<WebElement> elementLocators(By string) {
		List<WebElement> list = driver.findElements(string);
		return list;
	}

	public void SelectByVisibleText(WebElement element, String string) {
		select = new Select(element);
		select.selectByVisibleText(string);
	}

	public void OpenUrl(String url) {
		driver.get(url);
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	public void QuitBrowser() {
		driver.quit();
	}

	public Actions ActionsObj() {
		action = new Actions(driver);
		return action;
	}

	public Robot RobotObj() throws AWTException {
		robot = new Robot();
		return robot;
	}

	public void ElementClickable(WebElement webelement) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}

	public void ElementsClickable(List<WebElement> list) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		for (int i = 0; i < list.size(); i++) {
			wait.until(ExpectedConditions.elementToBeClickable(list.get(i)));
		}
	}

	public void ElementPresence(String Xpath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
	}
	

	public void GetScreenShot(String testname) {
		Random random = new Random();
		int randomInRange = random.nextInt(1000);
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//FailedScreenshots//"+testname+"_"+randomInRange +".png";
		File destinationFile = new File(destination);
		try {
			FileUtils.copyFile(source, destinationFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public byte[] GetScreenShotForAllure() {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		byte[] source = screenshot.getScreenshotAs(OutputType.BYTES);
		return source;
	}

	public void SwitchToIframe(WebElement webelement) {
		driver.switchTo().frame(webelement);
	}

	public void HANDLE_DROPDOWN(List<WebElement> VACANYLIST, String string) {
		List<WebElement> List = VACANYLIST;
		for (int i = 0; i < List.size(); i++) {
			List = VACANYLIST;
			if (List.get(i).getText().equalsIgnoreCase(string)) {
				List.get(i).click();
				break;
			}
		}
	}

	public void AssertionMethods() {
		assertion = new Assertion();
	}

	public void JavaScriptExecutorScroll(String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + string + ");");
	}

}
