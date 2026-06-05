package proga.homework1_5;

public interface MyList<T> {
    void add(T item);
    void add(int index, T item);
    T get(int index);
    T remove(int index);
    int size();
    boolean contains(T item);
}