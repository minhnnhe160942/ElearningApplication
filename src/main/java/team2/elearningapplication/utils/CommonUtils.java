package team2.elearningapplication.utils;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class CommonUtils {
    private static Random random = new Random();

    public String getSessionId() {
        return UUID.randomUUID().toString();
    }

    public static String getOTP() {
        return new DecimalFormat("000000").format(random.nextInt(999999));
    }

    public static Integer getSessionID() {
        return random.nextInt();
    }

}
