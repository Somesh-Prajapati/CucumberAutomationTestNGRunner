package generics;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import PageManger._ManagerPageObject;

public class TestContextSetup {

	public WebDriver driver;
	public GenericUtills util;
	public BaseClass base;
	public _ManagerPageObject pagemanager;

	public TestContextSetup() throws IOException  
	{
		base = new BaseClass(); 
		util = new GenericUtills(base.WebDriverManager());
		pagemanager = new _ManagerPageObject(base.WebDriverManager());
	}
}
