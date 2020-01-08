package com.repositery;

import org.testng.annotations.Test;

import excel.Excel_Class;

public class TestExecution extends Repository{
	@Test(priority=1)
	public void verify_Launch()
	{
		
		launch_TC();
	}

	@Test(priority=2)
	public void verify_Login()
	{
		Excel_Class.excelConection("data.xls", "Sheet1");
		
		//for(int row=1;row<=Excel_Class.getrows();row++)
		//{
			String usn=Excel_Class.readData(0, 1);
			
			String pwd=Excel_Class.readData(1, 1);
			Login_Tc(usn,pwd);
		//}
	}
	@Test(priority=3)
	public void branch_Create()
	{
		Excel_Class.excelConection("data.xls", "Sheet2");
		Branch_Tc();
		String branchname=Excel_Class.readData(0, 1);
		String address=Excel_Class.readData(1, 1);
		String zipcode=Excel_Class.readData(2, 1);
		String country=Excel_Class.readData(3, 1);
		String state=Excel_Class.readData(4, 1);
		String city=Excel_Class.readData(5, 1);
		create_Branch_Tc(branchname,address,zipcode,country,state,city);
	}
	/*@Test(priority=4)
	public void role_Create()
	{
		Roles_Tc();
		Create_Roles_Tc();
	}
	@Test(priority=5)
	public void user_Create()
	{
		Users_Tc();
		Create_Users_Tc();
	}
	@Test(priority=6)
	public void emp_Create()
	{
		Emp_Tc();
		Create_Emp_Tc();
	}
	 */

}
