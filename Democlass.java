package DemoPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
	public static RemoteWebDriver driver;
	public RemoteWebDriver getDriver() {
		return driver;

	}
	@Test
	@Parameters({"portNo"})
	@BeforeMethod()
	
	public void setUp(String portNo) throws InterruptedException, NullPointerException, MalformedURLException
	{			
		if(portNo.equalsIgnoreCase("9246"))
		{
			try {
				//WebDriverManager.chromedriver().setup();
				
				System.out.println("Chrome Browser Test Environment created");
				DesiredCapabilities capsChrome = new DesiredCapabilities();
				capsChrome.setBrowserName("chrome");
				capsChrome.setPlatform(Platform.WINDOWS);
				ChromeOptions options = new ChromeOptions();
				options.merge(capsChrome);
				String urlhub = "http://10.11.1.95:4444/wd/hub";
				
				
				driver = new RemoteWebDriver(new URL(urlhub), options);
				//driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.navigate().to("https://www.google.com/");
				System.out.println("Title of the page is "+driver.getTitle());
				Thread.sleep(20000);
				//driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
				
				
				System.exit(1);
			}
		}
		
		else 
			if(portNo.equalsIgnoreCase("9245"))
			{
				try {
					//WebDriverManager.chromedriver().setup();
					System.out.println("Chrome Browser Test Environment created");
					DesiredCapabilities capsChrome = new DesiredCapabilities();
					capsChrome.setBrowserName("firefox");
					capsChrome.setPlatform(Platform.WINDOWS);
					ChromeOptions options = new ChromeOptions();
					options.merge(capsChrome);
					String urlhub = "http://10.11.1.95:4444/wd/hub";
					
					
					driver = new RemoteWebDriver(new URL(urlhub), options);
					//driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.navigate().to("https://www.google.com/");
					System.out.println("Title of the page is "+driver.getTitle());
					Thread.sleep(20000);
					//driver.quit();
				} catch (Exception e) {
					e.printStackTrace();
					
					
					System.exit(1);
				}
			}
	}
	@AfterMethod()
	public void tearDown()
	{
			driver.quit();
			System.out.println("Closing the Browser");
			
	}
}
