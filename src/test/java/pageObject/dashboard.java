package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class dashboard extends SeleniumUtility {
	WebDriver driver;

	public dashboard() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class=\"MuiCardContent-root jss179\"]>ul")
	WebElement todoList;

	public void list() {
		List<WebElement> listElements =new ArrayList<WebElement>();

        // Iterate through the list and do something with each element
        for (WebElement element : listElements) {
            System.out.println("Element Text :"+element.getText());
           // System.out.println("Element Text: " + element.getText());
        }
	}

	@FindBy(id = "patient-test")
	WebElement patientTest;

	public void patientTest() {
		patientTest.click();
		handleHtmlDropdownListWithVisibleText(patientTest, "VITAMIN B12,SERUM");
	}

	@FindBy(xpath = "//div[@class=\"MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input\"]")
	WebElement discount;

	public void discount() {
		handleHtmlDropdownListWithIndex(discount, 1);
	}

}
