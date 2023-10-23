package utilities;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	protected static String filePath;
	protected Properties properties;
	protected FileInputStream fis;
	public static WebDriver driver;
	public static WebDriverWait wait;
	protected Actions action;
	/**
	 * using this method we can load our property and also open desired browser
	 */
	static {
		filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testAppData.properties";
	}

	public WebDriver setUp(String browserName, String appUrl) {
		properties = new Properties();
		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait=new WebDriverWait(driver,20);
		driver.get(appUrl);
		action = new Actions(driver);
		return driver;
	}

	/**
	 * Method to wait for an element till it's not clickable.
	 * 
	 * @param by
	 */
	public void waitForElementToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Method to refresh Page
	 */
	protected void refreshPage() {

		driver.navigate().refresh();

	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	public void handleHtmlDropdownListWithVisibleText(WebElement element, String visibileText) {

		Select select = new Select(element);
		select.selectByVisibleText(visibileText);
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	public void handleHtmlDropdownListWithIndex(WebElement element, int index) {
		//waitForElementDisplayed(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * Utility to handle HTML dropdown list
	 */
	protected List<WebElement> getHtmlDropdownListSize(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}

	public void cleanUp() {
		driver.close();
	}

}
