package proga.homework2_1;

import java.util.function.Consumer;
import java.util.function.Function;

public class ex1 {
    public static void main(String[] args) {
        Function<String, Function<String, Consumer<String>>> curriedNotifier = token -> chatId -> message -> {
                    System.out.println("Message: " + message);
                };
        Consumer<String> myNotifier = curriedNotifier.apply("bublik182").apply("cht6767");
        processOrder("Сыр", myNotifier);
    }
    public static void processOrder(String item, Consumer<String> sender) {
        sender.accept("Заказ: " + item + ", создан");
    }
}