package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class CreateEmpPage extends Base {
	
	
	public static WebElement new_emp_btn()
	{
		return driver.findElement(getElement("newemp"));
		
	}
	public static WebElement empname_txtbox()
	{
		return driver.findElement(getElement("empname"));
		
	}
	public static WebElement loginpwd_txtbox()
	{
		return driver.findElement(getElement("emploginpwd"));
		
	}

	public static WebElement role_txtbox()
	{
		return driver.findElement(getElement("emprole"));
		
	}
	public static WebElement branch_select_txtbox()
	{
		return driver.findElement(getElement("empbranch"));
		
	}
	public static WebElement submit_btn()
	{
		return driver.findElement(getElement("empsubmit"));
		
	}
	public static WebElement reset_btn()
	{
		return driver.findElement(getElement("empreset"));
		
	}
	public static WebElement cancel_btn()
	{
		return driver.findElement(getElement("empcancel"));
		
	}

}
