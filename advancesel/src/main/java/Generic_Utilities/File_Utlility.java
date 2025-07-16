package Generic_Utilities;

import java.io.*;
import java.util.Properties;

public class File_Utlility {
	
	/** 
	 * This method is used to read data from property file -external resource
	 * @author Gladish
	 * @throws Throwable 
	 */
		public String getPropertyKeyValue(String key) throws Throwable
		{
			FileInputStream fis= new FileInputStream("D:\\QSpider\\advsel\\vtigerlogin.properties");
			Properties pro = new Properties();
			pro.load(fis);
			String browser = pro.getProperty(key);
			
			return browser;
			
		}
	

}
