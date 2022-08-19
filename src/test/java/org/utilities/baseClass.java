package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass{
	
	public static WebDriver driver;
	public static void launch() {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
				
		}
	public static void loadUrl() {
		driver.get("https://www.amazon.com/");	
	}	
	public static void getData(int rowNum,int cellNum) throws IOException {
		
File f= new File("C:\\Users\\sidde\\eclipse-workspace\\MavenAutomationTesting\\src\\test\\resources\\Data\\SeleniumData.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook w= new XSSFWorkbook(fin);
		
		Sheet s= w.getSheet("Sheet1");
		
		Row row = s.getRow(rowNum);
		
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		
		String value="";
		if (cellType==1) {
			value = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat sim= new SimpleDateFormat("dd,MMMM,yyy");
			value = sim.format(d);
		}
		else {
			double d = cell.getNumericCellValue();
			long l= (long)d;
		value= String.valueOf(l);
		
		
		}
		
		
	}
	
		
		
		
		
		
		
		


}
