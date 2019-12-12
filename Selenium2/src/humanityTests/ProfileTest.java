package humanityTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import humanityPages.HomePage;
import humanityPages.EditStaffPage;
import humanityPages.ProfilePage;
import humanityPages.LoginPage;

public class ProfileTest  extends BasicTest{

	private String baseUrl = "https://www.humanity.com/";
	
	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(baseUrl);
		Thread.sleep(2000);

		HomePage hp = new HomePage(driver);
		hp.getLoginBtn().click();
		Thread.sleep(2000);

		LoginPage lg = new LoginPage(driver);
		lg.singIn("mimicadaki@gmail.com", "44718353");
		Thread.sleep(2000);
}
	@Test(priority = 5)
	public void uploadImage() {
		ProfilePage hp1 =new ProfilePage(driver);
		hp1.Click();
		
		EditStaffPage esp = new EditStaffPage(driver);
		esp.Slika();
		esp.Nickname();
	}
	
}



