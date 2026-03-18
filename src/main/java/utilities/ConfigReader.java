package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/config.properties";

    public ConfigReader() {
        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser not specified in the config.properties file.");
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the config.properties file.");
    }

    public int getImplicitWait() {
        String wait = properties.getProperty("implicit.wait");
        if (wait != null) return Integer.parseInt(wait);
        else return 10;
    }

    public int getExplicitWait() {
        String wait = properties.getProperty("explicit.wait");
        if (wait != null) return Integer.parseInt(wait);
        else return 20;
    }
}
