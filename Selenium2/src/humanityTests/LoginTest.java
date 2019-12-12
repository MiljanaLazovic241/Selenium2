package humanityTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import humanityPages.DashboardPage;
import humanityPages.EmployeePage;
import humanityPages.HomePage;
import humanityPages.LoginPage;
import humanityPages.ProfilePage;
import humanityPages.TitlePage;

public class LoginTest extends BasicTest {

	private String baseUrl = "https://www.humanity.com/";

	@Test(priority = 0)
	public void basicLogin() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.getLoginBtn().click();
		Thread.sleep(2000);
		LoginPage lg = new LoginPage(driver);
		lg.singIn("felisif496@xmail365.net", "necudatikazem");
		Thread.sleep(2000);
		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Dashboard"));
	}

	@Test(priority = 1)
	public void dashboardTest() throws IOException, InterruptedException {
		File file = new File("nalog.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		String email = sheet.getRow(1).getCell(0).getStringCellValue();
		String password = sheet.getRow(1).getCell(1).getStringCellValue();
		LoginPage lg = new LoginPage(driver);
		lg.singIn(email, password);
		Thread.sleep(2000);
		wb.close();
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("dashboardTest" + dp.getNavLinks().size());
		Assert.assertTrue(dp.getNavLinks().size() > 0);
	}

	@Test(priority = 20)
	public void addEmployeeTest() throws IOException, InterruptedException {
		driver.get("https://sdn1.humanity.com/app/dashboard/");
		Thread.sleep(2000);
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("addEmployeeTest" + dp.getNavLinks().size());
		dp.getNavLinks().get(5).click(); // Staff link
		Thread.sleep(2000);
		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeBtn().click();
		Thread.sleep(2000);
		File file = new File("Radnici.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= 5; i++) {
			String ime = sheet.getRow(i).getCell(0).getStringCellValue();
			String prezime = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			ep.addEmploy(ime, prezime, email);
		}
		ep.addEmploy("Milan", "Markovic", "233343232332@email.com");
		ep.addEmploy("Darko", "Darkovic", "ewd34334@email.com");
		ep.addEmploy("Marko", "Jeftic", "09238732k32m@email.com");
		ep.getSaveBtn().click();

		Thread.sleep(2000);
	
		dp.getNavLinks().get(5).click();
	
	    Assert.assertTrue(ep.employAdded("233343232332@email.com"));
		Assert.assertTrue(ep.employAdded("ewd34334@email.com"));
		Assert.assertTrue(ep.employAdded("09238732k32m@email.com"));
	 }

	@Test(priority = 25)
	public void addpicture() throws IOException, InterruptedException {
		driver.get("https://sdn1.humanity.com/app/dashboard/");
		Thread.sleep(2000);
		ProfilePage pp = new ProfilePage(driver);
		pp.Klikni();

	}
}
