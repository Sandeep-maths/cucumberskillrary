package genericUtilities;

import org.openqa.selenium.WebDriver;

import objectRepo.PageObjectManager;

public class TextContextSetUp {
	

	public WebDriver driver;
	public ExcelUtility excel;
	public JavaUtility jutil;
	public PropertiesUtility property;
	public WebDriverUtility web;
	
	public PageObjectManager pageobject;
	
	public TextContextSetUp() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();

		property.propertiesInit(Iconstantpath.PROPERTIES_FILE_PATH);

		driver = web.launchBrowser(property.readdata("browser"));
		

		pageobject = new PageObjectManager(driver);
	}

}
