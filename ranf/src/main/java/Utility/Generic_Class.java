package Utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.Base;

public class Generic_Class extends Base{
	
	public static void JsClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}

	public static void JSSendkeys(WebElement element, String data)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+data+"'",element);
	}

	public static Select Select_Dp(WebElement element)
	{
		return new Select(element);
	}
	public static List<String> DP_Handle_Verify(WebElement element)
	{
		List<String> myData=new ArrayList<String>();
		Select s=new Select(element);
		List<WebElement> list=s.getOptions();
		for(WebElement e:list)
		{
			String txt=e.getText();
			myData.add(txt);
		}
		return myData;
	}
	public static boolean Is_equals(List<String> l1,List<String> l2)
	{
		if(l1.size()!=l2.size())
		{
			return false;
		}
		for(String s:l1)
		{
			if(!l2.contains(s))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void screenshot()
	{
		try {
			Robot r = new Robot();
			BufferedImage bufferedImage = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bufferedImage, "png", new File(".\\screenshot\\"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String TakescreenShot(WebDriver driver,String screenshot)
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/screenshot/"+screenshot+dateName+".png";
		File fileDest = new File(dest);
		try {
			FileUtils.copyFile(src, fileDest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}
	


}
