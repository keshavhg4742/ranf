package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class UserPages extends Base{
	public static WebElement users_btn()
	{
		return driver.findElement(getElement("users"));

	}

}
