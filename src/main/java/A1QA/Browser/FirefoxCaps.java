package A1QA.Browser;

import Utils.MyLogger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FirefoxCaps {
    public static String @NotNull [] readFirefoxBrowserConfig()  {
        try {
            String browserConfig = new String(Files.readAllBytes(Paths.get("src/main/java/config/firefoxConfig.json")));
            JSONArray jsonArray = new JSONArray(browserConfig);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String browserMode = jsonObject.getString("browserMode");
            String language = jsonObject.getString("language");
            return new String[]{browserMode, language};
        }catch (IOException e) {
            MyLogger.error("No options found for firefox");
        }
        return new String[0];
    }
}
