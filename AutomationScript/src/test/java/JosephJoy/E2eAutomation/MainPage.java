package JosephJoy.E2eAutomation;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;

import pageObject.LandingPage;
import resources.Base;

public class MainPage extends Base {
public HashMap map = new HashMap();
ExtentReports extent;


// This is used to intialize the driver, setting the extend reports variables
	@BeforeTest
	public void HomePageLoading () throws IOException
	{
		driver = intializeDriver();		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\seleniun tutorial\\E2eAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("Url"));
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Joseph Joy");
	
		}
	
	
//THis is used to flush the extend report and used to close the driver after excecution	
	@AfterTest
	public void teardown()
	{
		extent.flush();
		driver.close();
	}
	
	
	@Test()
	public void AddIntNum() throws IOException, FilloException
	{
		map=ExcelReadFillo("TC_001");
		ExtentTest test= extent.createTest("TC_001");
		LandingPage page = new LandingPage(driver);
		String value1 = map.get("Input1").toString();
		String value2 = map.get("Input2").toString();
		String value3 = map.get("ExpectedOutput").toString();
		page.ClickValue(value1);
		page.FunctionButton("plus").click();
		page.ClickValue(value2);
		page.FunctionButton("equal").click();
		
		String totalValue = page.TextButton().toString();
		System.out.print("the vale"+totalValue);
		if(!(totalValue== value3)) {
			test.fail("The values are not same" );
		}else {
			test.pass("The values are same");
		}
		
	}
	
	@Test
	public void AddNegNum() throws FilloException
	{
          map=ExcelReadFillo("TC_002");
          ExtentTest test= extent.createTest("TC_002");
		LandingPage page = new LandingPage(driver);
		String value1 = map.get("Input1").toString();
		String value2 = map.get("Input2").toString();	
		String value3 = map.get("ExpectedOutput").toString();
		page.FunctionButton("minus").click();
		page.ClickValue(value1);
		page.FunctionButton("minus").click();
		page.ClickValue(value2);
		page.FunctionButton("equal").click();
		if(!(page.TextButton()== value3)) {
			test.fail("The values are not same");
		}else {
			test.pass("The values are same");
		}
		
	}
	
	@Test
	public void AddPosAndNegNum() throws FilloException
	{
          map=ExcelReadFillo("TC_003");
          ExtentTest test= extent.createTest("TC_003");
		LandingPage page = new LandingPage(driver);
		String value1 = map.get("Input1").toString();
		String value2 = map.get("Input2").toString();
		String value3 = map.get("ExpectedOutput").toString();
		page.FunctionButton("minus").click();
		page.ClickValue(value1);
		page.FunctionButton("plus").click();
		page.ClickValue(value2);
		page.FunctionButton("equal").click();
		if(!(page.TextButton()== value3)) {
			test.fail("The values are not same");
		}else {
			test.pass("The values are same");
		}
	}
	
	@Test
	public void SubIntNum() throws FilloException
	{
          map=ExcelReadFillo("TC_004");
          ExtentTest test= extent.createTest("TC_004");
		LandingPage page = new LandingPage(driver);
		String value1 = map.get("Input1").toString();
		String value2 = map.get("Input2").toString();
		String value3 = map.get("ExpectedOutput").toString();
		page.ClickValue(value1);
		page.FunctionButton("minus").click();
		page.ClickValue(value2);
		page.FunctionButton("equal").click();
		if(!(page.TextButton()== value3)) {
			test.fail("The values are not same");
		}else {
			test.pass("The values are same");
		}
		
	}
	
	
	@Test
	public void MulIntNum() throws FilloException
	{
		   map=ExcelReadFillo("TC_005");
		   ExtentTest test= extent.createTest("TC_005");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.ClickValue(value1);
			page.FunctionButton("multiply").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	
	@Test
	public void MulNegNum() throws FilloException
	{
		   map=ExcelReadFillo("TC_006");
		   ExtentTest test= extent.createTest("TC_006");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.FunctionButton("minus").click();
			page.ClickValue(value1);
			page.FunctionButton("multiply").click();
			page.FunctionButton("minus").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	@Test
	public void MulNegAndPosNum() throws FilloException
	{
		   map=ExcelReadFillo("TC_007");
		   ExtentTest test= extent.createTest("TC_007");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.FunctionButton("minus").click();
			page.ClickValue(value1);
			page.FunctionButton("multiply").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	@Test
	public void DivTwoInt() throws FilloException
	{
		   map=ExcelReadFillo("TC_008");
		   ExtentTest test= extent.createTest("TC_008");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.ClickValue(value1);
			page.FunctionButton("divide").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	@Test
	public void DivTwoNegNum() throws FilloException
	{
		   map=ExcelReadFillo("TC_009");
		   ExtentTest test= extent.createTest("TC_009");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.FunctionButton("minus").click();
			page.ClickValue(value1);
			page.FunctionButton("divide").click();
			page.FunctionButton("minus").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	@Test
	public void DivNegNumByPosNum() throws FilloException
	{
		   map=ExcelReadFillo("TC_010");
		   ExtentTest test= extent.createTest("TC_010");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.FunctionButton("minus").click();
			page.ClickValue(value1);
			page.FunctionButton("divide").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	@Test
	public void DivByZero() throws FilloException
	{
		   map=ExcelReadFillo("TC_011");
		   ExtentTest test= extent.createTest("TC_011");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.ClickValue(value1);
			page.FunctionButton("divide").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	
	@Test
	public void DivNegNum() throws FilloException
	{
		   map=ExcelReadFillo("TC_012");
		   ExtentTest test= extent.createTest("TC_012");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.ClickValue(value1);
			page.FunctionButton("divide").click();
			page.FunctionButton("minus").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
			
			
	}
	
	@Test
	public void DivZeroByInt() throws FilloException
	{
		   map=ExcelReadFillo("TC_013");
		   ExtentTest test= extent.createTest("TC_013");
			LandingPage page = new LandingPage(driver);
			String value1 = map.get("Input1").toString();
			String value2 = map.get("Input2").toString();
			String value3 = map.get("ExpectedOutput").toString();
			page.ClickValue(value1);
			page.FunctionButton("divide").click();
			page.ClickValue(value2);
			page.FunctionButton("equal").click();
			if(!(page.TextButton()== value3)) {
				test.fail("The values are not same");
			}else {
				test.pass("The values are same");
			}
	}
	

}
