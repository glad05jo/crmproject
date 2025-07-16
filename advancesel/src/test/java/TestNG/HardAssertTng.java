package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTng {
	
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "B");//---->Assertion Fail
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m2()
	{
		String expData="Qspiders";
		String actData="Qspiders";
		Assert.assertEquals(actData, expData);
		
	}
	
	@Test
	public void m3()
	{
		String expData="Qspiders";
		String actData="Qspiders";
		Assert.assertEquals(actData, expData, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m4()
	{
		int ExpData=10;
		int actData=20;
		Assert.assertEquals(actData, ExpData, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m5()
	{
		int expData=10;
		int actData=20;
		Assert.assertNotEquals(actData, expData,"ASSERT EQUAL");
		System.out.println("ASSERT NOT EQUAL");
	}

}
