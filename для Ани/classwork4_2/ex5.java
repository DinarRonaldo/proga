package proga.classwork4_2;

public class ex5 {
    public static void main(String[] args) throws Exception {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.put(i);
                    System.out.println("A: " + i);
                } catch (Exception e) {
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    int val = queue.take();
                    System.out.println("B: " + val);
                    Thread.sleep(50);
                } catch (Exception e) {
                }
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}