package proga.classwork2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex1 {
    public static void main(String[] args) {
        List<String> logins = new ArrayList<>(Arrays.asList("kamil", "din", "anna", "an", "dmitry", "kuzya", "anton", "i", "serGey"));
        logins.removeIf(login -> login.length() < 4);
        System.out.println("после очистки: " + logins);
    }
}