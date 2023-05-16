package helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.security.SecureRandom;
import java.util.Locale;

public class UserCreations {

    public final static String USER_NAME = "kiev25";
    public final static String WRONG_USER_NAME = "kiev255";
    public final static String PASSWORD = "kiev25";
    public final static String SIGNUP_PASSWORD = "Qq123456";
    public final static String USER_EMAIL = "deputatsereza@gmail.com";


    public static String getRandomUserEmail() {
        return "serhii.pasa" + System.currentTimeMillis() + "@" + "gmail.com";
    }

    public static String getGeneratePhoneNumber() {
        SecureRandom random = new SecureRandom();

        int firstThreeDigits = random.nextInt(900) + 100;
        int lastThreeDigits = random.nextInt(900) + 100;
        int lastFourDigits = random.nextInt(9000) + 1000;

        String phoneNumber = String.format(Locale.ENGLISH, "%d%03d%04d",  firstThreeDigits,lastThreeDigits, lastFourDigits);
        return phoneNumber;
    }
    @Test
    public void text(){
        System.out.println( System.currentTimeMillis());
        System.out.println( RandomStringUtils.random(2, "wqr234"));
        System.out.println(RandomStringUtils.randomNumeric(3));
    }
}
