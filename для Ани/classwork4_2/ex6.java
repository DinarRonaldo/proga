package proga.classwork4_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ex6 {
    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        int threadCount = 4;
        int partSize = lines.size() / threadCount;
        WordCounterSync sync = new WordCounterSync();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? lines.size() : (i + 1) * partSize;
            List<String> chunk = lines.subList(start, end);
            WordCounter worker = new WordCounter(chunk, sync);
            Thread th = new Thread(worker);
            threads.add(th);
            th.start();
        }
        for (Thread th : threads) {
            th.join();
        }
        System.out.println("Слов длиннее 3: " + sync.getTotal());
    }
}