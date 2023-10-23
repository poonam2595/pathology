package pageObject;

import java.util.Scanner;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addPatient {
	WebDriver driver;

	public addPatient() {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=\"Add\"]")
	WebElement addPatient;

	public void addPatient() {
		addPatient.click();
	}

	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl\"]")
	WebElement patientName;

	public void patientName(String name) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the patient");
		name = sc.next();
		patientName.sendKeys(name);

	}

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement save;

	public void save() throws InterruptedException {
		Thread.sleep(100);
		save.click();
		// WebDriverWait wait=new WebDriverWait(driver,Duration.seconds);

	}

	@FindBy(css = "a[href=\"/dashboard\"]")
	WebElement dashboard;

	public void dashboard() throws InterruptedException {
		Thread.sleep(1000);
		dashboard.click();
	}
	

}
