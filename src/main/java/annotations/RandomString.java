package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.SecureRandom;
import java.util.Random;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomString {
    int length() default 10;
}

class RandomStringHelper {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    static private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }
    static public void setFields(Object obj) {
        Random rnd = new Random();
        for (java.lang.reflect.Field field : obj.getClass().getFields()) {
            RandomString rsa = field.getAnnotation(RandomString.class);
            if (field.isAnnotationPresent(RandomString.class)) {
                try {
                    field.set(obj, (generateRandomString(rsa.length())));
                } catch (IllegalAccessException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}