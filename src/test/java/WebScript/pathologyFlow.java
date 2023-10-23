package WebScript;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.addPatient;
import pageObject.dashboard;
import utilities.SeleniumUtility;

public class pathologyFlow extends SeleniumUtility {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = setUp("chrome", "https://gor-pathology.web.app/");

	}

	@Test
	public void validation() {
		String actualUrl = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		// Check wheather actual and expected are same or not
		String expectedUrl = "https://gor-pathology.web.app/";
		String expectedTitle = "GOR Pathology Web Portal";
		Assert.assertEquals(actualUrl, expectedUrl);
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void login() throws InterruptedException {
		LoginPage lp = new LoginPage();
		Thread.sleep(100);
		lp.email("test@kennect.io");
		lp.setPass("Qwerty@1234");
		lp.login();

	}

	@Test
	public void remainingWork() {
		dashboard db = new dashboard();
		db.list();
		db.patientTest();
		db.discount();

	}
	@Test
	public void addDetails() throws InterruptedException {
		addPatient ad=new addPatient();
		ad.addPatient();
		Scanner scanner=new Scanner(System.in);
		ad.patientName(scanner.next());
		ad.save();
	}
	@Test
	public void landDashboard() throws InterruptedException {
		addPatient ad1=new addPatient();
		ad1.dashboard();//To land on dashboard page to viw the details of patient
	}
}
