package proga.homework1_1;

public class ItemStorage<T> {
    private T value;

    public ItemStorage(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void compareWith(T otherValue) {
        if (value == null || otherValue == null) {
            System.out.println("Опачки! Ревизия невозможна, объект не найден");
            return;
        }
        if (value.equals(otherValue)) {
            System.out.println("Значения идентичны. Контроль качества пройден");
        } else {
            System.out.println("Значения не совпадают. Требуется пересчёт!");
        }
    }
}