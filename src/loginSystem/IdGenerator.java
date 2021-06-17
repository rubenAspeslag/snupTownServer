package loginSystem;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class IdGenerator {
    // source: https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
    // (I did not write this function)!!!
    private IdGenerator() {
        throw new IllegalStateException("Utility Class");
    }

    public static String generate() {
        // length is bounded by 256 Character
        int n = 20;
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, StandardCharsets.UTF_8);
        // Create a StringBuffer to store the result
        StringBuilder r = new StringBuilder();
        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {
            char ch = randomString.charAt(k);
            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }
        // return the resultant string
        return r.toString();
    }
}
