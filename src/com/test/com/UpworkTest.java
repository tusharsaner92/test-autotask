package com.test.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pages.com.UpworkPage;

public class UpworkTest {

	UpworkPage up = new UpworkPage();

	@Test
	public void test() throws Exception {

		String path = "/Users/apple/eclipse-workspace/SeleniumTest/chromedriver";
		String url = "https://www.upwork.com/";
		String jobTitle = "Software Testing";

		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		driver.findElement(By.xpath(UpworkPage.searchBox)).sendKeys(jobTitle);
		driver.findElement(By.xpath(UpworkPage.searchButton)).click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}

}
