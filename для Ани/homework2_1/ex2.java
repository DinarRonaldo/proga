package proga.homework2_1;

import java.util.function.Function;

public class ex2 {
    public static void main(String[] args) {
        Function<String, String> trimmer = s -> s.trim();
        Function<String, String> toLower = s -> s.toLowerCase();
        Function<String, String> firstUpper = s -> {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        };
        Function<String, String> fullClean = trimmer.andThen(toLower).andThen(firstUpper);
        Function<String, String> quickClean = trimmer.andThen(toLower);
        String dirty = "  iVaN_iVaNoV  ";
        System.out.println("Было: " + dirty);
        System.out.println("Полный клининг: " + fullClean.apply(dirty));
        System.out.println("Быстрый клининг: " + quickClean.apply(dirty));
    }
}