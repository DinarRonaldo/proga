package proga.classwork4_2;

public class Account {
    int id;
    int balance;
    Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    void withdraw(int amount) { balance -= amount; }
    void deposit(int amount) { balance += amount; }
}
