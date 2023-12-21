package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	public String readDataFromProperties(String key) throws IOException {
		// step 1-->get the obj of external file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata/data.properties");
		// step 2-->create an obj for properties class
		Properties prop = new Properties();
		// step 3-->load the file
		prop.load(fis);
		// step 4-->get the data
		String data = prop.getProperty(key);
		return data;
	}

}
