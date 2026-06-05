package proga.classwork4_2;

import java.io.BufferedReader;
import java.io.FileReader;

public class ex4 {
    public static void main(String[] args) throws Exception {
        LogBuffer buffer = new LogBuffer(2);
        Thread producer = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader("access.log"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    buffer.produce(line);
                }
                buffer.poison();
                buffer.poison();
            } catch (Exception e) {
                //oshibka
            }
        });
        Thread consumer1 = new Thread(() -> {
            int count = 0;
            try {
                String line;
                while ((line = buffer.consume()) != null) {
                    count++;
                }
                System.out.println("Consumer 1 обработал: " + count + " строк");
            } catch (Exception e) {
            }
        });
        Thread consumer2 = new Thread(() -> {
            int count = 0;
            try {
                String line;
                while ((line = buffer.consume()) != null) {
                    count++;
                }
                System.out.println("Consumer 2 обработал: " + count + " строк");
            } catch (Exception e) {
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
        producer.join();
        consumer1.join();
        consumer2.join();
    }
}