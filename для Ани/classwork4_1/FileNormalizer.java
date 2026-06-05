package proga.classwork4_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileNormalizer implements Runnable {
    private File inputFile;
    private File outputFile;
    int linesBC = 0;
    int linesAC = 0;
    public FileNormalizer(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                linesBC++;
                if (!line.isBlank()) {
                    String processed = line.strip().toLowerCase();
                    pw.println(processed);
                    linesAC++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка:"+e);
        }
    }
}