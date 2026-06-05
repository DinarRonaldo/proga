package proga.homework1_5;

public class SecretObjectTest {
    public static void main(String[] args) {
        MyHashSet<Visitor> set = new MyHashSetImpl<>();
        Visitor vasily = new Visitor("Камиль", "123");
        set.add(vasily);
        System.out.println("Добавили Камиля с passId=123");
        System.out.println("contains(Камиль): " + set.contains(vasily));
        vasily.setPassId("999");
        System.out.println("Изменили passId на 999");
        System.out.println("contains(Камиль): " + set.contains(vasily));
        if (!set.contains(vasily)) {
            System.out.println("Ожидаем false - объект потерялся в HashSet");
        }
    }
}