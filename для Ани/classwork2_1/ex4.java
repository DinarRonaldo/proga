package proga.classwork2_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex4 {
    public static <T> List<T> filterList(List<T> list, Validator<T> validator) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (validator.check(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, -5, 10, -20, 33);
        System.out.println("до фильтрв: "  + numbers);
        List<Integer> res = filterList(numbers, n -> n > 0);
        System.out.println("после фильтра: " + res);
    }
}
