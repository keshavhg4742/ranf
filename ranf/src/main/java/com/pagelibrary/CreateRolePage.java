package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class CreateRolePage extends Base{
	
	public static WebElement roles_btn()
	{
		return driver.findElement(getElement("roles"));
		
	}
	
	public static WebElement new_role_btn()
	{
		return driver.findElement(getElement("newrole"));
		
	}
	public static WebElement rolename_txtbox()
	{
		return driver.findElement(getElement("rolename"));
		
	}
	public static WebElement roledesc_txtbox()
	{
		return driver.findElement(getElement("roledesc"));
		
	}
	public static WebElement roletype_txtbox()
	{
		return driver.findElement(getElement("roletype"));
		
	}
	public static WebElement rolesubmit_btn()
	{
		return driver.findElement(getElement("rolesubmit"));
		
	}

}
