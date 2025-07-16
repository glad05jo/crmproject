package Campaigns;

//passed
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;

import Generic_Utilities.Java_Utility;

import Pom_Rep.CampLookUpImgPage;
import Pom_Rep.CreateCampPage;
import Pom_Rep.HomePage;

import Pom_Rep.ValidateCampPage;

public class CreateCampTest  extends BaseClass{
	
	@Test
	public void CreateCamp() throws Throwable
	{
		HomePage homepage=new HomePage(drv);
		homepage.ClickMoreLink();
		homepage.ClickCampaignsLink();

		CampLookUpImgPage camplookup = new CampLookUpImgPage(drv);
		camplookup.clickcamplookupimg();

		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		Excel_Utility excel = new Excel_Utility();
		String exceldata = excel.getExcelValue("Campaign", 0, 0)+rannum;

		
		CreateCampPage createcamp =new CreateCampPage(drv);
		createcamp.getCampname();
		createcamp.savecampname();
		
		//ValidateCampPage validatecamppg =new ValidateCampPage(drv);
		//validatecamppg.validatecamppage(drv, exceldata);
		
	
		//drv.findElement(By.className("crmButton small save")).click();
		homepage.logoutapp();
	}
	

}
