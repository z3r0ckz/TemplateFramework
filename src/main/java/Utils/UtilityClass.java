package Utils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UtilityClass {
    public static String @NotNull [] readChromeBrowserConfig() throws IOException {
        String browserConfig = new String(Files.readAllBytes(Paths.get("src/main/resources/chromeConfig.json")));
        JSONArray jsonArray = new JSONArray(browserConfig);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String browserMode = jsonObject.getString("browserMode");
        String language = jsonObject.getString("language");
        String remoteAllow = jsonObject.getString("remoteAllow");

        return new String[]{browserMode,language,remoteAllow};
    }
    public static String @NotNull [] readFirefoxConfig() throws IOException {
        String browserConfig = new String(Files.readAllBytes(Paths.get("src/main/resources/firefoxConfig.json")));
        JSONArray jsonArray = new JSONArray(browserConfig);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String browserMode = jsonObject.getString("browserMode");
        String language = jsonObject.getString("language");
        String remoteAllow = jsonObject.getString("remoteAllow");

        return new String[]{browserMode,language,remoteAllow};
    }
}
