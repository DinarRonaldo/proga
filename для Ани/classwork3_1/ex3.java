package proga.classwork3_1;

import java.io.*;

public class ex3 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("cat.jpeg"); FileOutputStream fos = new FileOutputStream("cat-copy.jpeg")) {
            byte[] bufer = new byte[4096];
            int bytesRead = 0;
            while ((bytesRead = fis.read(bufer)) != -1) {
                fos.write(bufer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Ошибка:"+e);
        }
    }
}