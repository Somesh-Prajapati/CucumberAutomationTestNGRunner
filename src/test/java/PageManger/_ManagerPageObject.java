package PageManger;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class _ManagerPageObject {
	
	WebDriver driver;
	LoginPageObject loginpageobject;
	
	public _ManagerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPageObject LoginPage() throws IOException {
		return loginpageobject = new LoginPageObject(driver);
	}

}
