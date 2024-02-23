package generics;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver driver;
	public GenericUtills utills;
	public Properties prop;
	public String URL;
	
	public BaseClass() throws IOException {
		utills= new GenericUtills(driver);
		prop = utills.HandlePropertyFiles("Global");
	}
	
	public WebDriver WebDriverManager() throws IOException
	{
		String browser = prop.getProperty("browser");
		URL = prop.getProperty("URl");
		String browser_maven = System.getProperty("browser");
		browser = browser_maven!=null ? browser_maven : browser;
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("Chrome"))
			{
				driver = new ChromeDriver(); 
			}
			else if(browser.equalsIgnoreCase("Edge"))
			{
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			driver.get(URL);
		}
		return driver;
	}
	
}
