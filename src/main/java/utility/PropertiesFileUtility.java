package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String getDataFromProperties(String Key) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/Config.properties");
		Properties pr=new Properties();
		pr.load(fis);
		String result = pr.getProperty(Key);
		return result;
	}
}