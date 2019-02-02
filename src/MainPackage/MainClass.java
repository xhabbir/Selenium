package MainPackage;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Objectclasses.LoginClass;
import Objectclasses.LogoutClass;
import Objectclasses.OrderProcess;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class MainClass {

	public static void main(String[] args) throws IOException, InterruptedException, BiffException {
		
	
		// for loop start
		
		for (int x=0; x<3; x++) { 
		
		FileInputStream fs = new FileInputStream("C:\\Users\\labit\\Desktop\\Third Session\\Third Session\\Test.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet AddressSheet = wb.getSheet("User_Login");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\labit\\Downloads\\chromedriver.exe");						
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		LoginClass loginobjects = new LoginClass (driver);
		 //loginobjects.Login("mytc5@gmail.com","123456789");
		
		loginobjects.Login(AddressSheet.getCell(0, 1).getContents(), AddressSheet.getCell(1, 1).getContents());
		
		Thread.sleep(2000);
		
		OrderProcess processorder = new OrderProcess (driver);
		processorder.processorder();
	
		Thread.sleep(2000);
		
		LogoutClass logout = new LogoutClass (driver);
		logout.logout();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		
	
		driver.close();
		driver.quit();
		
	}
	}// for loop end

}
