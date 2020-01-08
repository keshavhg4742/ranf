package testbase;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {

	public static Properties property=null;
	public static WebDriver driver;
	public static void loadProperty()
	{		
		try {
			File file = new File(".\\src\\main\\java\\configration\\ro.properties");

			FileReader reader = new FileReader(file);
			property = new Properties();
			property.load(reader);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void getBrowser()
	{		
		try {
			File file = new File(".\\src\\main\\java\\configration\\config.properties");

			FileReader reader = new FileReader(file);
			property = new Properties();
			property.load(reader);


		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public static By getElement(String key)
	{
		loadProperty();
		By loc=null;
		String value = property.getProperty(key);
		String loctype = value.split(":")[0];
		String locvalue = value.split(":")[1];
		switch (loctype) {
		case "id":
			loc=By.id(locvalue);
			break;

		case "xpath":
			loc=By.xpath(locvalue);
			break;

		case "name":
			loc=By.name(locvalue);
			break;

		}

		return loc;
	}
	public static String getConfig(String key)
	{
		getBrowser();
		return property.getProperty(key);

	}

}
