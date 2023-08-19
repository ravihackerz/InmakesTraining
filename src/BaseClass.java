

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowser() {
		driver.close();
	}

	public static void clickBtn(WebElement ele) {
		ele.click();
	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgName.png");
		FileUtils.copyFile(img, f);
	}

	public static Actions a;

	public static void moveTheCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}

	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
	}

	public static JavascriptExecutor js;

	public static void scrollThepage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguements[0].scrollIntoView(false)", tarWebEle);
	}

	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguements[0].scrollIntoView(true)", element);
	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("C:\\Users\\mohan\\eclipse-workspace\\FrameworksMaven\\excel\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("sheet");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		if (cellType == 1) {
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yy");
			String value1 = s.format(dd);
			System.out.println(value1);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
			System.out.println(valueOf);
		}
	}

	public static void createnewexcellfile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\mohan\\eclipse-workspace\\FrameworksMaven\\excel\\Datas.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Sheet1");
		Row createRow = mySheet.createRow(rowNum);
		Cell createCell = createRow.createCell(cellNum);
		createCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createcell(int getrow, int crecell, String newData) throws IOException {
		File f = new File("C:\\Users\\mohan\\eclipse-workspace\\FrameworksMaven\\excel\\Datas.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Sheet1");
		Row r = mySheet.getRow(getrow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createRow(int crerow, int crecell, String newData) throws IOException {
		File f = new File("C:\\Users\\mohan\\eclipse-workspace\\FrameworksMaven\\excel\\Datas.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Sheet1");
		Row r = mySheet.createRow(crerow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updateDataToParticularCell(int getTheRow, int getTheCell, String exisitingData,
			String writenewData) throws IOException {
		File f = new File("C:\\Users\\mohan\\eclipse-workspace\\FrameworksMaven\\excel\\Datas.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Sheet1");
		Row r = mySheet.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String stringCellValue = c.getStringCellValue();
		if (stringCellValue.equals(exisitingData)) {
			c.setCellValue(writenewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
}
