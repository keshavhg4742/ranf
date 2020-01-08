package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class EmpPages extends Base {
	public static WebElement emp_btn()
	{
		return driver.findElement(getElement("employee"));
		
	}

}
