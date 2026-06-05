package proga.classwork4_2;

import java.util.List;

public class WordCounter implements Runnable {
    private List<String> chunk;
    private int localCount = 0;
    private WordCounterSync sync;
    public WordCounter(List<String> chunk, WordCounterSync sync) {
        this.chunk = chunk;
        this.sync = sync;
    }
    @Override
    public void run() {
        for (String line : chunk) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() > 3) {
                    localCount++;
                }
            }
        }
        sync.add(localCount);
    }
}