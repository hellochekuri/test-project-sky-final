package sky.support;

import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper {
    private static ConfigHelper configHelper;;
    private static Properties properties;

    public static  String valueFor(final String keyName){
        String property = null;
        try {
            property = getInstance().getProperty(keyName);
        }catch (Throwable e){

        }


        return property;
    }

    private static ConfigHelper getInstance() throws Throwable{
        if(configHelper == null){
            properties = new Properties();
            populateProperties();
            configHelper = new ConfigHelper();
        }
        return  configHelper;
    }

    public static void populateProperties() throws Throwable {
        String propertiesFilePath = String.format("src/test/resources/test.properties");
        File propertiesFile = new File(propertiesFilePath);
        try{
            InputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(inputStream);
            inputStream.close();

        }catch (FileNotFoundException e){

        }


    }

    private String getProperty(final String key) {
        String value = properties.getProperty(key);
        if(value == null){
            throw new Error(String.format("Key %s not configured for environment %s", key));
        }
        return value;
    }
   ///////

}