package A1QA.Browser;

import Utils.MyLogger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChromeCaps {
    public static String @NotNull [] readChromeBrowserConfig() {
        try {
            String browserConfig = new String(Files.readAllBytes(Paths.get("src/main/java/config/chromeConfig.json")));
            JSONArray jsonArray = new JSONArray(browserConfig);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String browserMode = jsonObject.getString("browserMode");
            String language = jsonObject.getString("language");
            String remoteAllow = jsonObject.getString("remoteAllow");
            return new String[]{browserMode, language, remoteAllow};
        }catch (IOException e) {
            MyLogger.error("No options found for Chrome");
        }
        return new String[0];
    }
}


