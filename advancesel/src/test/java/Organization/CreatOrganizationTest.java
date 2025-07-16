package Organization;


import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Pom_Rep.CreateOrgPage;
import Pom_Rep.HomePage;
import Pom_Rep.OrgookUpImgPage;
import Pom_Rep.ValidateCampPage;

public class CreatOrganizationTest extends BaseClass {
	
	@Test(retryAnalyzer =Generic_Utilities.RetryAnalyserImp.class )
	public void createorganization() throws Throwable
	{
	
		HomePage homepage=new HomePage(drv);
		homepage.ClickOrganizationsLink();
		
		OrgookUpImgPage orglookup = new OrgookUpImgPage(drv);
		orglookup.clickorganlookup();
		
		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		
		Excel_Utility excel = new Excel_Utility();
		String oname = excel.getExcelValue("Organization",0,0)+rannum;
		CreateOrgPage orgpage = new CreateOrgPage(drv);
		orgpage.createorgname(oname);
	
		orgpage.createorg();
		ValidateCampPage org= new ValidateCampPage(drv);
		 org.validateorg(drv, oname);
		
		homepage.logoutapp();
	}

}
