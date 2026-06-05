package proga.classwork2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ex3 {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> taxCalculator = percent -> price -> price + (price * percent / 100);
        Function<Integer, Integer> rtax = taxCalculator.apply(21);
        Function<Integer, Integer> ustax = taxCalculator.apply(12);
        List<Integer> prices = new ArrayList<>(Arrays.asList(100, 500, 1000));
        prices.forEach(price -> System.out.println(price + " - " + rtax.apply(price)));
        prices.forEach(price -> System.out.println(price + " - " + ustax.apply(price)));
    }
}