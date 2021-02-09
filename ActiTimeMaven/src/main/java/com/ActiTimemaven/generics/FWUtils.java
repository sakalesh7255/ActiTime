package com.ActiTimemaven.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtils {
	
	public static void VerifyPageTitle(WebDriver driver, String ExpectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(ExpectedTitle));
		String actualTitle= driver.getTitle();
		if (actualTitle.equals(ExpectedTitle)) {
			System.out.println("The expected title is displayed: " + ExpectedTitle);
		}else {
			System.out.println("The acuatl title is dispayled: " + actualTitle);
		}
		}
	
	public static String read_XL_Data(String path, String SheetName, int row, int cell) {
		String data = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(SheetName).getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void set_XL_Data(String path, String SheetName, int row, int cell, int data) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(SheetName).getRow(row).getCell(cell).setCellValue(data);
			
			wb.write(new FileOutputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void read_last_rowcount(String path, String sheetName, int row, int cell) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void takeScreenshot(WebDriver driver, String path) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dsc = new File(path);
			FileUtils.copyFile(src, dsc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
