package proga.homework1_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сценарий А:");
        ItemStorage<Integer> storageA = new ItemStorage<>(100);
        System.out.println("Хранилище: " + storageA.getValue());
        storageA.compareWith(100);

        System.out.println();
        System.out.println("Сценарий Б:");
        ItemStorage<Integer> storageB = new ItemStorage<>(200);
        System.out.println("Хранилище: " + storageB.getValue());
        storageB.compareWith(200);

        System.out.println();
        System.out.println("Сценарий В:");
        ItemStorage<Fraction> storageC = new ItemStorage<>(new Fraction(1, 2));
        System.out.println("Хранилище: " + storageC.getValue());
        storageC.compareWith(new Fraction(1, 2));
    }
}