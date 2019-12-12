package humanityPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditStaffPage extends BasicPage{
	
	private By editDetail = By.cssSelector("#_cd_staff > div.right > div.EmployeeTop > a:nth-child(5)");
	private By upload = By.id("fileupload");
	private By nickname = By.id("nick_name");

	public EditStaffPage(WebDriver driver) {
		super(driver);

	}

	public WebElement getEditDetail() {
		return this.driver.findElement(editDetail);
	}

	public WebElement getUpload() {
		return this.driver.findElement(upload);
	}

	public WebElement getNickname() {
		return this.driver.findElement(nickname);
	}

	public void Slika() {
		WebElement suploadPic = this.getUpload();
		suploadPic.sendKeys("E:\\New folder\\CV slika");
		suploadPic.sendKeys(Keys.ENTER);
	}

	public void Nickname() {
		WebElement sNickname = this.getNickname();
		sNickname.sendKeys("Mimita");
		sNickname.sendKeys(Keys.ENTER);
	}

}
