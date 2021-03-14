package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codoid.products.fillo.Fillo;

import pageObject.LandingPage;

public class Base {
	
	
	/*This function is used to intialize the Driver using the 
	corresponding Chrome , and Firefox  driver respectively
	*/	
	public WebDriver driver;
	public WebDriver intializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\seleniun tutorial\\E2eAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
	
	//THis logic is used to click on each button given as the input value
	 public void clickButton(String value1) {
		 LandingPage page = new LandingPage(driver);
			
			char arr[]= value1.toCharArray();
			for(char a: arr) {
				System.out.println(a);
				page.clickbutton("key-"+a).click();
			}
	 }

	public static String getRandomIntegerBetweenRange(double min, double max){
	    double a = (int)(Math.random()*((max-min)+1))+min;
	    String x=Double.toString(a);
	    return x;
	    
	}
	
	
	//This logic is used to map the values from the excel to key values
	public static HashMap<String,String> ExcelReadFillo(String TestCaseID) throws FilloException
	{
		Fillo fillo=new Fillo();
		Connection  cn=fillo.getConnection("D:\\TestData.xls");
		Recordset Data_RS=cn.executeQuery("Select * from TestData where TestCaseID='"+TestCaseID+"'");
		HashMap<String,String> map=new HashMap<String,String>();
		ArrayList<String> columns=new ArrayList<String>();
		columns=Data_RS.getFieldNames();
	System.out.println("columns:"+columns);
	for(int i=1 ;i<columns.size();i++) {
		Data_RS.next();
	String columnName=columns.get(i);
	String columnValue=Data_RS.getField(columnName);
	
	
		map.put(columnName.trim().toString(), columnValue.trim().toString());
	
	}
	cn.close();
	return map;
	}
	
		//THis logic is written inorder to capture the screeenshots.
	public void getScreenshotPath(String testCaseName ,WebDriver driver ) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
	}
	
}
