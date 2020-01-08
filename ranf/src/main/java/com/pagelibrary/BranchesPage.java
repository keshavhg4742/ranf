package com.pagelibrary;

import org.openqa.selenium.WebElement;

import testbase.Base;

public class BranchesPage extends Base {
	public static WebElement branch_btn()
	{
		return driver.findElement(getElement("branches"));
		
	}

}
