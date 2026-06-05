package proga.homework1_5;

public interface MyHashSet<T> {
    boolean add(T item);
    boolean contains(T item);
    boolean remove(T item);
    int size();
}