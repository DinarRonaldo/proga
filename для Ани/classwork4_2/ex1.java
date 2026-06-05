package proga.classwork4_2;

import java.util.ArrayList;
import java.util.List;

public class ex1 {
    public static void main(String[] args) throws Exception {
        List<String> treasures = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                treasures.add("Gold");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                treasures.add("Silver");
            }
        });
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Без synchronized : " + treasures.size());

        List<String> treasuresSync = new ArrayList<>();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (treasuresSync) {
                    treasuresSync.add("Gold");
                }
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (treasuresSync) {
                    treasuresSync.add("Silver");
                }
            }
        });
        t3.start(); t4.start();
        t3.join(); t4.join();
        System.out.println("С synchronized : " + treasuresSync.size());
    }
}