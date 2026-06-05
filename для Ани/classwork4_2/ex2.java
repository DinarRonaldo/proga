package proga.classwork4_2;

public class ex2 {
    static void transferDeadlock(Account from, Account to, int amount) {
        synchronized (from) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Ошибка:"+e);
            }
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
    static void transferSafe(Account from, Account to, int amount) {
        Account first = from.id < to.id ? from : to;
        Account second = from.id < to.id ? to : from;
        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Account A = new Account(1, 1000);
        Account B = new Account(2, 1000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                transferDeadlock(A, B, 10);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                transferDeadlock(B, A, 10);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("deadlock");
    }
}