package testCases1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass1 {
	
	 public WebDriver driver;
	 public Logger logger;
	 public Properties p;
		
		@BeforeClass(groups= {"Master","Sanity","Regression"})
		@Parameters({ "os","browser"})
		public void setup(String os, String br) throws IOException
		{
			//TO READ THE FILES FROM CONFIG
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			logger = LogManager.getLogger(this.getClass());
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("no browser found"); return;
			}
			
			//driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(p.getProperty("appurl"));
			driver.manage().window().maximize();
		}
		
		public String captureScreen(String tname) throws IOException {
			String timestamp =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
			TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
			File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
			String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"-" +timestamp+ "png";       
		
		     try {
		    	 FileUtils.copyFile(source, new File(destination));
		     }
			catch(Exception e) {
				e.getMessage();
			}
			return destination;
		}
		
		
		public void tearDown()
		{
			driver.close();
		}
		

		public String randomeString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomeNumber()
		{
			String generatedString=RandomStringUtils.randomNumeric(10);
			return generatedString;
		}
		
		public String randomAlphaNumeric()
		{
			String str=RandomStringUtils.randomAlphabetic(3);
			String num=RandomStringUtils.randomNumeric(3);
			
			return (str+"@"+num);
		}
		@AfterClass(groups= {"Master","Sanity","Regression"})
		public void quit() {
			driver.quit();
		}
	}
