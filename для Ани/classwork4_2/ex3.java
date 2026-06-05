package proga.classwork4_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ex3 {
    public static void main(String[] args) throws Exception {
        LogProcessor processor = new LogProcessor();
        Thread producer = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader("access.log"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    processor.produce(line);
                }
                processor.setFinished();
            } catch (Exception e) {
                //ошибка
            }
        });
        Thread consumer = new Thread(() -> {
            int errorCount = 0;
            try {
                String line;
                while ((line = processor.consume()) != null) {
                    if (line.contains("ERROR")) {
                        errorCount++;
                    }
                }
                System.out.println("Ошибок:" + errorCount);
            } catch (Exception e) {
                //oshibka
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}