package ranf.ranf;

import java.io.File;
import java.io.IOException;

import excel.Excel_Class;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static void main(String[] agrs)
	{
		/*Excel_Class.excelConection("data.xls", "sheet1");
		System.out.println(Excel_Class.getrows());*/
		try {
			File file = new File("D:\\keshav\\keshav\\ranf\\excelfiles\\data.xls");

			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sh = workbook.getSheet("Sheet1");
			int r = sh.getRows();
			System.out.println(r);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
