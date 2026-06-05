package proga.classwork3_2;

import java.io.*;

public class Part1_Profiles {
    public static void main(String[] args) {
        PlayerProfile p1 = new PlayerProfile("Aflisa", 10, 30000, true);
        PlayerProfile p2 = new PlayerProfile("Kuzmin+rep", 21, 43000, false);
        PlayerProfile p3 = new PlayerProfile("Piter", 52, 52000, true);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\proga\\classwork3_2\\profiles.dat"))) {
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        System.out.println();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\proga\\classwork3_2\\profiles.dat"))) {
            while (true) {
                try {
                    PlayerProfile p = (PlayerProfile) ois.readObject();
                    System.out.println("[ПРОФИЛЬ] nickname " + p.getNickname() + " lvl: " + p.getLevel() + " score: " + p.getScore() + " ONLINE STATUS: " + p.isOnline());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка");
        }
    }
}
