package genericUtitliy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import dummy.PropertiesFile;
/**
 * This is the class used to store all the utilities related to properties file
 * @author Mohit
 * 
 */
import net.bytebuddy.asm.Advice.This;
public class PropertiesUtility {
	
	String filePath;
	public PropertiesUtility(String filePath) {
		this.filePath= filePath;
	}

	 String val = PropertiesFile.CommonDataNinzaCrm;
	
	 /**
	  * It will return the value of the specified key
	  * @param key -- The key to get the value 
	  * @return A string value which is associated to the specified key
	  * @throws IOException
	  */
	public String getKey(String key) throws IOException {

		// Java representation file
		FileInputStream file = new FileInputStream(filePath);

		// Object of Properties
		Properties props = new Properties();

		// Load all the key value
		props.load(file);

		// return the key
		return props.getProperty(key);
	}

}
