package proga.classwork3_1;

import java.io.*;
import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String group = parts[3];
                students.add(new Student(id, name, age, group));
            }
        } catch (IOException e) {
            System.out.println("Ошибка:"+e);
        }
        System.out.println("Список студентов:");
        for (Student s : students) {
            System.out.println("- " + s);
        }

        System.out.println();
        System.out.println("Количество студентов по группам:");
        Map<String, Integer> groupCount = new HashMap<>();
        for (Student s : students) {
            groupCount.put(s.getGroup(), groupCount.getOrDefault(s.getGroup(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : groupCount.entrySet()) {
            System.out.println(" - Группа " + entry.getKey() + ": " + entry.getValue() + " студентов");
        }
    }
}