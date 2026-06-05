package proga.classwork2_1;
import java.util.HashMap;
import java.util.Map;

public class ex2 {
    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Ноутбук", 100000);
        products.put("Мышка", 5000);
        products.put("Клавиатура", 8000);
        int discount = 15;
        products.replaceAll((key, value) -> value - (value * discount / 100));
        products.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
