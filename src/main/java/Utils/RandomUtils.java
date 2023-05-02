package Utils;
import java.util.Random;
public class RandomUtils {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DOMAIN = "@example.com";
    private static final int USERNAME_LENGTH = 8;
    private static final String PASSWORD_CHARACTERS = "abcdefghijklmnopqrstuvwxyz123456789";
    private static final int PASSWORD_LENGTH = 10;
    private static final Random random = new Random();

    public static String generateRandomUsername() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < USERNAME_LENGTH; i++) {
            builder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return builder.toString();
    }

    public static String generateRandomPassword() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            builder.append(PASSWORD_CHARACTERS.charAt(random.nextInt(PASSWORD_CHARACTERS.length())));
        }
        return builder.toString();
    }
    public static String generateRandomEmail() {
        return generateRandomUsername() + DOMAIN;
    }
}
