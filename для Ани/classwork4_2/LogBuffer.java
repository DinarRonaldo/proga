package proga.classwork4_2;

import java.util.LinkedList;

public class LogBuffer {
    private LinkedList<String> buffer = new LinkedList<>();
    private int capacity = 10;
    private int poisonCount = 0;
    private int consumersCount;

    public LogBuffer(int consumersCount) {
        this.consumersCount = consumersCount;
    }

    public synchronized void produce(String line) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(line);
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (buffer.isEmpty() && poisonCount < consumersCount) {
            wait();
        }
        if (!buffer.isEmpty()) {
            String line = buffer.removeFirst();
            notifyAll();
            return line;
        }
        return null;
    }

    public synchronized void poison() {
        poisonCount++;
        notifyAll();
    }
}