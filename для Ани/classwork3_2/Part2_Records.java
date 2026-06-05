package proga.classwork3_2;

import java.io.*;

public class Part2_Records {
    public static void main(String[] args) {
        int[] scores = {198400, 175000, 160200, 145000, 132000};
        String[] nicknames = {"Bo4ok", "Fonbet", "Olegkizaru", "Grigoriylyahov", "Artemnikitin"};

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("src\\proga\\classwork3_2\\records.dat"));
            for (int i = 0; i < 5; i++){
                dos.writeInt(scores[i]);
                dos.writeUTF(nicknames[i]);
            }
            dos.close();
        } catch (IOException e){
            System.out.println("Ошибка: " + e);
        }

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("src\\proga\\classwork3_2\\records.dat"));
            System.out.println("Топ рекордов: ");
            for (int i = 0; i < 5; i++) {
                int score = dis.readInt();
                String name = dis.readUTF();
                int kamilka = i + 1;
                System.out.println(" #" + kamilka + " " + score + " - "  + name);
            }
            dis.close();
        } catch (FileNotFoundException e){
            System.out.println("Ошибка: " + e);
        } catch (IOException e){
            System.out.println("Ошибка: " + e);
        }
    }
}
