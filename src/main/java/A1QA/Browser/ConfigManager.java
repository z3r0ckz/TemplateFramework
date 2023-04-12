package A1QA.Browser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private final Properties properties;

    public ConfigManager() {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
