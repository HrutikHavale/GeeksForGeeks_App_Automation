package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties= new Properties();

    public static Properties readPropertyFileData(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
