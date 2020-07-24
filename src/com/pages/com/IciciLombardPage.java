package com.pages.com;

import java.io.IOException;

public class IciciLombardPage {

	public static String cashlessHospitalButton = "//img[@src='/images/default-source/icons/hospitals.gif']";
	public static String selectState = "//div[@class='state title']//div[@class='basic_dd']//div[@class='sbHolder']//ul[@class='sbOptions']";
	public static String selectCity = "//div[@class='basic_dd']//a[contains(text(),'Select City')]";
	public static String searchButton = "//div[@class='srhbox']//a[contains(text(),'search')]";

	public static String hospitalName1 = "//table[@id='HospitalList']//tbody//tr[";
	public static String hospitalName2 = "]//td[2]";
	public static String address1 = "//table[@id='HospitalList']//tbody//tr[";
	public static String address2 = "]//td[3]";
	public static String city1 = "//table[@id='HospitalList']//tbody//tr[";
	public static String city2 = "]//td[4]";
	public static String state1 = "//table[@id='HospitalList']//tbody//tr[";
	public static String state2 = "]//td[5]";
	public static String contactNumber1 = "//table[@id='HospitalList']//tbody//tr[";
	public static String contactNumber2 = "]//td[6]";

	@SuppressWarnings("resource")
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {


	}

}
