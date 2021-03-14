package pageObject;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	 public WebDriver driver;
	 
	 protected static By webXpath = null;
	 
	 
	public void Locator(String value )
	{
		webXpath= By.xpath("//*[@id='"+ value +"']");
	}
	
	public void functionLocator(String value )
	{
		webXpath= By.xpath("//*[@id='sign-"+ value +"']");
	}
	

	public void textBox()
	{
		webXpath= By.xpath("//input[@id='output']");
		
	}
	
	
	//THis logic is used to click on each numbers given in the input
	public void ClickValue(String value1)
	{
		char arr[]= value1.toCharArray();
		for(char a: arr) {
			clickbutton("key-"+a).click();
			String outputVal = clickbutton("output").getAttribute("value");
			if(outputVal.length()>0) {
			if(!new Character(outputVal.charAt(outputVal.length()-1)).equals(a))
				
			{
			   
				System.out.println(a +"is not working");
			}}
		}	
	}
	

	

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public WebElement clickbutton(String value)
	 {
         Locator(value);
		 return driver.findElement(webXpath);
	 }
	
	public String TextButton()
	 {
		textBox();
		 return driver.findElement(webXpath).getAttribute("value");
	 }
	 
	public WebElement FunctionButton(String value)
	{
		functionLocator(value);
		return driver.findElement(webXpath);
		
	}
	 		
	 
}
