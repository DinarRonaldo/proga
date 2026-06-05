package proga.homework1_5;

public class NewsFeedTest {
    public static void generateFeed(MyList<String> list, int amount) {
        for (int i = 0; i < amount; i++) {
            list.add(0, "Новость " + i);
        }
    }

    public static void main(String[] args) {
        int amount = 100000;
        MyArrayList<String> arrayList = new MyArrayList<>();
        long startArray = System.currentTimeMillis();
        generateFeed(arrayList, amount);
        long endArray = System.currentTimeMillis();
        long timeArray = endArray - startArray;
        MyDoubleLinkedList<String> linkedList = new MyDoubleLinkedList<>();
        long startLinked = System.currentTimeMillis();
        generateFeed(linkedList, amount);
        long endLinked = System.currentTimeMillis();
        long timeLinked = endLinked - startLinked;
        System.out.println("MyArrayList add(0,item)x100000: " + timeArray + " мс");
        System.out.println("MyDoubleLinkedList add(0,item)x100000: " + timeLinked + " мс");
    }
}