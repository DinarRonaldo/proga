package proga.classwork4_2;

import java.util.LinkedList;

public class LogProcessor {
    private LinkedList<String> buffer = new LinkedList<>();
    private int capacity = 5;
    private boolean finished = false;
    public synchronized void produce(String line) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(line);
        notifyAll();
    }
    public synchronized String consume() throws InterruptedException {
        while (buffer.isEmpty() && !finished) {
            wait();
        }
        if (!buffer.isEmpty()) {
            String line = buffer.removeFirst();
            notifyAll();
            return line;
        }
        return null;
    }
    public synchronized void setFinished() {
        finished = true;
        notifyAll();
    }
}
