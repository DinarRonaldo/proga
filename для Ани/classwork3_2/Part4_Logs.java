package proga.classwork3_2;

import java.io.*;

public class Part4_Logs {
    public static void main(String[] args) {
        InputStream in1 = null;
        InputStream in2 = null;
        SequenceInputStream sis = null;
        InputStreamReader isr = null;
        try {
            in1 = new FileInputStream("src\\proga\\classwork3_2\\session1.log");
            in2 = new FileInputStream("src\\proga\\classwork3_2\\session2.log");
            sis = new SequenceInputStream(in1, in2);
            isr = new InputStreamReader(sis, "UTF-8");

            int b;
            while ((b = isr.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.out.println("Oshibka: " + e);
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (sis != null) {
                    sis.close();
                }
                if (in1 != null) {
                    in1.close();
                }
                if (in2 != null) {
                    in2.close();
                }
            } catch (IOException e) {
                System.out.println("Oshibka: " + e);
            }
        }
    }
}