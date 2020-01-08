package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class CreateNewUserPage extends Base {
	
	public static WebElement new_users_btn()
	{
		return driver.findElement(getElement("newuser"));

	}
	public static WebElement rolename_txtbox()
	{
		return driver.findElement(getElement("userrole"));

	}
	public static WebElement custbranch_txtbox()
	{
		return driver.findElement(getElement("userbranch"));

	}
	public static WebElement custid_txtbox()
	{
		return driver.findElement(getElement("custid"));

	}
	public static WebElement custname_txtbox()
	{
		return driver.findElement(getElement("custname"));

	}
	public static WebElement username_txtbox()
	{
		return driver.findElement(getElement("custusername"));

	}
	public static WebElement userloginpwd_txtbox()
	{
		return driver.findElement(getElement("custloginpwd"));

	}
	public static WebElement usertxnpwd_txtbox()
	{
		return driver.findElement(getElement("custtxnpwd"));

	}
	public static WebElement usersubmit_btn()
	{
		return driver.findElement(getElement("csutsubmit"));

	}
	public static WebElement userreset_btn()
	{
		return driver.findElement(getElement("resetuserdetail"));

	}
	public static WebElement usercancel_btn()
	{
		return driver.findElement(getElement("cancelcust"));

	}

}
