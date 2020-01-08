package com.repositery;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.pagelibrary.BranchesPage;
import com.pagelibrary.CreateBranchPage;
import com.pagelibrary.CreateEmpPage;
import com.pagelibrary.CreateNewUserPage;
import com.pagelibrary.CreateRolePage;
import com.pagelibrary.EmpPages;
import com.pagelibrary.LoginPage;
import com.pagelibrary.UserPages;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Generic_Class;
import testbase.Base;

public class Repository extends Base{

	ExtentReports extent;
	ExtentTest Test;
	@BeforeTest
	public void Generate_ER()
	{
		extent=new ExtentReports(".\\extentreport\\report.html",true);
	}

	@BeforeMethod
	public void Send_method_to_report(Method method)
	{
		Test=extent.startTest((this.getClass().getSimpleName()+" : : "+method.getName()));
		Test.assignCategory("Regression");
		Test.assignAuthor("Keshav");

	}
	public void launch_TC()
	{

		Test.log(LogStatus.INFO, "Verify The RanfordBank");
		Test.log(LogStatus.INFO, "Test Case ID :- c001");
		System.setProperty(getConfig("chromedrivername"),getConfig("chromedriverpath"));
		driver = new ChromeDriver();
		
		Test.log(LogStatus.INFO, "Launching the Browser");
		driver.get(getConfig("build1"));
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		Test.log(LogStatus.INFO, "Navigating  the Url");
		driver.manage().window().maximize();
		Test.log(LogStatus.INFO, "Browser is maximized");
		String ActualUrl=driver.getCurrentUrl();
		String ExpUrl=getConfig("build1");   // "ranford";


		try {

			Assert.assertEquals(ActualUrl,ExpUrl);

			Test.log(LogStatus.PASS, "My expUrl is "+ExpUrl+" is matching with an ActualUrl :- "+ActualUrl);
			Test.log(LogStatus.INFO, "Launch Is Success");

		}
		catch(Exception e){
			Test.log(LogStatus.FAIL, "My expUrl is "+ExpUrl+" is not  matching with an ActualUrl :- "+ActualUrl);
			Test.log(LogStatus.INFO, "Launch Is Failed");
			//Generic_Class.screenshot();


		}

	}
	/*@AfterMethod
	public void save_report()
	{
		extent.flush();
	}*/


	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Test.log(LogStatus.FAIL,"Test case is failed :"+result.getName()); 
			Test.log(LogStatus.FAIL,"Test case is failed"+result.getThrowable()); 
			// String screenshot=Generic_Class.TakescreenShot(driver,result.getName());
			Test.log(LogStatus.FAIL, Test.addScreenCapture(Generic_Class.TakescreenShot(driver,result.getName())));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			Test.log(LogStatus.SKIP,"Test case is skipped :"+result.getName()); 
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			Test.log(LogStatus.PASS,"Test case is passed :"+result.getName()); 
		}
		extent.flush();
		//extent.endTest(extentTest);
		//driver.close();
	}

	public void Login_Tc(String username,String password) {

		Test.log(LogStatus.INFO, "enterd username");
		Generic_Class.JSSendkeys(LoginPage.uesrName_txtbox(),username);
		Test.log(LogStatus.INFO, "enterd password");
		Generic_Class.JSSendkeys(LoginPage.password_txtbox(),password);
		Test.log(LogStatus.INFO, "click on login btn");
		Generic_Class.JsClick(LoginPage.login_btn());
		String Actualtitle=driver.getTitle();
		String ExpUrltitle="RANFORD BANK";

		try {
			Assert.assertEquals(Actualtitle, ExpUrltitle);
			Test.log(LogStatus.PASS, "My expUrl is "+ExpUrltitle+" is matching with an ActualUrl :- "+Actualtitle);
			Test.log(LogStatus.INFO, "Login Is Success");

		}
		catch(Exception e){
			Test.log(LogStatus.FAIL, "My expUrl is "+ExpUrltitle+" is matching with an ActualUrl :- "+Actualtitle);
			Test.log(LogStatus.INFO, "Login Is failed");

		}

	}

	public void Branch_Tc() {
		try {
			Assert.assertTrue(BranchesPage.branch_btn().isDisplayed());
			Test.log(LogStatus.INFO, "click to branch btn");
			Generic_Class.JsClick(BranchesPage.branch_btn());
		}
		catch (Exception e) {
			Test.log(LogStatus.INFO, "branches btn not displayed");
		}
	}

	public void create_Branch_Tc(String branchname,String address,String zipcode,String country,String State,String city) {

		Test.log(LogStatus.INFO, "click to New branch btn");
		Generic_Class.JsClick(CreateBranchPage.new_branch_btn());
		Test.log(LogStatus.INFO, "enter the branch name");
		Generic_Class.JSSendkeys(CreateBranchPage.branchname_txtbox(), branchname);
		Test.log(LogStatus.INFO, "enter the branch address");
		Generic_Class.JSSendkeys(CreateBranchPage.adress_txtbox(), address);
		Test.log(LogStatus.INFO, "enter the branch zipcode");
		Generic_Class.JSSendkeys(CreateBranchPage.zipcode_txtbox(), zipcode);

		List<String> expected_country = new ArrayList<>();
		expected_country.add("INDIA");expected_country.add("UK");expected_country.add("USA");expected_country.add("Select");
		boolean expect_result = Generic_Class.Is_equals(expected_country, Generic_Class.DP_Handle_Verify(CreateBranchPage.country_select_txtbox()));

		try
		{
			Assert.assertTrue(expect_result);
			Test.log(LogStatus.INFO, "enter the branch zipcode");
			Generic_Class.Select_Dp(CreateBranchPage.country_select_txtbox()).selectByVisibleText(country);
			Test.log(LogStatus.PASS,"country is selected sucessfully");

		}
		catch (Exception e) {
			Test.log(LogStatus.FAIL,"country selection is mismatch");
		}

		String text = Generic_Class.Select_Dp(CreateBranchPage.country_select_txtbox()).getFirstSelectedOption().getText();

		System.out.println(text);

		if(text.equals("INDIA"))
		{
			Generic_Class.Select_Dp(CreateBranchPage.state_txtbox()).selectByVisibleText(State);
			String st = Generic_Class.Select_Dp(CreateBranchPage.state_txtbox()).getFirstSelectedOption().getText();
			Test.log(LogStatus.PASS,"state is selected sucessfully"+st);
			if(st.equals("Karnataka"))
			{
				Generic_Class.Select_Dp(CreateBranchPage.city_txtbox()).selectByVisibleText(city);
				Test.log(LogStatus.PASS,"city is selected sucessfully");

			}
			else
			{
				System.out.println("different state selected");
			}
		}
		else if(text.equals("UK"))
		{
			Generic_Class.Select_Dp(CreateBranchPage.state_txtbox()).selectByVisibleText(State);
			String st = Generic_Class.Select_Dp(CreateBranchPage.state_txtbox()).getFirstSelectedOption().getText();
			if(st.equals("England"))
			{
				Generic_Class.Select_Dp(CreateBranchPage.city_txtbox()).selectByVisibleText(city);

			}
			else
			{
				System.out.println("different state selected");
			}
		}
		else
		{
			Generic_Class.Select_Dp(CreateBranchPage.state_txtbox()).selectByVisibleText(State);
			String st = Generic_Class.Select_Dp(CreateBranchPage.state_txtbox()).getFirstSelectedOption().getText();
			if(st.equals("England"))
			{
				Generic_Class.Select_Dp(CreateBranchPage.city_txtbox()).selectByVisibleText(city);

			}
			else
			{
				System.out.println("different state selected");
			}
		}


		/*Generic_Class.JsClick(CreateBranchPage.submit_btn());
		driver.switchTo().alert().accept();*/
	}




	public void Roles_Tc() {
		Generic_Class.JsClick(CreateRolePage.roles_btn());
	}

	public void Create_Roles_Tc() {
		Generic_Class.JsClick(CreateRolePage.new_role_btn());
		Generic_Class.JSSendkeys(CreateRolePage.rolename_txtbox(), "Accountan");
		Generic_Class.JSSendkeys(CreateRolePage.roledesc_txtbox(), "maintain acc");
		Generic_Class.Select_Dp(CreateRolePage.roletype_txtbox()).selectByVisibleText("E");
		Generic_Class.JsClick(CreateRolePage.rolesubmit_btn());
		driver.switchTo().alert().accept();
	}

	public void Users_Tc() {
		Generic_Class.JsClick(UserPages.users_btn());
	}

	public void Create_Users_Tc() {

		Generic_Class.JsClick(CreateNewUserPage.new_users_btn());
		Generic_Class.Select_Dp(CreateNewUserPage.rolename_txtbox()).selectByVisibleText("Accounts");
		Generic_Class.Select_Dp(CreateNewUserPage.custbranch_txtbox()).selectByVisibleText("122233");
		Generic_Class.Select_Dp(CreateNewUserPage.custid_txtbox()).selectByVisibleText("");
		Generic_Class.JSSendkeys(CreateNewUserPage.custname_txtbox(), "viraj");
		Generic_Class.JSSendkeys(CreateNewUserPage.username_txtbox(), "vir123");
		Generic_Class.JSSendkeys(CreateNewUserPage.userloginpwd_txtbox(), "vir123");
		Generic_Class.JSSendkeys(CreateNewUserPage.usertxnpwd_txtbox(), "123vir");
		Generic_Class.JsClick(CreateNewUserPage.usersubmit_btn());
	}

	public void Emp_Tc() {
		Generic_Class.JsClick(EmpPages.emp_btn());
	}

	public void Create_Emp_Tc() {

		Generic_Class.JsClick(CreateEmpPage.new_emp_btn());
		Generic_Class.JSSendkeys(CreateEmpPage.empname_txtbox(), "viraj");
		Generic_Class.JSSendkeys(CreateEmpPage.loginpwd_txtbox(), "12345");
		Generic_Class.Select_Dp(CreateEmpPage.role_txtbox()).selectByVisibleText("ABC");
		Generic_Class.Select_Dp(CreateEmpPage.branch_select_txtbox()).selectByVisibleText("122233");
		Generic_Class.JsClick(CreateEmpPage.submit_btn());
	}

}
