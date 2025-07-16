package TestNG;



import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert1 {
@Test
	public void Assert1Test()
	{
		System.out.println("step 1");
		System.out.println("step 1");
		Assert.assertEquals(false, false);
		System.out.println("step 1");
		System.out.println("step 1");
	}
	
@Test
public void m1()
{
	System.out.println("step 1");
	System.out.println("step 1");
	Assert.assertEquals(false, true);
	System.out.println("step 1");
	System.out.println("step 1");
}
@Test
public void m2()
{
	String exdata="Qspiders";
	String actdata="Qspiders   ";
	Assert.assertEquals(actdata,exdata,"Assert Fail");
	System.out.println("Assert pass");
	
}
@Test
public void m3()
{
	int exdata=10;
	int actdata= 20;
	Assert.assertEquals(actdata,exdata,"Assert Fail");
	System.out.println("Assert pass");
	
}
@Test
public void m4()
{
	int exdata=10;
	int actdata= 20;
	Assert.assertEquals(actdata,exdata,"Assert Equal");
	System.out.println("Assert not equal");
	
}
}
