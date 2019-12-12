package humanityPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import humanityPages.BasicPage;

public class ProfilePage extends BasicPage {
	
	private By profile = By.cssSelector("#userm > div > a:nth-child(3)");
	private By settings = By.cssSelector("#userm > div > a:nth-child(5)");
	private By availability = By.cssSelector("#userm > div > a:nth-child(7)");
	private By version = By.cssSelector("#humanityAppVersion");
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getProfile() {
		return this.driver.findElement(profile);
	}
	
	public WebElement getSettings() {
		return this.driver.findElement(settings);
	}
	
	public WebElement getAvailability() {
		return this.driver.findElement(availability);
	}
	
	public WebElement getVersion() {
		return this.driver.findElement(version);
	}
	
	public void Click() {
		this.getProfile().click();
		this.getSettings().click();
		this.getAvailability().click();
		this.getVersion().click();
	}
}


