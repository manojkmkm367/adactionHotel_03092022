package org.Hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	private void testing() {
		// TODO Auto-generated method stub
// dummy testing me
	}
	
	
	public static void launchChromeBrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.google.com/");
	}
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void navigateToUrl(String URL) {
		
		driver.navigate().to(URL);

	}
	
	
	
	
	
	
	public static void elementSendKey(WebElement element , String data) {
				element.sendKeys(data);		

	}
	
	public static void elementSelectByValue(WebElement element , String value){
		
	Select select= new Select(element);
	select.selectByVisibleText(value);
	}
	
	public static String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}
	
	public static void elementClick(WebElement element ) {
		element.click();	

}


	public static String getDataFromCell(String sheetName, int rowIndex,int cellIndex ) throws IOException {
		String returnCell= null;
		File file = new File("C:\\Users\\dell\\eclipse-workspace\\AdactinhotelappMaven\\dataFolder\\testdata.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case NUMERIC:
			if( DateUtil.isCellDateFormatted(cell)) 
			{
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				returnCell = dateFormat.format(dateCellValue);

			}else {
				double numericCellValue = cell.getNumericCellValue();
				//		BigDecimal bigDecimal = BigDecimal.valueOf(numericCellValue);
				long round = Math.round(numericCellValue);
				if(round==numericCellValue)
				{
					returnCell = String.valueOf(round);
				}else {
					returnCell= String.valueOf(numericCellValue);
				}
			}
			break;

		case STRING:
			returnCell = cell.getStringCellValue();
			break;
		default:
			break;
		}
		return returnCell;
	}

	public static void putDataToCell(String sheetName, int rowIndex, int cellIndex,String data) throws IOException {
		File file = new File("C:\\Users\\dell\\eclipse-workspace\\AdactinhotelappMaven\\dataFolder\\testdata.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell createCell = row.createCell(cellIndex);
		createCell.setCellValue(data);
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
