package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop;

    public static Properties getProperties() {

        if (prop == null) {
            try (FileInputStream fis =
                         new FileInputStream("src/test/resources/config/config.properties")) {

                prop = new Properties();
                prop.load(fis);

            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties");
            }
        }
        return prop;
    }
}
