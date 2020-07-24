package com.test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pages.com.IciciLombardPage;

public class IciciLombardTest extends IciciLombardPage {

	IciciLombardPage ilp = new IciciLombardPage();
	WebDriver driver = new ChromeDriver();

	@Test
	public void searchHospitalNames() throws IOException {

		String path = "/Users/apple/eclipse-workspace/SeleniumTest/chromedriver";
		String url1 = "https://www.icicilombard.com/campaigns/health-insurance/health-insurance-pune";
		String url2 = "https://www.icicilombard.com/campaigns/health-insurance/health-insurance-mumbai";

		System.setProperty("webdriver.chrome.driver", path);
//		WebDriver driver = new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(IciciLombardPage.searchButton)).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='HospitalList']//tbody//tr"));
		int numberOfRows1 = rows.size();

		excelData(numberOfRows1, 0);

		driver.get(url2);
		driver.findElement(By.xpath(IciciLombardPage.searchButton)).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='HospitalList']//tbody//tr"));
		int numberOfRows2 = rows1.size();

		excelData(numberOfRows2, 1);

		File src = new File("/Users/apple/eclipse-workspace/SeleniumTest/ExcelOutput/testFile.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet firstValue = wb.getSheetAt(0);
		XSSFSheet secondValue = wb.getSheetAt(1);
		XSSFSheet finalSheet = wb.getSheetAt(2);
		int p = 1;
		for (int i = 1; i < numberOfRows1; i++) {

			String name1 = firstValue.getRow(i).getCell(0).getStringCellValue();

			for (int j = 1; j < numberOfRows2; j++) {

				String name2 = secondValue.getRow(j).getCell(0).getStringCellValue();

				if (name1.equals(name2)) {

					Row rw = finalSheet.createRow(p);
					Cell cl = rw.createCell(0);
					cl.setCellValue(name1);
					FileOutputStream fout = new FileOutputStream(src);
					wb.write(fout);
					p++;
				}

			}

		}

		driver.quit();
	}

	public void excelData(int rowCounts, int sheetNumber) throws IOException {

		File src = new File("/Users/apple/eclipse-workspace/SeleniumTest/ExcelOutput/testFile.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet = wb.getSheetAt(sheetNumber);

		for (int i = 1; i < rowCounts; i++) {

			Row rw = Sheet.createRow(i);
			Cell cl1 = rw.createCell(0);
			String hospitalName = driver
					.findElement(By.xpath(IciciLombardPage.hospitalName1 + i + IciciLombardPage.hospitalName2))
					.getText();
			System.out.println(hospitalName);
			cl1.setCellValue(hospitalName);

			Cell cl2 = rw.createCell(1);
			String address = driver.findElement(By.xpath(IciciLombardPage.address1 + i + IciciLombardPage.address2))
					.getText();
			System.out.println(address);
			cl2.setCellValue(address);

			Cell cl3 = rw.createCell(2);
			String city = driver.findElement(By.xpath(IciciLombardPage.city1 + i + IciciLombardPage.city2)).getText();
			System.out.println(city);
			cl3.setCellValue(city);

			Cell cl4 = rw.createCell(3);
			String state = driver.findElement(By.xpath(IciciLombardPage.state1 + i + IciciLombardPage.state2))
					.getText();
			System.out.println(state);
			cl4.setCellValue(state);

			Cell cl5 = rw.createCell(4);
			String contactNumber = driver
					.findElement(By.xpath(IciciLombardPage.contactNumber1 + i + IciciLombardPage.contactNumber2))
					.getText();
			System.out.println(contactNumber);
			cl5.setCellValue(contactNumber);

			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);

		}

	}

}
