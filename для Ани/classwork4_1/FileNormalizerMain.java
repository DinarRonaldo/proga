package proga.classwork4_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileNormalizerMain {
    public static void main(String[] args) {
        File inputFolder = new File("input");
        File outputFolder = new File("output");
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }
        File[] files = inputFolder.listFiles((dir, name) -> name.endsWith(".txt"));
        List<FileNormalizer> workers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (File file : files) {
            File outputFile = new File(outputFolder, file.getName());
            FileNormalizer worker = new FileNormalizer(file, outputFile);
            workers.add(worker);
            Thread th = new Thread(worker);
            threads.add(th);
            th.start();
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка:"+e);
            }
        }
        int totalBefore = 0;
        int totalAfter = 0;
        for (FileNormalizer worker : workers) {
            totalBefore += worker.linesBC;
            totalAfter += worker.linesAC;
        }
        System.out.println("Обработано файлов: " + files.length);
        System.out.println("Строк до: " + totalBefore);
        System.out.println("Строк после: " + totalAfter);
        try (FileWriter fw = new FileWriter("result_2.txt")) {
            fw.write("Обработано файлов: " + files.length);
            System.out.println();
            fw.write("Строк до: " + totalBefore);
            System.out.println();
            fw.write("Строк после: " + totalAfter);
        } catch (IOException e) {
            System.out.println("Ошибка:"+e);
        }
    }
}