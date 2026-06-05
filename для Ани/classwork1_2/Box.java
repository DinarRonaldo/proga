package proga.classwork1_2;

public class Box<T extends Number> {
    private T amy;
    public Box(T amy) {
        this.amy = amy;
    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>(72);
        Box<Double> box2 = new Box<>(5.15);
        System.out.println(box1.getClass() == box2.getClass());
        System.out.println("оба стали Number, String положить нельзя тк бокс знает про интеджер и дабл");
    }
}
