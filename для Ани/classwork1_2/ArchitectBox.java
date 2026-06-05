package proga.classwork1_2;

public class ArchitectBox<T> {
    private T value;
    public ArchitectBox(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        ArchitectBox<String> stringBox = new ArchitectBox<>(new String());
        System.out.println("значение: " + stringBox.getValue());
        ArchitectBox<Integer> intBox = new ArchitectBox<>(42);
        System.out.println("значение: " + intBox.getValue());
    }
}