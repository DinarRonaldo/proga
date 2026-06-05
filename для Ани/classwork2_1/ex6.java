package proga.classwork2_1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ex6 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Admin", "moderator_1", "guest", "super_admin", "bot_99");
        Predicate<String> isLongEnough = s -> s.length() > 5;
        Predicate<String> containsAdmin = s -> s.toLowerCase().contains("admin");
        Predicate<String> isNotBot = s -> s.toLowerCase().contains("bot") != true;
        Predicate<String> complexRule = isLongEnough.and(containsAdmin).and(isNotBot);
        for (String user : words) {
            if (complexRule.test(user)) {
                System.out.println(user);
            }
        }
    }
}
