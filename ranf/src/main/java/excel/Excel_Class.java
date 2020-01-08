package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import testbase.Base;

public class Excel_Class extends Base {
	static String folderpath=getConfig("excelpath");
	static Sheet sh;
	static WritableWorkbook writableWorkbook;
	static WritableSheet writableSheet;

	public static void excelConection(String filename,String sheetname)
	{
		try {
			File file = new File(folderpath+filename);

			Workbook workbook = Workbook.getWorkbook(file);
			sh = workbook.getSheet(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static int getrows()
	{
		return sh.getRows();
	}
	public static int getcolumns()
	{
		return sh.getColumns();
	}

	public static String readData(int col,int row)
	{
		return sh.getCell(col, row).getContents();
	}

	public static void output_execel_connection(String ipfile,String opfile,String sheetname)
	{
		try {
			FileInputStream fis=new FileInputStream(folderpath+ipfile);
			Workbook workbook = Workbook.getWorkbook(fis);
			sh=workbook.getSheet(sheetname);
			FileOutputStream fos=new FileOutputStream(folderpath+opfile);
			writableWorkbook = Workbook.createWorkbook(fos,workbook);
			writableSheet = writableWorkbook.getSheet(sheetname);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void write_data(int c,int r,String data)
	{
		Label label = new Label(c, r, data);
		try {
			writableSheet.addCell(label);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
