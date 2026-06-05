package proga.classwork4_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LongAnalyzerMain {
    public static void main(String[] args) throws Exception {

        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\access.log"));
        List<String> allStrings = new ArrayList<>();
        String currentLine;
        while ((currentLine = fileReader.readLine()) != null) {
            allStrings.add(currentLine);
        }
        fileReader.close();

        long oneThreadStart = System.currentTimeMillis();
        int totalErrorsOne = 0;
        int totalApiOne = 0;
        for (int idx = 0; idx < allStrings.size(); idx++) {
            String str = allStrings.get(idx);
            if (str.contains("ERROR")) {
                totalErrorsOne++;
            }
            if (str.contains("/api/users")) {
                totalApiOne++;
            }
        }
        long oneThreadTime = System.currentTimeMillis() - oneThreadStart;

        // ------------- многопоточная обработка -------------
        long fourThreadsStart = System.currentTimeMillis();
        int threadCount = 4;
        int partSize = allStrings.size() / threadCount;

        List<LogAnalyzer> workers = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();

        for (int t = 0; t < threadCount; t++) {
            int leftBound = t * partSize;
            int rightBound = (t == threadCount - 1) ? allStrings.size() : (t + 1) * partSize;
            List<String> subList = allStrings.subList(leftBound, rightBound);

            LogAnalyzer worker = new LogAnalyzer(subList);
            workers.add(worker);

            Thread th = new Thread(worker);
            threadList.add(th);
            th.start();
        }

        for (Thread th : threadList) {
            th.join();
        }

        int combinedErrors = 0;
        int combinedApi = 0;
        for (LogAnalyzer worker : workers) {
            combinedErrors += worker.errorCount;
            combinedApi += worker.apiUsersCount;
        }
        long fourThreadsTime = System.currentTimeMillis() - fourThreadsStart;

        String outputMessage = "ERRORS: " + combinedErrors +
                "\n/api/users: " + combinedApi +
                "\nВремя (1 поток): " + oneThreadTime + " ms" +
                "\nВремя (4 потока): " + fourThreadsTime + " ms";

        System.out.println(outputMessage);

        FileWriter writer = new FileWriter("result_1.txt");
        writer.write(outputMessage);
        writer.close();
    }
}
