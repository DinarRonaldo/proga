package proga.homework2_1;

import java.util.function.Predicate;

public class ex3 {
    public static void main(String[] args) {
        Predicate<String> isShort = s -> s.length() < 5;
        Predicate<String> hasSpam = s -> s.contains("buy");
        Predicate<String> isCaps = s -> s.equals(s.toUpperCase());
        Predicate<String> complexRule = isShort.negate().and(isCaps.or(hasSpam));
        checkComment("SIXSEVEN", complexRule);
        checkComment("hello BUY", complexRule);
        checkComment("iloveitis", complexRule);
        checkComment("itislovei", complexRule);
        checkComment("THIS IS SPAM BUY", complexRule);
    }
    public static void checkComment(String text, Predicate<String> rule) {
        if (rule.test(text)) {
            System.out.println("Удалено: " + text);
        } else {
            System.out.println("Подходит: " + text);
        }
    }
}
