package Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static final Properties PROPS;

    static {
        PROPS = new Properties();
        try{
            PROPS.load(new FileInputStream("src/Files/vehicles.properties"));
        } catch (IOException e) {
            System.out.println("Error while loading properties file:" + e.getMessage());
        }
    }
}
