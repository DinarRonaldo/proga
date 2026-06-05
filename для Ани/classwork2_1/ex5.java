package proga.classwork2_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ex5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> frequency = new HashMap<>();
        words.forEach(word -> frequency.merge(word, 1, (old, newV) -> old + newV));
        System.out.println(frequency);
    }
}
