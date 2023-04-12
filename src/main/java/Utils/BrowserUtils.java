package Utils;

import A1QA.Browser.Singleton;

import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    public static int getActualIndexTab() throws IOException {
        int currentWindowIndex = -1;
        String currentWindowHandle = Singleton.Driver("chrome").getWindowHandle();

        Set<String> windowHandles = Singleton.Driver("chrome").getWindowHandles();
        int i = 0;
        for (String windowHandle : windowHandles) {
            if (windowHandle.equals(currentWindowHandle)) {
                currentWindowIndex = i;
                break;
            }
            i++;
        }
        return currentWindowIndex;
    }

    public static String getHeader() throws IOException {
        String getHeaderText;
        getHeaderText = Singleton.Driver("chrome").getTitle();


        return getHeaderText;
    }
}
