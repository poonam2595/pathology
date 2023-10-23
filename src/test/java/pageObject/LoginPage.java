package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "email")
	WebElement setEmail;

	public void email(String email) {
		setEmail.clear();
		setEmail.sendKeys(email);
	}

	@FindBy(name = "password")
	WebElement setPassword;

	public void setPass(String pass) {
		setPassword.clear();
		setPassword.sendKeys(pass);
	}

	@FindBy(xpath = "//span[text()=\"Login\"]")
	WebElement login;

	public void login() {
		login.click();
	}
	
}
