package StepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {
    static FileReader fileReader= null;



    public static void main(String a[]) {

        try {
            String propertyPath = System.getProperty("user.dir") + "/src/test/java/Configuration/Config.properties";
            fileReader = new FileReader(propertyPath);
            Properties properties = new Properties();
            properties.load(fileReader);
            String url = properties.getProperty("baseURI");
            String pathvalue = properties.getProperty("basePath");
            String ZeroAuthor = properties.getProperty("ZerothAuthor");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
