package proga.classwork3_2;

import java.io.*;

public class Part3_Card {
    public static void main(String[] args) {
        StringWriter sw = new StringWriter();
        sw.write("Карточка игрока\n");
        sw.write("Ник: ShadowKnight\n");
        sw.write("Уровень: 42\n");
        sw.write("Счёт: 198400\n");
        sw.write("Статус: Онлайн\n");
        String cardText = sw.toString();
        StringReader sr = new StringReader(cardText);
        BufferedReader br = new BufferedReader(sr);
        String ss;
        int kamil = 1;
        System.out.println();
        try {
            while((ss = br.readLine()) != null) {
                System.out.println(kamil + ": " + ss);
                kamil++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}