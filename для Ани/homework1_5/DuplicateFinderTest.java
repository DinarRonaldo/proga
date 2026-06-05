package proga.homework1_5;

import java.util.UUID;

public class DuplicateFinderTest {
    private static String[] generateDataWithDuplicate(int size) {
        String[] data = new String[size];
        for (int i = 0; i < size - 1; i++) {
            data[i] = UUID.randomUUID().toString();
        }
        String duplicate = data[size - 2];
        data[size - 1] = duplicate;
        return data;
    }
    public static String findDuplicateWithList(String[] data) {
        MyList<String> list = new MyArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (list.contains(data[i])) {
                return data[i];
            }
            list.add(data[i]);
        }
        return null;
    }
    public static String findDuplicateWithSet(String[] data) {
        MyHashSet<String> set = new MyHashSetImpl<>();
        for (int i = 0; i < data.length; i++) {
            if (set.contains(data[i])) {
                return data[i];
            }
            set.add(data[i]);
        }
        return null;
    }
    public static void main(String[] args) {
        int size = 100000;
        String[] data = generateDataWithDuplicate(size);
        long startList = System.currentTimeMillis();
        String duplicateList = findDuplicateWithList(data);
        long endList = System.currentTimeMillis();
        long timeList = endList - startList;
        long startSet = System.currentTimeMillis();
        String duplicateSet = findDuplicateWithSet(data);
        long endSet = System.currentTimeMillis();
        long timeSet = endSet - startSet;
        System.out.println("Метод с MyArrayList: " + timeList + " ms");
        System.out.println("Метод с MyHashSet: " + timeSet + " ms");
        System.out.println("Дубликат найден: " + duplicateList);
    }
}