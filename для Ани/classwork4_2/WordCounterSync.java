package proga.classwork4_2;

public class WordCounterSync {
    private int totalCount = 0;
    public synchronized void add(int count) {
        totalCount += count;
    }
    public int getTotal() {
        return totalCount;
    }
}