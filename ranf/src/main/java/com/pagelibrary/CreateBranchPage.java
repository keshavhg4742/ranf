package com.pagelibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testbase.Base;

public class CreateBranchPage extends Base {
	
	
	public static WebElement new_branch_btn()
	{
		return driver.findElement(getElement("newbranch"));
		
	}
	public static WebElement branchname_txtbox()
	{
		return driver.findElement(getElement("branchname"));
		
	}
	public static WebElement adress_txtbox()
	{
		return driver.findElement(getElement("adress"));
		
	}

	public static WebElement zipcode_txtbox()
	{
		return driver.findElement(getElement("zipcode"));
		
	}
	public static WebElement country_select_txtbox()
	{
		/*Select sel = new Select(driver.findElement(getElement("country")));
		sel.selectByValue("INDIA");*/
		return driver.findElement(getElement("country"));
		
	}

	public static WebElement state_txtbox()
	{
		return driver.findElement(getElement("state"));
		
	}
	public static WebElement city_txtbox()
	{
		return driver.findElement(getElement("city"));
		
	}
	public static WebElement submit_btn()
	{
		return driver.findElement(getElement("submit"));
		
	}
	public static WebElement reset_btn()
	{
		return driver.findElement(getElement("reset"));
		
	}
	public static WebElement cancel_btn()
	{
		return driver.findElement(getElement("cancel"));
		
	}
}

