package proga.classwork3_1;

import java.io.*;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        List<Integer> allNum = new ArrayList<>();
        List<Integer> lSum = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int lineSum = 0;
                for (String part : parts) {
                    int num = Integer.parseInt(part);
                    allNum.add(num);
                    lineSum += num;
                }
                lSum.add(lineSum);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: "+e);
        }
        int count = allNum.size();
        int sum = 0;
        int min = allNum.get(0);
        int max = allNum.get(0);
        for (int num : allNum) {
            sum+=num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double avg = (double) sum / count;
        try (PrintWriter pw = new PrintWriter(new FileWriter("stats.txt"))) {
            pw.println("count="+count);
            pw.println("sum="+sum);
            pw.println("min="+min);
            pw.println("max="+max);
            pw.println("avg="+avg);
        } catch (IOException e) {
            System.out.println("Ошибка:"+e);
        }
    }
}
