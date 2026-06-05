package proga.classwork3_1;

import java.io.*;

public class ex4 {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("task_4_win.txt"), "windows-1251"); OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf8.txt"), "UTF-8")) {
            char[] bufer = new char[4096];
            int charsRead = 0;
            while ((charsRead = isr.read(bufer)) != -1) {
                osw.write(bufer, 0, charsRead);
            }
        } catch (IOException e) {
            System.out.println("Ошибка:"+e);
        }
    }
}