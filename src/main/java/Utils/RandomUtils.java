package Utils;
import java.util.Random;
public class RandomUtils {
    private static final String characters = "abcdefghijklmnopqrstuvwxyz";
    private static final String domain = "@example.com";
    private static final int usernameLength = 8;
    private static final String passwordChar = "abcdefghijklmnopqrstuvwxyz123456789";
    private static final int passwordLength = 10;
    private static final Random random = new Random();

    public static String generateRandomUsername() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < usernameLength; i++) {
            builder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return builder.toString();
    }

    public static String generateRandomPassword() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            builder.append(passwordChar.charAt(random.nextInt(passwordChar.length())));
        }
        return builder.toString();
    }
    public static String generateRandomEmail() {
        return generateRandomUsername() + domain;
    }
}
