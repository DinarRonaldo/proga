package proga.classwork4_1;

import java.util.List;

public class LogAnalyzer implements Runnable {
    private final List<String> chunk;
    int errorCount = 0;
    int apiUsersCount = 0;
    public LogAnalyzer(List<String> chunk) {
        this.chunk = chunk;
    }
    @Override
    public void run() {
        for (String line : chunk) {
            if (line.contains("ERROR")) {
                errorCount++;
            }
            if (line.contains("/api/users")) {
                apiUsersCount++;
            }
        }
    }
}