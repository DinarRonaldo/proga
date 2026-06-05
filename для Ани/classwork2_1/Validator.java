package proga.classwork2_1;

@FunctionalInterface
public interface Validator<T> {
    boolean check(T item);
}
