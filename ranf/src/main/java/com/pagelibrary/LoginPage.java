package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class LoginPage extends Base {
	public static WebElement uesrName_txtbox()
	{
		return driver.findElement(getElement("username"));
		
	}
	
	public static WebElement password_txtbox()
	{
		return driver.findElement(getElement("password"));
		
	}
	
	public static WebElement login_btn()
	{
		return driver.findElement(getElement("login"));
		
	}
	public static WebElement logout_btn()
	{
		return driver.findElement(getElement("logout"));
		
	}

}
