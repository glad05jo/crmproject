package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test (dataProvider = "getData")
public class DataProviderPrac {

	
	public void booktickets(String source,String destination,String people)
	{
		System.out.println("Book Ticket from " + source + " to " + destination + " " + people);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0] ="Chennai";
		obj[0][1]="kanyakumari";
		obj[0][2]="10";
		
		obj[1][0] ="Chennai";
		obj[1][1]="coimbator";
		obj[1][2]="20";
		
		return obj;
	}

}
